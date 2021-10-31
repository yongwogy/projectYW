package model;

import java.sql.Timestamp;

public class Room {
	private int rm_no;
	private int pro_no;
	private int rm_type;
	private String rm_tname;
	private int rm_pno;
	private int rm_rno;
	private int rm_price;
	private String rm_pic;
	private int rm_s;
	
	//내 예약정보
	private int res_no;
	
	//예약캘린더용 resday
	private String resday;
	
	public int getRm_no() {
		return rm_no;
	}
	public void setRm_no(int rm_no) {
		this.rm_no = rm_no;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public int getRm_type() {
		return rm_type;
	}
	public void setRm_type(int rm_type) {
		this.rm_type = rm_type;
	}
	public String getRm_tname() {
		return rm_tname;
	}
	public void setRm_tname(String rm_tname) {
		this.rm_tname = rm_tname;
	}
	public int getRm_pno() {
		return rm_pno;
	}
	public void setRm_pno(int rm_pno) {
		this.rm_pno = rm_pno;
	}
	public int getRm_rno() {
		return rm_rno;
	}
	public void setRm_rno(int rm_rno) {
		this.rm_rno = rm_rno;
	}
	public int getRm_price() {
		return rm_price;
	}
	public void setRm_price(int rm_price) {
		this.rm_price = rm_price;
	}
	public String getRm_pic() {
		return rm_pic;
	}
	public void setRm_pic(String rm_pic) {
		this.rm_pic = rm_pic;
	}
	public int getRm_s() {
		return rm_s;
	}
	public void setRm_s(int rm_s) {
		this.rm_s = rm_s;
	}
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	public String getResday() {
		return resday;
	}
	public void setResday(String resday) {
		this.resday = resday;
	}

	

	
	
}
