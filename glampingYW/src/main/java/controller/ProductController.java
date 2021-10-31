package controller;

import java.io.File;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

import model.Member;
import model.PPhoto;
import model.Product;
import model.RPhoto;
import model.Reservation;
import model.Review;
import model.Room;
import model.Seller;
import service.BoardserviceImpl;
import service.ProductServiceImp;
import service.RoomServiceImp;
import service.ReviewServiceImp;
import service.ReservationServiceImp;

@Controller
public class ProductController {
	
	@Autowired
	private ProductServiceImp proService;
	@Autowired
	private RoomServiceImp rmService;
	@Autowired
	private BoardserviceImpl boardservice;
	@Autowired
	private ReviewServiceImp revService;
	@Autowired
	private ReservationServiceImp resService;

	/*
	 * // ++인덱스에서 마이페이지데모로 이동(삭제예정)++
	 * 
	 * @RequestMapping("mypagedemo") public String mypagedemo(HttpSession session,
	 * Model model){ System.out.println("마이페이지데모로 이동"); String sel_id = "pama";
	 * 
	 * session.setAttribute("sel_id", sel_id);
	 * 
	 * return "product/mypagedemo"; }
	 */
	
	

	
	// ++상품등록페이지로 이동++
	@RequestMapping("proinsertform")
	public String proinsertform(){
		System.out.println("상품등록페이지로 이동");			
		return "product/proinsertform";
	}
	
	// ++상품등록++
	@RequestMapping("proinsert")
	public String proinsert(@RequestParam("pro_pic1") MultipartFile mf, @RequestParam("pp_name1") MultipartFile[] pp_mfs,
							Product pro,
							PPhoto pp,
							HttpSession session,
							HttpServletRequest request, Model model) throws Exception {

		//product 입력 start
		
		// 파일이름앞에 난수및 무작위문자
		String filename1 = mf.getOriginalFilename();
		
		int ran = ((int)(Math.random()*1000000000));	
		StringBuffer stsum = new StringBuffer();
	    for (int i = 0; i <= 8; i++) {
	        char ch = (char) ((Math.random() * 26) + 65);
	        String chc = String.valueOf(ch);        
	        stsum.append(chc);
	      }		
		StringBuffer stsum2 = stsum.append(ran);
		String picf = stsum2.toString();
		
		String filename = picf.concat(filename1);
		// 파일이름앞에 난수및 무작위문자 종료
		
		int size = (int)mf.getSize();
		String path = request.getRealPath("upload");		
				
		int result=0;
		
		// 상품 썸네일 업로드
		String file[] = new String[2];

		StringTokenizer st = new StringTokenizer(filename, ".");
		file[0] = st.nextToken();		
		file[1] = st.nextToken();		// 확장자	
		
		if(size > 10000000){
			result=1;
			model.addAttribute("result", result);
			
			
			return "product/uploadResult";
			
		}else if(!file[1].equals("jpg") &&
				 !file[1].equals("jpeg") &&
				 !file[1].equals("gif") &&
				 !file[1].equals("png") ){
			
			result=2;
			model.addAttribute("result", result);
			
			return "product/uploadResult";
		}
		

		if (size > 0) { // 첨부파일이 전송된 경우

			mf.transferTo(new File(path + "/" + filename));

		}
		
	
		pro.setPro_pic(filename);
		
		// 편의시설 항목 파싱저장
		String con = "";
		String[] con1 = request.getParameterValues("pro_con");
		for(String con2 : con1) {
			con += con2 + "-";
		}
		pro.setPro_con(con);
				
		
		int proresult = proService.proinsertdo(pro); // Product 테이블 입력실행
		model.addAttribute("proresult", proresult); //Product 테이블 입력결과 1 또는 0
		//product 입력 end	
		
		//product 테이블에서 pro_no 구하기 start
		String sel_id = (String) session.getAttribute("id");
		pro = proService.proload(sel_id);
		int pro_no = pro.getPro_no();
		model.addAttribute("pro_no", pro_no);
		//product 테이블에서 pro_no 구하기 end
		
		
		
		//Pphoto 입력 start	
		
		int ppresult = 0;
		for(MultipartFile pp_mf : pp_mfs) {
					
			pp.setPro_no(pro_no);
						
			String pp_filename1 = pp_mf.getOriginalFilename();
			
			int ran1 = ((int)(Math.random()*1000000000));	
			StringBuffer stsum1 = new StringBuffer();
		    for (int i = 0; i <= 8; i++) {
		        char ch = (char) ((Math.random() * 26) + 65);
		        String chc = String.valueOf(ch);        
		        stsum1.append(chc);
		      }		
			StringBuffer stsum21 = stsum1.append(ran1);
			String picf1 = stsum21.toString();
			
			String pp_filename = picf1.concat(pp_filename1);
			
			int pp_size = (int)pp_mf.getSize();
					
			int pp_result=0;
			
			// 업체사진 업로드
			String pp_file[] = new String[2];

			StringTokenizer pp_st = new StringTokenizer(pp_filename, ".");
			pp_file[0] = pp_st.nextToken();		
			pp_file[1] = pp_st.nextToken();		// 확장자	
			
			if(pp_size > 10000000){
				pp_result=1;
				model.addAttribute("pp_result", pp_result);
								
				return "product/uploadResult";
				
			}else if(!pp_file[1].equals("jpg") &&
					 !pp_file[1].equals("jpeg") &&
					 !pp_file[1].equals("gif") &&
					 !pp_file[1].equals("png") ){
				
				pp_result=2;
				model.addAttribute("pp_result", pp_result);
				
				return "product/uploadResult";
			}
			

			if (pp_size > 0) { // 첨부파일이 전송된 경우

				pp_mf.transferTo(new File(path + "/" + pp_filename));

			}
			
			pp.setPp_name(pp_filename);					
			ppresult = proService.ppinsertdo(pp);  // PPhoto 테이블 입력실행	
			
		}
		System.out.println("pphoto입력 성공여부 : " + ppresult);
		
		
		//Pphoto 입력 end
		
		
		
		return "product/okResult";
	}
	

