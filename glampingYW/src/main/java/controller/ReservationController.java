package controller;

import java.io.File;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import model.Product;
import model.RPhoto;
import model.Room;
import model.Seller;
import model.Reservation;
import service.BoardserviceImpl;
import service.ProductServiceImp;
import service.RoomServiceImp;
import service.ReservationServiceImp;
import service.ReviewServiceImp;


@Controller
public class ReservationController {
	
	@Autowired
	private ProductServiceImp proService;
	@Autowired
	private RoomServiceImp rmService;
	@Autowired
	private BoardserviceImpl logService;
	@Autowired
	private ReservationServiceImp reserveService;
	@Autowired
	private ReviewServiceImp revService;

	//++ 예약정보 결제전페이지로 이동
	@RequestMapping("reserveprevious")
	public String reserveprevious(int pro_no, int rm_no, String checkInS, String checkOutS,
									String res_tname, int res_pno, int sel_count2, int res_price, Model model) throws Exception {
		
		Product pro = proService.getprodetail(pro_no);
		Seller sel = logService.usercheck1(pro.getSel_id());
		Room rm = rmService.getrmdetail(rm_no);
		List<RPhoto> rplist = rmService.getrplist(rm_no);
	
		model.addAttribute("checkInS", checkInS);
		model.addAttribute("checkOutS", checkOutS);
		model.addAttribute("res_tname", res_tname);
		model.addAttribute("res_pno", res_pno);
		model.addAttribute("sel_count2", sel_count2);
		model.addAttribute("res_price", res_price);
		model.addAttribute("pro", pro);
		model.addAttribute("sel", sel);
		model.addAttribute("rm", rm);
		model.addAttribute("rplist", rplist);
				
		return "reservation/reserveprevious";
	}
	

	
	
	//++ 예약입력실행
	@RequestMapping("reservedo")
	public String reservedo(HttpSession session, Reservation res, String ckin, String ckout, Model model) throws Exception {
		
		String mem_id = (String) session.getAttribute("id");
		res.setMem_id(mem_id);
				
		String ckins = ckin+" 00:00:00.0";
		String ckouts = ckout+" 00:00:00.0";		
		java.sql.Timestamp res_ckin = java.sql.Timestamp.valueOf(ckins);
		java.sql.Timestamp res_ckout = java.sql.Timestamp.valueOf(ckouts);
		res.setRes_ckin(res_ckin);
		res.setRes_ckout(res_ckout);
		
		int reservation_result = reserveService.resinsertdo(res);
		model.addAttribute("reservation_result", reservation_result);
		return "reservation/okResult";
	}
	
	

	

	
	
	//++ ajax 호출시 예약된 날짜 리턴
	@ResponseBody
	@RequestMapping("getreslist")
	public List<Map<String, Object>> getreslistdo(int rm_no) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> maps = new HashMap<String,Object>();
		
