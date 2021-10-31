package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RoomDAOImp;
import model.RPhoto;
import model.Room;



@Service
public class RoomServiceImp implements RoomService{

	@Autowired
	private RoomDAOImp rmDao;
	
	@Override
	public int rminsertdo(Room rm) throws Exception {
		
		return rmDao.rminsertdo(rm);
	}

	@Override
	public Room rmload(int pro_no) throws Exception {

		return rmDao.rmload(pro_no);
	}

	@Override
	public int rpinsertdo(RPhoto rp) throws Exception {
		
		return rmDao.rpinsertdo(rp);
	}

	@Override
	public List getrmlist(int pro_no) throws Exception {

		return rmDao.getrmlist(pro_no);
	}

	@Override
	public Room getlowpri(int pro_no) throws Exception {
		// TODO Auto-generated method stub
		return rmDao.getlowpri(pro_no);
	}

	@Override
	public Room getrmdetail(int rm_no) throws Exception {
		// TODO Auto-generated method stub
		return rmDao.getrmdetail(rm_no);
	}

	@Override
	public List getrplist(int rm_no) throws Exception {
		// TODO Auto-generated method stub
		return rmDao.getrplist(rm_no);
	}
	
	@Override
	public int rmupdate(Room rm) throws Exception {
		// TODO Auto-generated method stub
		return rmDao.rmupdate(rm);
	}
	
	@Override
	public int rpupdate(RPhoto rp) throws Exception {
		// TODO Auto-generated method stub
		return rmDao.rpupdate(rp);
	}
	
	@Override
	public int deleterm(int rm_no) throws Exception {

		return rmDao.deleterm(rm_no);
	}

	@Override
	public int deleterphoto(int rp_no) throws Exception {

		return rmDao.deleterphoto(rp_no);
	}
	
	@Override
	public int deleterplist(int rm_no) throws Exception {

		return rmDao.deleterplist(rm_no);
	}

	@Override
	public int rpcount(int rm_no) throws Exception {

		return rmDao.rpcount(rm_no);
	}

	//객실 영업중지
	@Override
	public int stop_rmsales(int rm_no) throws Exception {
	
		return rmDao.stop_rmsales(rm_no);
	}

	//객실영업 재개
	@Override
	public int restart_rmsales(int rm_no) throws Exception {

		return rmDao.restart_rmsales(rm_no);
	}














	




}
