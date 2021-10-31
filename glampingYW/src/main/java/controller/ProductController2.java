package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Member;
import model.PPhoto;
import model.Product;
import model.Reservation;
import model.Review;
import model.Room;
import service.pphoto.PPhotoService;
import service.product.ProductService;
import service.review.ReviewService;
import service.room.RoomService;
import service.BoardserviceImpl;
import service.ReservationService;


@Controller
public class ProductController2 {
	@Autowired
	private ProductService pros;
	@Autowired
	private PPhotoService pps;
	@Autowired
	private ReviewService res;
	@Autowired
	private RoomService rms;
	@Autowired
	private ReservationService reser;
	@Autowired
	private BoardserviceImpl boardservice;

	//메인 페이지
	@RequestMapping("/main")
	public String main(Product product, Model model) {
		System.out.println("main!");
		List<Product> listTop = pros.listTop(product);
		
		// 별점 평균 및 최저가격 구하기
		for(int k = 0; k <listTop.size(); k++) {
			Product pro = listTop.get(k);
			
			// 별점 평균, 후기 개수
			List<Review> relist = res.list(pro.getPro_no());
			int retotal = res.getTotal(pro.getPro_no());

			pro.setRv_total(retotal);
			
			int star = 0;
			double star_avg = 0;
			int min = 0;
			
			if(relist.size() != 0) {
				
				for(int i = 0; i <relist.size(); i++) {
					Review re = relist.get(i);
					
					star += re.getRev_star();
				}
				
				star_avg = Math.round((star/ relist.size()*10)/10.0);
				pro.setStar_avg(star_avg);
			}
			
			// 최저가
			List<Room> rmlist = rms.list(pro.getPro_no());
			
			for(int j = 0; j <rmlist.size(); j++) {
				Room rm = rmlist.get(j);
				
				if(j > 0) {
					min	= Math.min(min, rm.getRm_price());
				} else {
					min = rm.getRm_price();
				}
			}
			pro.setRev_cnt(min);
			
		}
		
		model.addAttribute("listTop", listTop);
		
		List<Product> listBest = pros.listBest(product);
		
		// 별점 평균 및 최저가격 구하기
		for(int k = 0; k <listBest.size(); k++) {
			Product pro = listBest.get(k);
			
			// 별점 평균, 후기 개수
			List<Review> relist = res.list(pro.getPro_no());
			int retotal = res.getTotal(pro.getPro_no());

			pro.setRv_total(retotal);
			
			int star = 0;
			double star_avg = 0;
			int min = 0;
			
			if(relist.size() != 0) {
				
				for(int i = 0; i <relist.size(); i++) {
					Review re = relist.get(i);
					
					star += re.getRev_star();
				}
				
				star_avg = Math.round((star/ relist.size()*10)/10.0);
				pro.setStar_avg(star_avg);
			}
			
			// 최저가
			List<Room> rmlist = rms.list(pro.getPro_no());
			
			for(int j = 0; j <rmlist.size(); j++) {
				Room rm = rmlist.get(j);
				
				if(j > 0) {
					min	= Math.min(min, rm.getRm_price());
				} else {
					min = rm.getRm_price();
				}
			}
			pro.setRev_cnt(min);
			
		}
		
		model.addAttribute("listBest", listBest);
		
		return "/product/main";
	}
	
	//검색 페이지 이동(page 없을 떄)
	@RequestMapping("/prolist")
	public String initList() {
		return "redirect:prolist/pageNum/1";
	}
	
