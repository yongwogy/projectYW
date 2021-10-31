package model;

import java.sql.Timestamp;

public class Notice {
	private int n_no;
	private String mem_id;
	private String n_sub;
	private String n_con;
	private int n_rcnt;
	private Timestamp n_date;
	
	public int getN_no() {
		return n_no;
	}
	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getN_sub() {
		return n_sub;
	}
	public void setN_sub(String n_sub) {
		this.n_sub = n_sub;
	}
	public String getN_con() {
		return n_con;
	}
	public void setN_con(String n_con) {
		this.n_con = n_con;
	}
	public int getN_rcnt() {
		return n_rcnt;
	}
	public void setN_rcnt(int n_rcnt) {
		this.n_rcnt = n_rcnt;
	}
	public Timestamp getN_date() {
		return n_date;
	}
	public void setN_date(Timestamp n_date) {
		this.n_date = n_date;
	}
	
	
}