	// ++insert시 pro, pp 정보 사진삭제++
	@RequestMapping("errorppinsert")
	public String errorppinsert(HttpSession session, HttpServletRequest request, Model model) throws Exception {		
		
		//id와 pro_no 구하기
		String sel_id = (String) session.getAttribute("id");
		Product pro = proService.proload(sel_id);
		int pro_no = pro.getPro_no();
		
		String path = request.getRealPath("upload");

		//pp삭제
		List<PPhoto> pplist = proService.getpplist(pro_no);
		for(PPhoto pp : pplist) {
			String im_path = path + "/" + pp.getPp_name();
			File uploaded_image = new File(im_path);
			uploaded_image.delete();
		}
		proService.deletepplist(pro_no);
		
		String im_path = path + "/" + pro.getPro_pic();
		File uploaded_image = new File(im_path);
		uploaded_image.delete();
		
		proService.deletepro(pro_no);
		
		int insertfail = 1;

		model.addAttribute("insertfail", insertfail);
		return "product/uploadResult";
	}
	

	
	// ++상품목록페이지로 이동(product,room,review 등을 구함)++
	@RequestMapping("selprolist")
	public String selprolist(HttpServletRequest request, HttpSession session, Model model) throws Exception{
		
		// Product리스트를 받아옴
		List<Product> prolist = new ArrayList<Product>();
		String sel_id = (String) session.getAttribute("id");
		prolist = proService.getprolist(sel_id); // product 리스트 불러오기
			
		// rm리스트를 받아옴		
		List<Room> s_rmlist = new ArrayList<Room>();
	
		for(Product pro : prolist) {
			int pro_no = pro.getPro_no();				
			List<Room> rmlist = new ArrayList<Room>();
			rmlist = rmService.getrmlist(pro_no);	// room 리스트 불러오기	
			
			if(rmlist.size() == 0) { // 등록된 객실이 없을때
				Room rmdemo = new Room();
				rmdemo.setPro_no(pro.getPro_no());
				String noroom = "객실없음";
				rmdemo.setRm_tname(noroom);
				rmlist.add(rmdemo);
			}
			s_rmlist.addAll(rmlist);
			
			Room rm = rmService.getlowpri(pro_no); // product내 가장 싼방 정보 불러오기
			
			if(rm == null) { // 등록된 객실이 없을때
				pro.setRev_cnt(0);
			} else {
				pro.setRev_cnt(rm.getRm_price());
			}
				
			
			int rev_count = proService.getrevcount(pro_no); //리뷰수 구해오기		
			pro.setRv_total(rev_count);
			
			List<Reservation> delreslist = resService.getdelreslist(pro_no); // 상품삭제신청 수 구하기
			int del_no = delreslist.size(); 
			pro.setDel_no(del_no);
			
			double savg_no = proService.getstaravg(pro_no); //별점평균 구해오기	
			double star_avg = Math.round(savg_no);
			pro.setStar_avg(star_avg);
		}	
		
		model.addAttribute("prolist", prolist);
		model.addAttribute("s_rmlist", s_rmlist);
	
		
		return "product/selprolist";
	}
	