	//검색 페이지
	@RequestMapping(value ="/prolist/pageNum/{pageNum}", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@PathVariable String pageNum, String checkInS, String checkOutS, String capS, String regionS, Product product, Model model) {
		// 페이징
		final int rowPerPage = 20;
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		product.setStartRow(startRow);
		product.setEndRow(endRow);
		
		// 지역 입력
		product.setRegion(regionS);
		
		// 인원 수 형변환 (String to int)
		if(capS == null || capS.equals("")) {
			capS = "0";
		}
		
		int capNum = Integer.parseInt(capS);
		product.setCap(capNum);		
			
		// 체크인, 체크아웃 형변환 (String to Timestamp)
		if(checkInS == "" && checkOutS == "") {
			checkInS = null;
			checkOutS = null;
		}
		
		if(checkInS != null && checkOutS != null) {
			
			String cis = checkInS + " 00:00:00";
			String cos = checkOutS + " 00:00:00";
			
			Timestamp checkInT = Timestamp.valueOf(cis);
			Timestamp checkOutT = Timestamp.valueOf(cos);
			
			product.setCheckIn(checkInT);
			product.setCheckOut(checkOutT);
		}
		
		// 페이지 수
		int total = pros.getTotal(product);
		int pageCount = (total + rowPerPage - 1) / rowPerPage;
		model.addAttribute("pageCount", pageCount);
		
		List<Product> list = pros.list(product); 
		
		// 별점 평균 및 최저가격 구하기
		for(int k = 0; k <list.size(); k++) {
			Product pro = list.get(k);
			
			// 별점 평균, 후기 개수
			List<Review> relist = res.list(pro.getPro_no());
			int retotal = res.getTotal(pro.getPro_no());

			pro.setRv_total(retotal);
			
			int star = 0;
			double star_avg = 0;
			int min = 0;
			
			if(relist.size() != 0) {
				
				for(int i = 0; i <relist.size(); i++) {
					Review re = relist.get(i);
					
					star += re.getRev_star();
				}
				
				star_avg = Math.round((star/ relist.size()*10)/10.0);
				pro.setStar_avg(star_avg);
			}
			
			// 최저가
			List<Room> rmlist = rms.list(pro.getPro_no());
			
			for(int j = 0; j <rmlist.size(); j++) {
				Room rm = rmlist.get(j);
				
				if(j > 0) {
					min	= Math.min(min, rm.getRm_price());
				} else {
					min = rm.getRm_price();
				}
			}
			pro.setRev_cnt(min);
			
		}
		
		model.addAttribute("list", list);
				
		model.addAttribute("pageNum", pageNum);
		//검색
		model.addAttribute("regionS", regionS);
		model.addAttribute("checkInS", checkInS);
		model.addAttribute("checkOutS", checkOutS);
		model.addAttribute("cap", product.getCap());
		model.addAttribute("keyword", product.getKeyword());
		
		return "/product/prolist";
	}
	
	// 검색 무한 스크롤 추가 페이지
	@RequestMapping("/fetchprolist")
	public String fetchList(String pageNum, String checkInS, String checkOutS, String capS, String regionS, Product product, Model model) {
		// 페이징
		final int rowPerPage = 20;
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "2";
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		product.setStartRow(startRow);
		product.setEndRow(endRow);

		// 지역 입력
		product.setRegion(regionS);
		
		// 인원 수 형변환 (String to int)
		if(capS == null || capS.equals("")) {
			capS = "0";
		}
		
		int capNum = Integer.parseInt(capS);
		product.setCap(capNum);
			
		// 체크인, 체크아웃 형변환 (String to Timestamp)
		if(checkInS == "" && checkOutS == "") {
			checkInS = null;
			checkOutS = null;
		}
		
		if(checkInS != null && checkOutS != null) {
			
			String cis = checkInS + " 00:00:00";
			String cos = checkOutS + " 00:00:00";
			
			Timestamp checkInT = Timestamp.valueOf(cis);
			Timestamp checkOutT = Timestamp.valueOf(cos);
			
			product.setCheckIn(checkInT);
			product.setCheckOut(checkOutT);
		}
		
			
		List<Product> list = pros.list(product); 
		
		// 별점 평균 및 최저가격 구하기
		for(int k = 0; k <list.size(); k++) {
			Product pro = list.get(k);
			
			// 별점 평균, 후기 개수
			List<Review> relist = res.list(pro.getPro_no());
			int retotal = res.getTotal(pro.getPro_no());
			pro.setRv_total(retotal);
			
			int star = 0;
			double star_avg = 0;
			int min = 0;
			
			if(relist.size() != 0) {
				
				for(int i = 0; i <relist.size(); i++) {
					Review re = relist.get(i);
					
					star += re.getRev_star();
				}
				
				star_avg = Math.round((star/ relist.size()*10)/10.0);
				pro.setStar_avg(star_avg);
			}
			
			// 최저가
			List<Room> rmlist = rms.list(pro.getPro_no());
			
			for(int j = 0; j <rmlist.size(); j++) {
				Room rm = rmlist.get(j);
				
				if(j > 0) {
					min	= Math.min(min, rm.getRm_price());
				} else {
					min = rm.getRm_price();
				}
			}
			pro.setRev_cnt(min);
			
		}
		
		model.addAttribute("list", list);
		
		return "/product/fetchprolist";
	}
	
