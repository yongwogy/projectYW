package model;

import java.sql.Timestamp;

public class Review {
	private int rev_no;
	private String mem_id;
	private String rev_con;
	private Timestamp rev_date;
	private int rev_star;
	private int pro_no;
	private int res_no;
	
	//리뷰유저사진
	private String mem_pic;
	
	public int getRev_no() {
		return rev_no;
	}
	public void setRev_no(int rev_no) {
		this.rev_no = rev_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRev_con() {
		return rev_con;
	}
	public void setRev_con(String rev_con) {
		this.rev_con = rev_con;
	}
	public Timestamp getRev_date() {
		return rev_date;
	}
	public void setRev_date(Timestamp rev_date) {
		this.rev_date = rev_date;
	}
	public int getRev_star() {
		return rev_star;
	}
	public void setRev_star(int rev_star) {
		this.rev_star = rev_star;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	
	
	public String getMem_pic() {
		return mem_pic;
	}
	public void setMem_pic(String mem_pic) {
		this.mem_pic = mem_pic;
	}
	
	
}
