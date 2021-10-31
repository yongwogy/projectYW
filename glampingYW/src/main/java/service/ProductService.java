package service;

import model.Product;

import java.util.List;

import model.PPhoto;

public interface ProductService {
	
	public int proinsertdo(Product pro) throws Exception; 
	
	public Product proload(String sel_id) throws Exception;
	
	public int ppinsertdo(PPhoto pp) throws Exception; 
	
	public List getprolist(String sel_id) throws Exception;
	
	public double getstaravg(int pro_no) throws Exception;
	
	public int getrevcount(int pro_no) throws Exception;
		
	public Product getprodetail(int pro_no) throws Exception;
	
	public List getpplist(int pro_no) throws Exception;
	
	public List getrevlist(int pro_no) throws Exception;
	
	public int proupdate(Product pro) throws Exception;
		
	public int ppupdate(PPhoto pp) throws Exception;
	
	public int deletepro(int pro_no) throws Exception;
	
	public int deletepphoto(int pp_no) throws Exception;
	
	public int deletepplist(int pro_no) throws Exception;
	
	public int ppcount(int pro_no) throws Exception;
	
	public int resubmitpro_s(int pro_no) throws Exception; 
}
