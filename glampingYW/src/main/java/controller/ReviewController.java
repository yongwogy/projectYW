package controller;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import model.Reservation;
import model.Review;
import service.ReservationServiceImp;
import service.ReviewServiceImp;



@Controller
public class ReviewController {
	
	@Autowired
	private ReservationServiceImp reserveService;
	@Autowired
	private ReviewServiceImp reverveService;


	//++ 후기작성창 열기위한 조건(ajax)
	@ResponseBody
	@RequestMapping("reviewprepare")
	public int reviewprepare(String mem_id, int pro_no, Model model) throws Exception {	
		int ressearch_result = 0;
		List<Reservation> resList = reserveService.getmyreslist(mem_id);
		int i = 0;
		for(Reservation res : resList) {
			if(pro_no == res.getPro_no() && res.getRes_s() < 2) {
				i++;
			}
		}
		if(i !=0) {
			ressearch_result = 1;
		}
					
		return ressearch_result;
	}
	

	//++ 후기작성(ajax)
	@ResponseBody
	@RequestMapping("reviewinsert")
	public int reviewinsert(Review rev, Model model) throws Exception {	
		int revinsert_result = 0;
		List<Reservation> resList = reserveService.getmyproreslist(rev);
		List<Reservation> resList2 = reserveService.getmyproreslist2(rev);
		List<Review> revlist = reverveService.getmyrevlist(rev);

		//처음 후기 작성시
		if (revlist.size() == 0) {	

			Reservation resdemo =  resList.get(0);
			Timestamp[] ckoutlist = new Timestamp[resList.size()];
			Timestamp min = resdemo.getRes_ckout();		
			int i = 0;
			Reservation ress = null;
			for (Reservation res : resList) {
				Timestamp t = res.getRes_ckout();
				ckoutlist[i] = t;
				if(min.after(ckoutlist[i]) || min.equals(ckoutlist[i])) {
					min = ckoutlist[i];
					ress = res;
				}
				i++;
			}
			rev.setRes_no(ress.getRes_no());
			revinsert_result = reverveService.reviewinsertdo(rev);
		}
		
		//후기 또 작성시
		if (revlist.size() != 0) {

			Reservation resdemo =  resList2.get(0);
			Timestamp[] ckoutlist = new Timestamp[resList2.size()];
			Timestamp min = resdemo.getRes_ckout();

			int i = 0;
			Reservation ress = null;		
			for (Reservation res : resList2) {
				Timestamp t = res.getRes_ckout();
				ckoutlist[i] = t;
				if(min.after(ckoutlist[i]) || min.equals(ckoutlist[i])) {
					min = ckoutlist[i];
					ress = res;
				}
				i++;
			}				
			rev.setRes_no(ress.getRes_no());
			revinsert_result = reverveService.reviewinsertdo(rev);
		}
		
		
		
		return revinsert_result;
	}
	

	//++ 후기수정(ajax)
	@ResponseBody
	@RequestMapping("updatereview")
	public int updatereview(Review rev, Model model) throws Exception {	
		int revupdate_result = 0;
		
		revupdate_result = reverveService.reviewupdatedo(rev);
		
		return revupdate_result;
	}
	
	//++ 후기삭제(ajax)
	@ResponseBody
	@RequestMapping("delreview")
	public int delreview(int rev_no, Model model) throws Exception {	
		int revupdate_result = 0;
		
		revupdate_result = reverveService.deletereview(rev_no);
		
		return revupdate_result;
	}
	
	//++ 후기찾기(ajax)
	@ResponseBody
	@RequestMapping("researchreview")
	public Map<String, Object> researchreview(Review rev, Model model) throws Exception {	
		Map<String,Object> map = new HashMap<String,Object>();
		
		Review revn = reverveService.researchreviewdo(rev);
		int rev_no = revn.getRev_no();
		map.put("rev_no", rev_no);
		return map;
	}
	
	
}
