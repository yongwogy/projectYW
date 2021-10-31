package model;

import java.sql.Timestamp;

public class Product {
	private int pro_no;
	private String sel_id;
	private String pro_ceo;
	private String pro_name;
	private String pro_post;
	private String pro_addr;
	private String pro_n1;
	private String pro_n2;
	private double pro_x;
	private double pro_y;
	private String pro_con;
	private String pro_pic;
	private String pro_intro;
	private Timestamp pro_app;
	private Timestamp pro_joind;
	private int pro_s;
	
	//join용
	private Room roomR;
	
	//page
	private int startRow;
	private int endRow;
	
	//검색
	private String region;
	private String keyword;
	private Timestamp checkIn;
	private Timestamp checkOut;
	private int cap;
	
	// 별점, 최저가, 리뷰수, 취소신청 예약건수
	private double star_avg;
	private int rev_cnt;
	private int rv_total;
	private int del_no;
	
	//내 예약정보
	private int res_no;
	
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public String getSel_id() {
		return sel_id;
	}
	public void setSel_id(String sel_id) {
		this.sel_id = sel_id;
	}
	public String getPro_ceo() {
		return pro_ceo;
	}
	public void setPro_ceo(String pro_ceo) {
		this.pro_ceo = pro_ceo;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_post() {
		return pro_post;
	}
	public void setPro_post(String pro_post) {
		this.pro_post = pro_post;
	}
	public String getPro_addr() {
		return pro_addr;
	}
	public void setPro_addr(String pro_addr) {
		this.pro_addr = pro_addr;
	}
	public String getPro_n1() {
		return pro_n1;
	}
	public void setPro_n1(String pro_n1) {
		this.pro_n1 = pro_n1;
	}
	public String getPro_n2() {
		return pro_n2;
	}
	public void setPro_n2(String pro_n2) {
		this.pro_n2 = pro_n2;
	}
	public double getPro_x() {
		return pro_x;
	}
	public void setPro_x(double pro_x) {
		this.pro_x = pro_x;
	}
	public double getPro_y() {
		return pro_y;
	}
	public void setPro_y(double pro_y) {
		this.pro_y = pro_y;
	}
	public String getPro_con() {
		return pro_con;
	}
	public void setPro_con(String pro_con) {
		this.pro_con = pro_con;
	}
	public String getPro_pic() {
		return pro_pic;
	}
	public void setPro_pic(String pro_pic) {
		this.pro_pic = pro_pic;
	}
	public String getPro_intro() {
		return pro_intro;
	}
	public void setPro_intro(String pro_intro) {
		this.pro_intro = pro_intro;
	}
	public Timestamp getPro_app() {
		return pro_app;
	}
	public void setPro_app(Timestamp pro_app) {
		this.pro_app = pro_app;
	}
	public Timestamp getPro_joind() {
		return pro_joind;
	}
	public void setPro_joind(Timestamp pro_joind) {
		this.pro_joind = pro_joind;
	}
	public int getPro_s() {
		return pro_s;
	}
	public void setPro_s(int pro_s) {
		this.pro_s = pro_s;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Timestamp getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}
	public Timestamp getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public Room getRoomR() {
		return roomR;
	}
	public void setRoomR(Room roomR) {
		this.roomR = roomR;
	}
	public double getStar_avg() {
		return star_avg;
	}
	public void setStar_avg(double star_avg) {
		this.star_avg = star_avg;
	}
	public int getRev_cnt() {
		return rev_cnt;
	}
	public void setRev_cnt(int rev_cnt) {
		this.rev_cnt = rev_cnt;
	}
	public int getRv_total() {
		return rv_total;
	}
	public void setRv_total(int rv_total) {
		this.rv_total = rv_total;
	}
	public int getRes_no() {
		return res_no;
	}
	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}
	public int getDel_no() {
		return del_no;
	}
	public void setDel_no(int del_no) {
		this.del_no = del_no;
	}
	
	
}
