package service;

import java.util.List;

import model.PPhoto;
import model.Product;
import model.RPhoto;
import model.Room;

public interface RoomService {
	
	public int rminsertdo(Room rm) throws Exception; 
	
	public Room rmload(int pro_no) throws Exception;
	
	public int rpinsertdo(RPhoto rp) throws Exception; 
	
	public List getrmlist(int pro_no) throws Exception;
	
	public Room getlowpri(int pro_no) throws Exception;
	
	public Room getrmdetail(int rm_no) throws Exception;
	 
	public List getrplist(int rm_no) throws Exception;
	
	public int rmupdate(Room rm) throws Exception;
	
	public int rpupdate(RPhoto rp) throws Exception;
	
	public int deleterm(int rm_no) throws Exception;
	
	public int deleterphoto(int rp_no) throws Exception;
	
	public int deleterplist(int rm_no) throws Exception;
	
	public int rpcount(int rm_no) throws Exception;
	
	public int stop_rmsales(int rm_no) throws Exception;
	
	public int restart_rmsales(int rm_no) throws Exception;

}
