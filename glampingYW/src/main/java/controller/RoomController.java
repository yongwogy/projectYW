package controller;

import java.io.File;
import java.util.ArrayList;
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

import model.PPhoto;
import model.Product;
import model.RPhoto;
import model.Room;
import service.ProductServiceImp;
import service.RoomServiceImp;



@Controller
public class RoomController {
	
	@Autowired
	private ProductServiceImp proService;
	@Autowired
	private RoomServiceImp rmService;
	
	// ++객실정보 등록페이지로 이동++
	@RequestMapping("rminsertform")
	public String rminsertform(int pro_no, Model model){
		model.addAttribute("pro_no", pro_no);
		System.out.println(pro_no);
		return "product/rminsertform";
	}
	
	// ++객실정보 등록++
	@RequestMapping("rminsert")
	public String rminsert(@RequestParam("rm_pic1") MultipartFile mf, @RequestParam("rp_name1") MultipartFile[] mfs, Room rm, RPhoto rp,
						   HttpServletRequest request, HttpSession session, Model model) throws Exception {
		
	
		//Room 입력 start
	
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
		
		int size = (int)mf.getSize();
		String path = request.getRealPath("upload");		
				
		int rm_result=0;
		
		// 객실 썸네일 업로드
		String file[] = new String[2];

		StringTokenizer st = new StringTokenizer(filename, ".");
		file[0] = st.nextToken();		
		file[1] = st.nextToken();		// 확장자	
		
		if(size > 10000000){
			rm_result=1;
			model.addAttribute("rm_result", rm_result);
			
			return "product/uploadResult";
			
		}else if(!file[1].equals("jpg") &&
				 !file[1].equals("jpeg") &&
				 !file[1].equals("gif") &&
				 !file[1].equals("png") ){
			
			rm_result=2;
			model.addAttribute("rm_result", rm_result);
			
			return "product/uploadResult";
		}
		

		if (size > 0) { // 첨부파일이 전송된 경우

			mf.transferTo(new File(path + "/" + filename));

		}
		
		rm.setRm_pic(filename);
		
		int rmresult = rmService.rminsertdo(rm); //Room테이블 입력실행
		model.addAttribute("rmresult", rmresult);
		
		System.out.println("객실정보입력여부 : "+ rmresult);
		//Room 입력 end
		
		
		// rm_type값 저장 증가			
//		System.out.println("rm_type : " + rm.getRm_type());	
//		int t = rm.getRm_type();
//		t += 1;
//		rm.setRm_type(t);			
//		System.out.println("rm_type : " + rm.getRm_type());
//		System.out.println("-------------------------------");
//		int rt = rm.getRm_type();
//		model.addAttribute("rt", rt);
		
		
		//room 테이블에서 rm_no 구하기 start
		int pro_no = rm.getPro_no();
		model.addAttribute("pro_no", pro_no);
		rm = rmService.rmload(pro_no);
		System.out.println("rm_no : "+ rm.getRm_no());
		//room 테이블에서 rm_no 구하기 end
		
		
		
		//Rphoto 입력 start	
		int rpresult = 0;
		for(MultipartFile rp_mf : mfs) {
					
			rp.setRm_no(rm.getRm_no());
						
			String rp_filename1 = rp_mf.getOriginalFilename();
			
			int ran1 = ((int)(Math.random()*1000000000));	
			StringBuffer stsum1 = new StringBuffer();
		    for (int i = 0; i <= 8; i++) {
		        char ch = (char) ((Math.random() * 26) + 65);
		        String chc = String.valueOf(ch);        
		        stsum1.append(chc);
		      }		
			StringBuffer stsum21 = stsum1.append(ran1);
			String picf1 = stsum21.toString();
			
			String rp_filename = picf1.concat(rp_filename1);
			
				
			int rp_size = (int)rp_mf.getSize();
					
			int rp_result=0;
			
			// 업체사진 업로드
			String rp_file[] = new String[2];

			StringTokenizer rp_st = new StringTokenizer(rp_filename, ".");
			rp_file[0] = rp_st.nextToken();		
			rp_file[1] = rp_st.nextToken();		// 확장자	
			
			if(rp_size > 10000000){
				rp_result=1;
				model.addAttribute("rp_result", rp_result);
				
				return "product/uploadResult";
				
			}else if(!rp_file[1].equals("jpg") &&
					 !rp_file[1].equals("jpeg") &&
					 !rp_file[1].equals("gif") &&
					 !rp_file[1].equals("png") ){
				
				rp_result=2;
				model.addAttribute("rp_result", rp_result);
				
				return "product/uploadResult";
			}
			

			if (rp_size > 0) { // 첨부파일이 전송된 경우

				rp_mf.transferTo(new File(path + "/" + rp_filename));

			}
			
			rp.setRp_name(rp_filename);					
			rpresult = rmService.rpinsertdo(rp);  // Rphoto 테이블 입력실행	
			
		}
		System.out.println("rphoto입력 성공여부 : " + rpresult);		
		//Rphoto 입력 end
			
		return "product/okResult";
	}
	