		List<Reservation> reslist = reserveService.getreslist(rm_no);		
		DateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Reservation res : reslist) {
			String cki = s.format(res.getRes_ckin());
			String cko = s.format(res.getRes_ckout());
			
			Date endDateEx = s.parse(cko);
					
			//endDate 1일 앞으로 밀기
			Calendar day = Calendar.getInstance();
			day.setTime(endDateEx);
			day.add(Calendar.DAY_OF_MONTH , -1);
			String cko2 = s.format(day.getTime());
			//endDate 1일 앞으로 밀기
			
			Date startDate = s.parse(cki);	
			Date endDate = s.parse(cko2);
			
			
			Date currentDate = startDate;
			Date currentDate2 = startDate;
			
			//ckin날짜 시작점 set 1일 앞으로 밀기
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.DAY_OF_MONTH, -1);
			//ckin날짜 시작점 set 1일 앞으로 밀기
			
			
			//chout날짜 시작점 set
			Calendar d = Calendar.getInstance();				
			d.setTime(currentDate2);	
			//chout날짜 시작점 set
			
				
			
			//1박 일경우
			if(currentDate.compareTo(endDate) == 0) {
				c.add(Calendar.DAY_OF_MONTH, 1);
				d.add(Calendar.DAY_OF_MONTH, 1);
				String cktime = s.format(c.getTime());	
				String cktimeout = s.format(d.getTime());
				currentDate = c.getTime();			
				map = new HashMap<String,Object>();
				map.put("cktime", cktime);	
				map.put("cktimeout", cktimeout);
				list.add(map);
			}
			
			//2박 이상의 경우
			while (currentDate.compareTo(endDate) < 0) {			
				c.add(Calendar.DAY_OF_MONTH, 1);
				d.add(Calendar.DAY_OF_MONTH, 1);
				String cktime = s.format(c.getTime());	
				String cktimeout = s.format(d.getTime());
				currentDate = c.getTime();			
				map = new HashMap<String,Object>();
				map.put("cktime", cktime);	
				map.put("cktimeout", cktimeout);
				list.add(map);				
			}					
		}
		
		return list;
	}

	
	//++ 나의 예약페이지
	@RequestMapping("myreservation")
	public String myreservation(HttpSession session, Model model) throws Exception {
		
		String mem_id = (String) session.getAttribute("id");
		
		reserveService.update_res_s(mem_id);
		
		List<Reservation> reslist2 = reserveService.getmyreslist(mem_id);	
		List<Reservation> reslist = new ArrayList<Reservation>();

		List<Product> prolist = new ArrayList<Product>();	
		List<Seller> sellist = new ArrayList<Seller>();		
		List<Room> rmlist = new ArrayList<Room>();
		List<RPhoto> rplistall = new ArrayList<RPhoto>();
		
		for(Reservation res : reslist2) {
			Product pro = proService.getprodetail(res.getPro_no());
			pro.setRes_no(res.getRes_no());
			Seller sel = logService.usercheck1(pro.getSel_id());
			sel.setRes_no(res.getRes_no());		
			prolist.add(pro);
			sellist.add(sel);	
			
			Room rm = rmService.getrmdetail(res.getRm_no()); 
			if(rm == null) {   // 예약했던 객싫이 삭제 되었을때 예약항목 페이지 처리
				Room rmdemo = new Room();
				rmdemo.setRes_no(res.getRes_no());
				rmlist.add(rmdemo);
			} else {
				rm.setRes_no(res.getRes_no());	
				rmlist.add(rm);
				
				List<RPhoto> rplist = rmService.getrplist(rm.getRm_no());
				for(RPhoto rp : rplist) {
					rp.setRes_no(res.getRes_no());
					rplistall.add(rp);	
				}
			}
								
			Timestamp cki = res.getRes_ckin();
			Timestamp cko = res.getRes_ckout();
			long t1 = (cko.getTime() - cki.getTime())/ (24 * 60 * 60 * 1000);
			int t = Long.valueOf(t1).intValue();
			res.setDaygap(t);
			reslist.add(res);
																			
		}
		

		
		model.addAttribute("reslist", reslist);
		model.addAttribute("prolist", prolist);
		model.addAttribute("sellist", sellist);
		model.addAttribute("rmlist", rmlist);
		model.addAttribute("rplistall", rplistall);

		return "reservation/myreservationview";
	}
	
	//예약취소
	@RequestMapping("deletereservation")
	public String deletereservation(int res_no, Model model) throws Exception {
		int delreservation_result = reserveService.delreserve(res_no);
		
		model.addAttribute("delreservation_result", delreservation_result);
		return "reservation/okResult";
	}
	
	//달력 불러오기(판매자용)
	@RequestMapping("getrescalendar")
	public String getrescalendar(int pro_no, Model model) throws Exception {
		List<Reservation> delreslist = reserveService.getdelreslist(pro_no);
		int del_no = delreslist.size();  // 예약취솟 숫자 보여주기
		model.addAttribute("del_no", del_no);
		model.addAttribute("pro_no", pro_no);
		return "reservation/rescalendar";
	}
	
	//달력 불러오기(일반인용)
	@RequestMapping("getmemcalendar")
	public String getmemcalendar(int pro_no, Model model) throws Exception {
		model.addAttribute("pro_no", pro_no);
		return "reservation/memcalendar";
	}
	
	//++ ajax rmlist에 resday 담아 calendar에 리턴
	@ResponseBody
	@RequestMapping("getrmresday")
	public List<Map<String, Object>> getrmresday(int pro_no) throws Exception {
		List<Map<String, Object>> pro_allreslist = new ArrayList<Map<String, Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		List<Room> rmlist = rmService.getrmlist(pro_no);

		DateFormat s = new SimpleDateFormat("yyyy-MM-d");

	
		for(Room rm : rmlist) {		
			map = new HashMap<String,Object>();
			map.put("rm_no", rm.getRm_no());
			map.put("rm_tname", rm.getRm_tname());	
			map.put("rm_s", rm.getRm_s());	
			List<Reservation> reslList = reserveService.getreslist(rm.getRm_no());
	
			int i =0;
				
			int[] resnolist = new int[1000];   //대략 3년치 예약일자 메모리, 방법찾으면 유동적으로 늘릴 수 있도록 할것
			String[] cklist = new String[1000];   //대략 3년치 예약일자 메모리, 방법찾으면 유동적으로 늘릴 수 있도록 할것 
			
			for(Reservation res : reslList) {

				
				String cki = s.format(res.getRes_ckin());
				String cko = s.format(res.getRes_ckout());
				
				Date startDate = s.parse(cki);
			
				//ckin날짜 시작점 set 1일 앞으로 밀기
				Calendar c = Calendar.getInstance();
				c.setTime(startDate);
				c.add(Calendar.DAY_OF_MONTH, -1);
				//ckin날짜 시작점 set 1일 앞으로 밀기
				
				Date startDateEx = s.parse(cki);
				Date endDateEx = s.parse(cko);		
				
				//endDate 1일 앞으로 밀기
				Calendar day = Calendar.getInstance();
				day.setTime(endDateEx);
				day.add(Calendar.DAY_OF_MONTH , -1);
				String cko2 = s.format(day.getTime());
				//endDate 1일 앞으로 밀기
																					
				Date endDate = s.parse(cko2);
				
				//일수길이 구하기
				Calendar ex = Calendar.getInstance();
				ex.setTime(startDateEx);
				int j = 0;
				while(startDateEx.compareTo(endDateEx) < 0) {
					ex.add(Calendar.DAY_OF_MONTH, 1);
					startDateEx = ex.getTime();
					j++;
				}
				

							
				//1박 일경우
				if(startDate.compareTo(endDate) == 0) {
					c.add(Calendar.DAY_OF_MONTH, 1);
					String cktime = s.format(c.getTime());	
					startDate = c.getTime();				
					
					resnolist[i] = res.getRes_no();
					cklist[i] = cktime;			
					i++;	
				}
				
				//2박 이상의 경우
				while (startDate.compareTo(endDate) < 0) {			
					c.add(Calendar.DAY_OF_MONTH, 1);
					String cktime = s.format(c.getTime());	
					startDate = c.getTime();	
					
					resnolist[i] = res.getRes_no();
					cklist[i] = cktime;	

					i++;			
				}	
													
			}
			map.put("res_no", resnolist);
			map.put("res_ckin", cklist);
			map.put("iplus", i);
			pro_allreslist.add(map);
			

		}
									
		return pro_allreslist;
	}
	
	//날짜와 객실에 예약된 정보 불러오기
	@RequestMapping("resdetail")
	public String resdetail(int res_no, Model model) throws Exception {
		Reservation res = reserveService.resdetailone(res_no);
		Product pro = proService.getprodetail(res.getPro_no());
		Seller sel = logService.usercheck1(pro.getSel_id());
		
		Timestamp cki = res.getRes_ckin();
		Timestamp cko = res.getRes_ckout();
		long t1 = (cko.getTime() - cki.getTime())/ (24 * 60 * 60 * 1000);
		int t = Long.valueOf(t1).intValue();
		res.setDaygap(t);
		
		model.addAttribute("res", res);
		model.addAttribute("pro", pro);
		model.addAttribute("sel", sel);
		return "reservation/selresdetail";
	}

	
	//에약취소신청 리스트 불러오기
	@RequestMapping("show_delres")
	public String show_delres(int pro_no, Model model) throws Exception {

		List<Reservation> delreslist2 = reserveService.getdelreslist(pro_no);	
		List<Reservation> delreslist = new ArrayList<Reservation>();

		List<Product> prolist = new ArrayList<Product>();	
		List<Seller> sellist = new ArrayList<Seller>();		

		
		for(Reservation res : delreslist2) {
			Product pro = proService.getprodetail(res.getPro_no());
			pro.setRes_no(res.getRes_no());
			Seller sel = logService.usercheck1(pro.getSel_id());
			sel.setRes_no(res.getRes_no());		
			prolist.add(pro);
			sellist.add(sel);	
			
		
			Timestamp cki = res.getRes_ckin();
			Timestamp cko = res.getRes_ckout();
			long t1 = (cko.getTime() - cki.getTime())/ (24 * 60 * 60 * 1000);
			int t = Long.valueOf(t1).intValue();
			res.setDaygap(t);
			delreslist.add(res);
												
		}
		int del_no = delreslist.size();  // 예약취솟 숫자 보여주기
		model.addAttribute("del_no", del_no);
		
		model.addAttribute("delreslist", delreslist);
		model.addAttribute("prolist", prolist);
		model.addAttribute("sellist", sellist);
		
		return "reservation/sel_delreslist";
	}

	//에약취소신청 거부
	@RequestMapping("return_reservation")
	public String return_reservation(int res_no, Model model) throws Exception {
		Reservation res = reserveService.resdetailone(res_no);
		int pro_no = res.getPro_no();
		
		int return_reservation_result = reserveService.return_reserve(res_no);

		model.addAttribute("pro_no", pro_no);
		model.addAttribute("return_reservation_result", return_reservation_result);
		return "reservation/okResult";
	}
	
	//에약 완전삭제 + 리뷰삭제
	@RequestMapping("termination_reservation")
	public String termination_reservation(int res_no, Model model) throws Exception {
		Reservation res = reserveService.resdetailone(res_no);
		int pro_no = res.getPro_no();
		
		revService.terminate_review(res_no);  // res_no와 일치하는 리뷰 먼저삭제
		int terminate_reservation_result = reserveService.terminate_reserve(res_no);
		
		model.addAttribute("pro_no", pro_no);
		model.addAttribute("terminate_reservation_result", terminate_reservation_result);
		return "reservation/okResult";
	}
	
	
	
}
