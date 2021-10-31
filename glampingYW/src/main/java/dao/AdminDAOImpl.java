package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Member;
import model.Product;
import model.Seller;


@Repository
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	private SqlSession sqlsession;
	
	// member전체 리스트 불러오기
	@Override
	public List<Member> getmemlist() throws Exception {
		List<Member> memlist = sqlsession.selectList("admins.getmemlist");
		return memlist;
	}
	
	// seller전체 리스트 불러오기
	@Override
	public List<Seller> getsellist() throws Exception {

		List<Seller> sellist = sqlsession.selectList("admins.getsellist");
		return sellist;
	}

	//일반회원 승인
	@Override
	public int appmember(String mem_id) throws Exception {

		return sqlsession.update("admins.appmember", mem_id);
	}
	
	//일반회원 탈퇴처리
	@Override
	public int banmember(String mem_id) throws Exception {
		
		return sqlsession.update("admins.banmember", mem_id);
	}
	
	//판매자 승인
	@Override
	public int appseller(String sel_id) throws Exception {

		return sqlsession.update("admins.appseller", sel_id);
	}

	//판매자 탈퇴처리
	@Override
	public int banseller(String sel_id) throws Exception {
	
		return sqlsession.update("admins.banseller", sel_id);
	}

	// 모든 prolist 불러오기
	@Override
	public List<Product> getallprolist() throws Exception {

		List<Product> prolist = sqlsession.selectList("admins.getallprolist");
		return prolist;
	}

	//상품승인
	@Override
	public int apppro(int pro_no) throws Exception {

		return sqlsession.update("admins.apppro", pro_no);
	}

	@Override
	public int banpro(int pro_no) throws Exception {
		
		return sqlsession.update("admins.banpro", pro_no);
	}
	
	//일반회원리스트 불러오기 rown기준
	@Override
	public List get_memList(HashMap Rows) throws Exception {

		List<Member> memlist = sqlsession.selectList("admins.get_memList", Rows);
		return memlist;
	}
	
	//판매자리스트 불러오기 rown기준
	@Override
	public List get_selList(HashMap Rows) throws Exception {

		List<Seller> sellist = sqlsession.selectList("admins.get_selList", Rows);
		return sellist;
	}



	
	


	




}