	// ++insert시 rm, rp 정보 사진삭제++
	@RequestMapping("errorrpinsert")
	public String errorrpinsert(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		
		//id와 pro_no, rm_no 구하기
		String sel_id = (String) session.getAttribute("id");
		Product pro = proService.proload(sel_id);
		int pro_no = pro.getPro_no();
		Room rm = rmService.rmload(pro_no);
		int rm_no = rm.getRm_no();
		String path = request.getRealPath("upload");
		
		//rp삭제
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
		
		int insertfail = 1;
		
		model.addAttribute("insertfail", insertfail);
		return "product/uploadResult";
	}
	
	// ++객실 상세페이지++
	@RequestMapping("roomdetail")
	public String rmdetail(int rm_no, Model model) throws Exception {
		System.out.println(rm_no);
		
		Room rm = rmService.getrmdetail(rm_no);
		model.addAttribute("rm", rm);
		
		List<RPhoto> rplist = rmService.getrplist(rm_no); // rphoto 리스트구하기
		model.addAttribute("rplist", rplist);
		
		return "product/selrmdetail";
	}
	
	// ++room 수정폼으로 이동
	@RequestMapping("rmupdateform")
	public String rmupdateform(int rm_no, Model model) throws Exception {
		
		Room rm = rmService.getrmdetail(rm_no); // Room 상세정보구하기
		List<RPhoto> rplist = rmService.getrplist(rm_no); // rphoto 리스트구하기
		
		model.addAttribute("rm", rm);
		model.addAttribute("rplist", rplist);
		return "product/rmupdateform";
	}
	
	
	// ++객실정보 수정++
	@RequestMapping("rmupdate")
	public String rmupdate(@RequestParam("rm_pic1") MultipartFile mf, @RequestParam("rp_name1") MultipartFile[] mfs,
						   Room rm, 
						   RPhoto rps,
						   HttpServletRequest request,
						   Model model) throws Exception {
		
		int size = (int)mf.getSize();
		String path = request.getRealPath("upload");
		//Rphoto 입력 start	
		List<RPhoto> rplist = rmService.getrplist(rm.getRm_no());
		int rn = rmService.rpcount(rm.getRm_no()); // 기존입력되었던 rp데이터 수
		int rs = mfs.length; // 현재 입력될 rp데이더 수
		
		// 기존에 입력된 사진보다 입력할 사진수량이 적을 경우 start
		if(rn >= rs) {	
		int j = 0;		
		for(RPhoto rp : rplist) {
			
			int rp_no = rp.getRp_no();
			int rpresult = 0;
			
			if(j < rs) {
				
			MultipartFile rp_mf = mfs[j];
			j++;					
			rp.setRp_no(rp_no);
			rp.setRm_no(rm.getRm_no());
						
			String rp_filename1 = rp_mf.getOriginalFilename();
			
			int ran1 = ((int)(Math.random()*1000000000));	
			StringBuffer stsum1 = new StringBuffer();
		    for (int i = 0; i <= 8; i++) {
		        char ch = (char) ((Math.random() * 26) + 65);
		        String chc = String.valueOf(ch);        
		        stsum1.append(chc);
		      }		
			StringBuffer stsum21 = stsum1.append(ran1);
			String picf1 = stsum21.toString();
			
			String rp_filename = picf1.concat(rp_filename1);
			
				
			int rp_size = (int)rp_mf.getSize();
					
			int rp_result=0;
			
			// 업체사진 업로드
			String rp_file[] = new String[2];

			StringTokenizer rp_st = new StringTokenizer(rp_filename, ".");
			rp_file[0] = rp_st.nextToken();		
			rp_file[1] = rp_st.nextToken();		// 확장자	
			
			if(rp_size > 10000000){
				rp_result=1;
				model.addAttribute("rp_result", rp_result);
				
				return "product/uploadResult";
				
			}else if(!rp_file[1].equals("jpg") &&
					 !rp_file[1].equals("jpeg") &&
					 !rp_file[1].equals("gif") &&
					 !rp_file[1].equals("png") ){
				
				rp_result=2;
				model.addAttribute("rp_result", rp_result);
				
				return "product/uploadResult";
			}
			

			if (rp_size > 0) { // 첨부파일이 전송된 경우
				String im_path = path + "/" + rp.getRp_name();
				File uploaded_image = new File(im_path);
				uploaded_image.delete();
				
				rp_mf.transferTo(new File(path + "/" + rp_filename));
				rp.setRp_name(rp_filename);	
			}
			
				
			rpresult = rmService.rpupdate(rp);  // Rphoto 테이블 수정실행	
			} else {
				String im_path = path + "/" + rp.getRp_name();
				File uploaded_image = new File(im_path);
				uploaded_image.delete();				
				rmService.deleterphoto(rp_no); // 잔여 데이터 삭제
			}
		}
		
		}
		// 기존에 입력된 사진보다 입력할 사진수량이 적을 경우 end
		
		// 기존에 입력된 사진보다 입력할 사진수량이 많을 경우 start
		if(rn < rs) {	
		int j = 0;		
		for(MultipartFile rp_mf : mfs) {
			
			int rpresult = 0;
			
			if(j < rn) {
			RPhoto rp = rplist.get(j);	
			j++;	
			int rp_no = rp.getRp_no();
			rp.setRp_no(rp_no);
			rp.setRm_no(rm.getRm_no());
						
			String rp_filename1 = rp_mf.getOriginalFilename();
			
			int ran1 = ((int)(Math.random()*1000000000));	
			StringBuffer stsum1 = new StringBuffer();
		    for (int i = 0; i <= 8; i++) {
		        char ch = (char) ((Math.random() * 26) + 65);
		        String chc = String.valueOf(ch);        
		        stsum1.append(chc);
		      }		
			StringBuffer stsum21 = stsum1.append(ran1);
			String picf1 = stsum21.toString();
			
			String rp_filename = picf1.concat(rp_filename1);
			
				
			int rp_size = (int)rp_mf.getSize();
					
			int rp_result=0;
			
			// 업체사진 업로드
			String rp_file[] = new String[2];

			StringTokenizer rp_st = new StringTokenizer(rp_filename, ".");
			rp_file[0] = rp_st.nextToken();		
			rp_file[1] = rp_st.nextToken();		// 확장자	
			
			if(rp_size > 10000000){
				rp_result=1;
				model.addAttribute("rp_result", rp_result);
				
				return "product/uploadResult";
				
			}else if(!rp_file[1].equals("jpg") &&
					 !rp_file[1].equals("jpeg") &&
					 !rp_file[1].equals("gif") &&
					 !rp_file[1].equals("png") ){
				
				rp_result=2;
				model.addAttribute("rp_result", rp_result);
				
				return "product/uploadResult";
			}
			

			if (rp_size > 0) { // 첨부파일이 전송된 경우
				String im_path = path + "/" + rp.getRp_name();
				File uploaded_image = new File(im_path);
				uploaded_image.delete();
				
				rp_mf.transferTo(new File(path + "/" + rp_filename));
				rp.setRp_name(rp_filename);	
			}
					
			rpresult = rmService.rpupdate(rp);  // Rphoto 테이블 수정실행	
			} else {

				rps.setRm_no(rm.getRm_no());
				
				String rp_filename1 = rp_mf.getOriginalFilename();
				
				int ran1 = ((int)(Math.random()*1000000000));	
				StringBuffer stsum1 = new StringBuffer();
			    for (int i = 0; i <= 8; i++) {
			        char ch = (char) ((Math.random() * 26) + 65);
			        String chc = String.valueOf(ch);        
			        stsum1.append(chc);
			      }		
				StringBuffer stsum21 = stsum1.append(ran1);
				String picf1 = stsum21.toString();
				
				String rp_filename = picf1.concat(rp_filename1);
				
					
				int rp_size = (int)rp_mf.getSize();
						
				int rp_result=0;
				
				// 업체사진 업로드
				String rp_file[] = new String[2];

				StringTokenizer rp_st = new StringTokenizer(rp_filename, ".");
				rp_file[0] = rp_st.nextToken();		
				rp_file[1] = rp_st.nextToken();		// 확장자	
				
				if(rp_size > 10000000){
					rp_result=1;
					model.addAttribute("rp_result", rp_result);
					
					return "product/uploadResult";
					
				}else if(!rp_file[1].equals("jpg") &&
						 !rp_file[1].equals("jpeg") &&
						 !rp_file[1].equals("gif") &&
						 !rp_file[1].equals("png") ){
					
					rp_result=2;
					model.addAttribute("rp_result", rp_result);
					
					return "product/uploadResult";
				}
				

				if (rp_size > 0) { // 첨부파일이 전송된 경우
					rp_mf.transferTo(new File(path + "/" + rp_filename));
					rps.setRp_name(rp_filename);	
				}
							
				rpresult = rmService.rpinsertdo(rps);  // Rphoto 테이블 입력실행	
			}
		}
		
		}
		// 기존에 입력된 사진보다 입력할 사진수량이 많을 경우 end
		//Rphoto 입력 end
			
		//Room 수정 start
		Room rms = rmService.getrmdetail(rm.getRm_no());

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
		
		
				
		int rm_result=0;
		
		// 객실 썸네일 업로드
		String file[] = new String[2];

		StringTokenizer st = new StringTokenizer(filename, ".");
		file[0] = st.nextToken();		
		file[1] = st.nextToken();		// 확장자	
		
		if(size > 10000000){
			rm_result=1;
			model.addAttribute("rm_result", rm_result);
			
			return "product/uploadResult";
			
		}else if(!file[1].equals("jpg") &&
				 !file[1].equals("jpeg") &&
				 !file[1].equals("gif") &&
				 !file[1].equals("png") ){
			
			rm_result=2;
			model.addAttribute("rm_result", rm_result);
			
			return "product/uploadResult";
		}
		

		if (size > 0) { // 첨부파일이 전송된 경우

			mf.transferTo(new File(path + "/" + filename));
			rm.setRm_pic(filename);
			
			String im_path = path + "/" + rms.getRm_pic();
			File uploaded_image = new File(im_path);
			uploaded_image.delete();
		}
		
		
		int rmupdateresult = rmService.rmupdate(rm); //Room테이블 입력실행
		int pro_no = rms.getPro_no();
		model.addAttribute("rmupdateresult", rmupdateresult);
		model.addAttribute("pro_no", pro_no);
		

		//Room 수정 end
		
		return "product/okResult";
	}
	
