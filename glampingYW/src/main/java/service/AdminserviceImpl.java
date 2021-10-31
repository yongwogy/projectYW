package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminDAOImpl;


@Service
public class AdminserviceImpl implements Adminservice{
	
	@Autowired
	private AdminDAOImpl adminDao;
	
	// member전체 리스트 불러오기
	@Override
	public List getmemlist() throws Exception {
		
		return adminDao.getmemlist();
	}
	
	// seller전체 리스트 불러오기
	@Override
	public List getsellist() throws Exception {
		
		return adminDao.getsellist();
	}

	//일반회원 승인
	@Override
	public int appmember(String mem_id) throws Exception {

		return adminDao.appmember(mem_id);
	}

	//일반회원 탈퇴처리
	@Override
	public int banmember(String mem_id) throws Exception {

		return adminDao.banmember(mem_id);
	}
	
	// 판매자 승인
	@Override
	public int appseller(String sel_id) throws Exception {

		return adminDao.appseller(sel_id);
	}

	// 판매자 탈퇴처리
	@Override
	public int banseller(String sel_id) throws Exception {

		return adminDao.banseller(sel_id);
	}

	// 모든 prolist 불러오기
	@Override
	public List getallprolist() throws Exception {

		return adminDao.getallprolist();
	}

	//상품승인
	@Override
	public int apppro(int pro_no) throws Exception {

		return adminDao.apppro(pro_no);
	}

	//상품반려
	@Override
	public int banpro(int pro_no) throws Exception {
		
		return adminDao.banpro(pro_no);
	}
	
	//일반회원리스트 불러오기 rown기준
	@Override
	public List get_memList(HashMap Rows) throws Exception {

		return adminDao.get_memList(Rows);
	}
	
	//판매자리스트 불러오기 rown기준
	@Override
	public List get_selList(HashMap Rows) throws Exception {
		
		return adminDao.get_selList(Rows);
	}





	




	








}
