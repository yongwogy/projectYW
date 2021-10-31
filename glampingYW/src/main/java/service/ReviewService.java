package service;

import java.util.List;

import model.Reservation;
import model.Review;

public interface ReviewService {
	
	public List getrevlist(int pro_no) throws Exception;
	
	public List getmyrevlist(Review rev) throws Exception;
	
	public int reviewinsertdo(Review rev) throws Exception;
	
	public int reviewupdatedo(Review rev) throws Exception;
	
	public int deletereview(int rev_no) throws Exception;
	
	public Review researchreviewdo(Review rev) throws Exception;
	
	public int getTotal(int pro_no) throws Exception;
	
	public int terminate_review(int res_no) throws Exception;
	
	public int delete_proreview(int pro_no) throws Exception;
}