	// ++객실 삭제++
	@RequestMapping("rmdelete")
	public String rmdelete(int rm_no, HttpServletRequest request, Model model) throws Exception {
		
		
		String path = request.getRealPath("upload");
		//rp삭제
		List<RPhoto> rplist = rmService.getrplist(rm_no);
		for(RPhoto rp : rplist) {
			String im_path = path + "/" + rp.getRp_name();
			File uploaded_image = new File(im_path);
			uploaded_image.delete();
		}
		rmService.deleterplist(rm_no);
		
		Room rm = rmService.getrmdetail(rm_no);
		int pro_no = rm.getPro_no();

		
		String im_path = path + "/" + rm.getRm_pic();
		File uploaded_image = new File(im_path);
		uploaded_image.delete();
		
		rmService.deleterm(rm_no);
		
		int rmdeleteresult = 1;
		model.addAttribute("pro_no", pro_no);
		model.addAttribute("rmdeleteresult", rmdeleteresult);
		return "product/okResult";
	}
	
	// ++객실 영업중지(ajax)++
	@ResponseBody
	@RequestMapping("stop_sales")
	public int stop_sales(int rm_no) throws Exception {
		int result = rmService.stop_rmsales(rm_no);
		return result;
	}
	
	// ++객실 영업재개(ajax)++
	@ResponseBody
	@RequestMapping("restart_sales")
	public int restart_sales(int rm_no) throws Exception {
		int result = rmService.restart_rmsales(rm_no);
		return result;
	}
	
}

	


