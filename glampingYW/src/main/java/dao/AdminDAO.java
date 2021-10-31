package dao;


import java.util.HashMap;
import java.util.List;

import model.Member;
import model.Product;
import model.Seller;



public interface AdminDAO {
	
	public List<Member> getmemlist() throws Exception;
	
	public List<Seller> getsellist() throws Exception;
	
	public int appmember(String mem_id) throws Exception;
	
	public int banmember(String mem_id) throws Exception;
	
	public int appseller(String sel_id) throws Exception;
	
	public int banseller(String sel_id) throws Exception;
	
	public List<Product> getallprolist() throws Exception;
	
	public int apppro(int pro_no) throws Exception;
	
	public int banpro(int pro_no) throws Exception;
	
	public List get_memList(HashMap Rows) throws Exception;
	
	public List get_selList(HashMap Rows) throws Exception;
	
	
}
