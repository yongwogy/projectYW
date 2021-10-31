package model;

import java.sql.Timestamp;

public class QnA {
	private int q_num;
	private String mem_id;
	private String q_sub;
	private String q_con;
	private int q_rcnt;
	private int q_ref;
	private int q_lev;
	private int q_seq;
	private Timestamp q_date;
	
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getQ_sub() {
		return q_sub;
	}
	public void setQ_sub(String q_sub) {
		this.q_sub = q_sub;
	}
	public String getQ_con() {
		return q_con;
	}
	public void setQ_con(String q_con) {
		this.q_con = q_con;
	}
	public int getQ_rcnt() {
		return q_rcnt;
	}
	public void setQ_rcnt(int q_rcnt) {
		this.q_rcnt = q_rcnt;
	}
	public int getQ_ref() {
		return q_ref;
	}
	public void setQ_ref(int q_ref) {
		this.q_ref = q_ref;
	}
	public int getQ_lev() {
		return q_lev;
	}
	public void setQ_lev(int q_lev) {
		this.q_lev = q_lev;
	}
	public int getQ_seq() {
		return q_seq;
	}
	public void setQ_seq(int q_seq) {
		this.q_seq = q_seq;
	}
	public Timestamp getQ_date() {
		return q_date;
	}
	public void setQ_date(Timestamp q_date) {
		this.q_date = q_date;
	}
	
	
}