	// 상품 상세 페이지(날짜, 인원 미선택)
	@RequestMapping("/proView/pro_no/{pro_no}")
	public String initProView(@PathVariable int pro_no, Model model) throws Exception {
		Product product = pros.proview(pro_no);
		
		//해당 상품 사진 구해오기
		List<PPhoto> pplist = pps.list(pro_no);
		
		//상세 정보 줄바꿈
		String intro = product.getPro_intro().replace("\n", "<br>");
		
		//편의 시설 배열 변환
		String c = product.getPro_con();
		String[] con = c.split("-");
		
		model.addAttribute("pplist", pplist);
		model.addAttribute("product", product);
		model.addAttribute("intro", intro);
		model.addAttribute("con", con);
		
		List<Room> rmlist = rms.list(pro_no);
		
		model.addAttribute("rmlist", rmlist);
		
		//리뷰
		List<Review> relists = res.list(pro_no);
		List<Review> relist = new ArrayList<Review>();
		for(Review re : relists) {
			Member mem = boardservice.revuserfind(re.getMem_id());
			re.setMem_pic(mem.getMem_pic());
			relist.add(re);
		}
			
		model.addAttribute("relist", relist);
		
		int retotal = res.getTotal(pro_no);
		
		product.setRv_total(retotal);
		
		int star = 0;
		double star_avg = 0;
		int min = 0;
		
		if(relist.size() != 0) {
			
			for(int i = 0; i <relist.size(); i++) {
				Review re = relist.get(i);
				
				star += re.getRev_star();
			}
			
			star_avg = Math.round((star/ relist.size()*10)/10.0);
			product.setStar_avg(star_avg);
		}
		model.addAttribute("retotal", retotal);
		model.addAttribute("star_avg", star_avg);
		
		return "/product/proview";
	}
	
	// 상품 상세 페이지
	@RequestMapping("/proView/pro_no/{pro_no}/checkInS/{checkInS}/checkOutS/{checkOutS}")
	public String proView(@PathVariable int pro_no, @PathVariable String checkInS, @PathVariable String checkOutS, Model model) throws Exception {
		Product product = pros.proview(pro_no);
		
		//해당 상품 사진 구해오기
		List<PPhoto> pplist = pps.list(pro_no);
		
		//상세 정보 줄바꿈
		String intro = product.getPro_intro().replace("\n", "<br>");
		
		//편의 시설 배열 변환
		String c = product.getPro_con();
		String[] con = c.split("-");
			
		
		
		model.addAttribute("pplist", pplist);
		model.addAttribute("product", product);
		model.addAttribute("intro", intro);
		model.addAttribute("con", con);
		
		model.addAttribute("checkInS", checkInS);
		model.addAttribute("checkOutS", checkOutS);
		
		List<Room> rmlist = rms.list(pro_no);
		
		model.addAttribute("rmlist", rmlist);
		
		//리뷰
		List<Review> relists = res.list(pro_no);
		List<Review> relist = new ArrayList<Review>();
		for(Review re : relists) {
			Member mem = boardservice.revuserfind(re.getMem_id());
			re.setMem_pic(mem.getMem_pic());
			relist.add(re);
		}
			
		model.addAttribute("relist", relist);
		
		int retotal = res.getTotal(pro_no);
		
		product.setRv_total(retotal);
		
		int star = 0;
		double star_avg = 0;
		int min = 0;
		
		if(relist.size() != 0) {
			
			for(int i = 0; i <relist.size(); i++) {
				Review re = relist.get(i);
				
				star += re.getRev_star();
			}
			
			star_avg = Math.round((star/ relist.size()*10)/10.0);
			product.setStar_avg(star_avg);
		}
		model.addAttribute("retotal", retotal);
		model.addAttribute("star_avg", star_avg);
		
		
		
		return "/product/proview";
	}
	
	
	
	
}
