package model;

import java.sql.Timestamp;

public class Reservation {
	private int res_no;
	private Timestamp res_ckin;
	private Timestamp res_ckout;
	private int res_s;
	private String mem_id;
	private String res_name;
	private String res_p1;
	private String res_p2;
	private String res_p3;
	private int res_pno;
	private int res_price;
	private String res_tname;
	private int rm_no;
	private int pro_no;
	private String res_email;
	private String res_need;
	private int totalprice;
	
	//내 예약정보
	private int daygap;
	
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	public Timestamp getRes_ckin() {
		return res_ckin;
	}
	public void setRes_ckin(Timestamp res_ckin) {
		this.res_ckin = res_ckin;
	}
	public Timestamp getRes_ckout() {
		return res_ckout;
	}
	public void setRes_ckout(Timestamp res_ckout) {
		this.res_ckout = res_ckout;
	}
	public int getRes_s() {
		return res_s;
	}
	public void setRes_s(int res_s) {
		this.res_s = res_s;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_p1() {
		return res_p1;
	}
	public void setRes_p1(String res_p1) {
		this.res_p1 = res_p1;
	}
	public String getRes_p2() {
		return res_p2;
	}
	public void setRes_p2(String res_p2) {
		this.res_p2 = res_p2;
	}
	public String getRes_p3() {
		return res_p3;
	}
	public void setRes_p3(String res_p3) {
		this.res_p3 = res_p3;
	}
	public int getRes_pno() {
		return res_pno;
	}
	public void setRes_pno(int res_pno) {
		this.res_pno = res_pno;
	}
	public int getRes_price() {
		return res_price;
	}
	public void setRes_price(int res_price) {
		this.res_price = res_price;
	}
	public String getRes_tname() {
		return res_tname;
	}
	public void setRes_tname(String res_tname) {
		this.res_tname = res_tname;
	}
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
	
	public String getRes_email() {
		return res_email;
	}
	public void setRes_email(String res_email) {
		this.res_email = res_email;
	}
	public String getRes_need() {
		return res_need;
	}
	public void setRes_need(String res_need) {
		this.res_need = res_need;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getDaygap() {
		return daygap;
	}
	public void setDaygap(int daygap) {
		this.daygap = daygap;
	}


	


	

}