	// ++상품상세페이지로 (판매자)
	@RequestMapping("selprodetail")
	public String selprodetail(int pro_no, HttpServletRequest request, Model model) throws Exception {

		resService.update_res_sp(pro_no); // 시간이 지난 예약 자동 상태값변경
			
		Product pro = proService.getprodetail(pro_no); // product 상세정보구하기		
		String cont = pro.getPro_con();	// 편의시설 나누기
		String[] con = cont.split("-");
		String intro = pro.getPro_intro().replace("\n", "<br>");
		
		model.addAttribute("pro", pro);
		model.addAttribute("con", con);
		model.addAttribute("intro", intro);
		
		List<PPhoto> pplist = proService.getpplist(pro_no); // pphoto 리스트구하기
		model.addAttribute("pplist", pplist);
		
		List<Room> rmlist = new ArrayList<Room>();
		rmlist = rmService.getrmlist(pro_no);	// room 리스트 불러오기					
		model.addAttribute("rmlist", rmlist);
		
		List<Review> relists = proService.getrevlist(pro_no); // review 리스트 불러오기		
		List<Review> relist = new ArrayList<Review>();
		for(Review re : relists) {
			Member mem = boardservice.revuserfind(re.getMem_id());
			re.setMem_pic(mem.getMem_pic());
			relist.add(re);
		}	
		model.addAttribute("relist", relist);
		
		int retotal = revService.getTotal(pro_no);
		
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
		model.addAttribute("retotal", retotal);
		model.addAttribute("star_avg", star_avg);
		
		
		return "product/selprodetail";
	}
	
	// ++product 수정폼으로 이동
	@RequestMapping("proupdateform")
	public String proupdateform(int pro_no, Model model) throws Exception {
		Product pro = proService.getprodetail(pro_no); // product 상세정보구하기		
		
		String cont = pro.getPro_con();	// 편의시설 나누기
		String[] con = cont.split("-");
		
		model.addAttribute("pro", pro);
		model.addAttribute("con", con);
		
		List<PPhoto> pplist = proService.getpplist(pro_no); // pphoto 리스트구하기
		model.addAttribute("pplist", pplist);

		return "product/proupdateform";
	}
	
