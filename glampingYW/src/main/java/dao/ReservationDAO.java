package dao;

import java.util.List;

import model.Reservation;
import model.Review;

public interface ReservationDAO {
	
	public int resinsertdo(Reservation res) throws Exception;
		
	public List getreslist(int rm_no) throws Exception;
	
	public List getmyreslist(String mem_id) throws Exception;

	public int delreserve(int res_no) throws Exception;

	public List getmyproreslist(Review rev) throws Exception;
	
	public List getmyproreslist2(Review rev) throws Exception;
	
	public List getreslist_pro(int pro_no) throws Exception;
	
	public Reservation resdetailone(int res_no) throws Exception;
	
	public int update_res_s(String mem_id) throws Exception;
	
	public List getdelreslist(int pro_no) throws Exception;
	
	public int return_reserve(int res_no) throws Exception;
	
	public int terminate_reserve(int res_no) throws Exception;
	
	public int update_res_sp(int pro_no) throws Exception;
	
	public int delete_proreservation(int pro_no) throws Exception;
}
