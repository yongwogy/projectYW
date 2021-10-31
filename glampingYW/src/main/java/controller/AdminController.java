package controller;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
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

import model.Product;
import model.Seller;
import service.AdminserviceImpl;
import service.BoardserviceImpl;




@Controller
public class AdminController {
	
	@Autowired
	private BoardserviceImpl boardservice;
	@Autowired
	private AdminserviceImpl Adminservice;
	
	/* 관리자페이지 */
	@RequestMapping("adpage")
	public String adpage(HttpSession session,Model m1) throws Exception {
		String id = (String) session.getAttribute("id");
		
		Member m = boardservice.usercheck(id);
	
		m1.addAttribute("m", m);
		return "admin/adpage";
	}

	/* 일반회원관리페이지 */
	@RequestMapping("managemember")
	public String managemember(HttpServletRequest request, Model model) throws Exception {
		
		int page = 1;
		int limit = 20;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		
		int listcount = Adminservice.getmemlist().size();
		
		HashMap<String, Object> Rows = new HashMap<String, Object>(); 
		Rows.put("startRow", startRow);
		Rows.put("endRow", endRow);
		
		List<Member> memlist = Adminservice.get_memList(Rows);
		// 총 페이지
		int pageCount = (listcount + limit - 1) / limit;
		
		int startPage = ((page -1)/limit) * limit + 1;
		int endPage = startPage +limit - 1;
		
		// 초과 페이지 제거
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("memlist", memlist);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		
		return "admin/managememview";
	}
	
	/* 판매자회원관리페이지 */
	@RequestMapping("manageseller")
	public String manageseller(HttpServletRequest request, Model model) throws Exception {
				
		int page = 1;
		int limit = 20;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		

		int listcount = Adminservice.getsellist().size();

		HashMap<String, Object> Rows = new HashMap<String, Object>(); 
		Rows.put("startRow", startRow);
		Rows.put("endRow", endRow);
		
		List<Seller> sellist = Adminservice.get_selList(Rows);
		// 총 페이지
		int pageCount = (listcount + limit - 1) / limit;
		
		int startPage = ((page -1)/limit) * limit + 1;
		int endPage = startPage +limit - 1;
		
		// 초과 페이지 제거
		if(endPage > pageCount) endPage = pageCount;
		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("sellist", sellist);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);


		return "admin/manageselview";
	}
	
	/* 일반회원 승인 ajax*/
	@ResponseBody
	@RequestMapping("approvemember")
	public int approvemember(String mem_id) throws Exception {
		
		int mem_appresult = Adminservice.appmember(mem_id);	
		
		return mem_appresult;
	}
	
	/* 일반회원 탈퇴 ajax*/
	@ResponseBody
	@RequestMapping("banmember")
	public int banmember(String mem_id) throws Exception {
		
		int mem_banresult = Adminservice.banmember(mem_id);
		
		return mem_banresult;
	}
	
	/* 판매자회원 승인 ajax*/
	@ResponseBody
	@RequestMapping("approveseller")
	public int approveseller(String sel_id) throws Exception {
			
		int sel_appresult = Adminservice.appseller(sel_id);	
		
		return sel_appresult;
	}
	
	/* 판매자회원 탈퇴 ajax*/
	@ResponseBody
	@RequestMapping("banseller")
	public int banseller(String sel_id) throws Exception {
			
		int sel_banresult = Adminservice.banseller(sel_id);
		
		return sel_banresult;
	}
	
	/* 상품관리페이지 */
	@RequestMapping("manageproduct")
	public String manageproduct(Model model) throws Exception {
			
		List<Product> prolist = Adminservice.getallprolist();
		model.addAttribute("prolist", prolist);	
		
		return "admin/manageproview";
	}
	
	/* 상품 승인 */
	@RequestMapping("appproduct")
	public String appproduct(int pro_no, Model model) throws Exception {
			
		int proapp_result = Adminservice.apppro(pro_no);
		model.addAttribute("proapp_result", proapp_result);	
		
		return "admin/okResult";
	}
	
	/* 상품 반려 */
	@RequestMapping("banproduct")
	public String banproduct(int pro_no, Model model) throws Exception {
			
		int proban_result = Adminservice.banpro(pro_no);
		model.addAttribute("proban_result", proban_result);	
		
		return "admin/okResult";
	}
	
}