	// ++product 수정실행
	@RequestMapping("proupdate")
	public String proupdate(@RequestParam("pro_pic1") MultipartFile mf, @RequestParam("pp_name1") MultipartFile[] pp_mfs,
							Product pro,
							PPhoto pps,
							HttpServletRequest request, Model model) throws Exception {
		
		int size = (int)mf.getSize();
		String path = request.getRealPath("upload");
		
		
		//Pphoto 수정 start		
		List<PPhoto> pplist = proService.getpplist(pro.getPro_no());
		
		int pn = proService.ppcount(pro.getPro_no()); // 기존입력되었던 pp데이터 수
		int ps = pp_mfs.length; // 현재 입력될 pp데이더 수
			
		// 기존에 입력된 사진보다 입력할 사진수량이 적을 경우
		if(pn >= ps) {						
		int j = 0;	
		for(PPhoto pp : pplist) {
			
			int pp_no = pp.getPp_no();
			int ppresult = 0;
		
			if(j < ps) {
				MultipartFile pp_mf = pp_mfs[j];
				j++;
				pp.setPp_no(pp_no);
				pp.setPro_no(pro.getPro_no());
							
				String pp_filename1 = pp_mf.getOriginalFilename();
				
				int ran1 = ((int)(Math.random()*1000000000));	
				StringBuffer stsum1 = new StringBuffer();
			    for (int i = 0; i <= 8; i++) {
			        char ch = (char) ((Math.random() * 26) + 65);
			        String chc = String.valueOf(ch);        
			        stsum1.append(chc);
			      }		
				StringBuffer stsum21 = stsum1.append(ran1);
				String picf1 = stsum21.toString();
				
				String pp_filename = picf1.concat(pp_filename1);
				
				int pp_size = (int)pp_mf.getSize();
					
				if (size > 0 ) { 					
				
				int pp_result=0;
				
				// 업체사진 업로드
				String pp_file[] = new String[2];

				StringTokenizer pp_st = new StringTokenizer(pp_filename, ".");
				pp_file[0] = pp_st.nextToken();		
				pp_file[1] = pp_st.nextToken();		// 확장자	
				
				if(pp_size > 10000000){
					pp_result=1;
					model.addAttribute("pp_result", pp_result);
					
					return "product/uploadResult";
					
				}else if(!pp_file[1].equals("jpg") &&
						 !pp_file[1].equals("jpeg") &&
						 !pp_file[1].equals("gif") &&
						 !pp_file[1].equals("png") ){
					
					pp_result=2;
					model.addAttribute("pp_result", pp_result);
					
					return "product/uploadResult";
				}
				

				if (pp_size > 0) { // 첨부파일이 전송된 경우
					String im_path = path + "/" + pp.getPp_name();
					File uploaded_image = new File(im_path);
					uploaded_image.delete();
					
					pp_mf.transferTo(new File(path + "/" + pp_filename));
					pp.setPp_name(pp_filename);
						
				}
				} else {
					pp.setPp_name(pp_filename);	
				}
				
				ppresult = proService.ppupdate(pp);  // PPhoto 테이블 수정실행		
				
			} else {
				String im_path = path + "/" + pp.getPp_name();
				File uploaded_image = new File(im_path);
				uploaded_image.delete();				
				proService.deletepphoto(pp_no); // 잔여 데이터 삭제
			}
								
				
			}
		}	
		// 기존에 입력된 사진보다 입력할 사진수량이 적을 경우 end
		
		// 기존에 입력된 사진보다 입력할 사진수량이 많을 경우
		if(pn < ps) {						
		int j = 0;	
		for(MultipartFile pp_mf : pp_mfs) {
			
			int ppresult = 0;

			if(j < pn) {
				PPhoto pp = pplist.get(j);
			
				j++;
				int pp_no = pp.getPp_no();
				pp.setPp_no(pp_no);
				pp.setPro_no(pro.getPro_no());
							
				String pp_filename1 = pp_mf.getOriginalFilename();
				
				int ran1 = ((int)(Math.random()*1000000000));	
				StringBuffer stsum1 = new StringBuffer();
			    for (int i = 0; i <= 8; i++) {
			        char ch = (char) ((Math.random() * 26) + 65);
			        String chc = String.valueOf(ch);        
			        stsum1.append(chc);
			      }		
				StringBuffer stsum21 = stsum1.append(ran1);
				String picf1 = stsum21.toString();
				
				String pp_filename = picf1.concat(pp_filename1);
				
				int pp_size = (int)pp_mf.getSize();
					
				if (size > 0 ) { 					
				
				int pp_result=0;
				
				// 업체사진 업로드
				String pp_file[] = new String[2];

				StringTokenizer pp_st = new StringTokenizer(pp_filename, ".");
				pp_file[0] = pp_st.nextToken();		
				pp_file[1] = pp_st.nextToken();		// 확장자	
				
				if(pp_size > 10000000){
					pp_result=1;
					model.addAttribute("pp_result", pp_result);
					
					return "product/uploadResult";
					
				}else if(!pp_file[1].equals("jpg") &&
						 !pp_file[1].equals("jpeg") &&
						 !pp_file[1].equals("gif") &&
						 !pp_file[1].equals("png") ){
					
					pp_result=2;
					model.addAttribute("pp_result", pp_result);
					
					return "product/uploadResult";
				}
				

				if (pp_size > 0) { // 첨부파일이 전송된 경우
					String im_path = path + "/" + pp.getPp_name();
					File uploaded_image = new File(im_path);
					uploaded_image.delete();
					
					pp_mf.transferTo(new File(path + "/" + pp_filename));
					pp.setPp_name(pp_filename);
						
				}
				} else {
					pp.setPp_name(pp_filename);	
				}
				
				ppresult = proService.ppupdate(pp);  // PPhoto 테이블 수정실행		
				
			} else {

				pps.setPro_no(pro.getPro_no());
				
				String pp_filename1 = pp_mf.getOriginalFilename();
				
				int ran1 = ((int)(Math.random()*1000000000));	
				StringBuffer stsum1 = new StringBuffer();
			    for (int i = 0; i <= 8; i++) {
			        char ch = (char) ((Math.random() * 26) + 65);
			        String chc = String.valueOf(ch);        
			        stsum1.append(chc);
			      }		
				StringBuffer stsum21 = stsum1.append(ran1);
				String picf1 = stsum21.toString();
				
				String pp_filename = picf1.concat(pp_filename1);
				
				int pp_size = (int)pp_mf.getSize();
						
				int pp_result=0;
				
				// 업체사진 업로드
				String pp_file[] = new String[2];

				StringTokenizer pp_st = new StringTokenizer(pp_filename, ".");
				pp_file[0] = pp_st.nextToken();		
				pp_file[1] = pp_st.nextToken();		// 확장자	
				
				if(pp_size > 10000000){
					pp_result=1;
					model.addAttribute("pp_result", pp_result);
									
					return "product/uploadResult";
					
				}else if(!pp_file[1].equals("jpg") &&
						 !pp_file[1].equals("jpeg") &&
						 !pp_file[1].equals("gif") &&
						 !pp_file[1].equals("png") ){
					
					pp_result=2;
					model.addAttribute("pp_result", pp_result);
					
					return "product/uploadResult";
				}
				

				if (pp_size > 0) { // 첨부파일이 전송된 경우

					pp_mf.transferTo(new File(path + "/" + pp_filename));

				}
				
				pps.setPp_name(pp_filename);					
				ppresult = proService.ppinsertdo(pps);  // PPhoto 테이블 입력실행	
				
			}
								
				
			}
		}	
		// 기존에 입력된 사진보다 입력할 사진수량이 많을 경우 end	
		
		//Pphoto 수정 end
		
		//product 수정 start
		Product pros = proService.getprodetail(pro.getPro_no());
		// 파일이름앞에 난수및 무작위문자
		String filename1 = mf.getOriginalFilename();
		
		int ran = ((int)(Math.random()*1000000000));	
		StringBuffer stsum = new StringBuffer();
	    for (int i = 0; i <= 8; i++) {
	        char ch = (char) ((Math.random() * 26) + 65);
	        String chc = String.valueOf(ch);        
	        stsum.append(chc);
	      }		
		StringBuffer stsum2 = stsum.append(ran);
		String picf = stsum2.toString();
		
		String filename = picf.concat(filename1);
		// 파일이름앞에 난수및 무작위문자 종료
		
	
		
		if (size > 0 ) { 
					
		int result=0;
		
		// 상품 썸네일 업로드
		String file[] = new String[2];

		StringTokenizer st = new StringTokenizer(filename, ".");
		file[0] = st.nextToken();		
		file[1] = st.nextToken();		// 확장자	
		
		if(size > 10000000){
			result=1;
			model.addAttribute("result", result);
			
			return "product/uploadResult";
			
		}else if(!file[1].equals("jpg") &&
				 !file[1].equals("jpeg") &&
				 !file[1].equals("gif") &&
				 !file[1].equals("png") ){
			
			result=2;
			model.addAttribute("result", result);
			
			return "product/uploadResult";
		}
		

		if (size > 0) { // 첨부파일이 전송된 경우
			
			mf.transferTo(new File(path + "/" + filename));
			pro.setPro_pic(filename);

			String im_path = path + "/" + pros.getPro_pic();
			File uploaded_image = new File(im_path);
			uploaded_image.delete();
		}
		
		} else {
			pro.setPro_pic(pros.getPro_pic());
		}
		
		
		// 편의시설 항목 파싱저장
		String con = "";
		String[] con1 = request.getParameterValues("pro_con");
		for(String con2 : con1) {
			con += con2 + "-";
		}
		pro.setPro_con(con);
				
		
		int proupdateresult = proService.proupdate(pro); // Product 테이블 수정실행
		model.addAttribute("proupdateresult", proupdateresult); //Product 테이블 입력결과 1 또는 0
		//product 수정 end
		int pro_no = pro.getPro_no();
		model.addAttribute("pro_no", pro_no);
		
		return "product/okResult";
	}
	
	// ++상품 삭제전 판매자 비번확인(ajax)++
	@ResponseBody
	@RequestMapping("delbefore")
	public int delpro(String sel_id, String sel_pw, Model model) throws Exception {
		int result = 0;
		Seller s = boardservice.usercheck1(sel_id);
		if (s.getSel_pw().equals(sel_pw)) {
			result = 1;
		}
		return result;
	}
	
	// ++상품 삭제++
	@RequestMapping("prodelete")
	public String prodelete(int pro_no, HttpServletRequest request, Model model) throws Exception {
		
		// 삭제전 예약확인
		List<Reservation> reslist = resService.getreslist_pro(pro_no);
		int i = 0;
		for(Reservation res : reslist) {
			if(res.getRes_s() != 0) {
				i++;
			}
		}
		
		if(i > 0) {
			int prodeleteresult = 0;
			model.addAttribute("prodeleteresult", prodeleteresult);
			return "product/okResult";
		} 
		
		//리뷰와 예약건들 삭제
		revService.delete_proreview(pro_no);
		resService.delete_proreservation(pro_no);
		
		String path = request.getRealPath("upload");
		
		//객실삭제
		List<Room> rmlist = rmService.getrmlist(pro_no);	
		for(Room rm : rmlist) {
		int rm_no = rm.getRm_no();	
				
		List<RPhoto> rplist = rmService.getrplist(rm_no);
		for(RPhoto rp : rplist) {
			String im_path = path + "/" + rp.getRp_name();
			File uploaded_image = new File(im_path);
			uploaded_image.delete();
		}
		rmService.deleterplist(rm_no);
		
		
		String im_path = path + "/" + rm.getRm_pic();
		File uploaded_image = new File(im_path);
		uploaded_image.delete();
		
		rmService.deleterm(rm_no);
		
		}
		
		//상품삭제
		List<PPhoto> pplist = proService.getpplist(pro_no);
		for(PPhoto pp : pplist) {
			String im_path = path + "/" + pp.getPp_name();
			File uploaded_image = new File(im_path);
			uploaded_image.delete();
		}
		proService.deletepplist(pro_no);
		
		Product pro = proService.getprodetail(pro_no);	
		String im_path = path + "/" + pro.getPro_pic();
		File uploaded_image = new File(im_path);
		uploaded_image.delete();
		
		proService.deletepro(pro_no);
		
		int prodeleteresult = 1;
		model.addAttribute("prodeleteresult", prodeleteresult);
		
		return "product/okResult";
	}
	
	// +상품 다시제줄++
	@RequestMapping("resubmitpro")
	public String resubmitpro(int pro_no, Model model) throws Exception {
		
		int resubmitpro_result = proService.resubmitpro_s(pro_no);
		model.addAttribute("resubmitpro_result", resubmitpro_result);
		return "product/okResult";
	}
	
	
	
}
