package service;

import model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDAOImp;
import model.PPhoto;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired 
	private ProductDAOImp proDao;

	// product 상품등록신청
	@Override
	public int proinsertdo(Product pro) throws Exception {
		return proDao.proinsertdo(pro);
	}
	
	// product 등록시점 pro_no 구하기
	@Override
	public Product proload(String sel_id) throws Exception {
		
		return proDao.proload(sel_id);
	}
	
	// PPhoto 상품등록신청
	@Override
	public int ppinsertdo(PPhoto pp) throws Exception {
		
		return proDao.ppinsertdo(pp);
	}

	// product 목록구하기
	@Override
	public List getprolist(String sel_id) throws Exception {

		return proDao.getprolist(sel_id);
	}

	// 별점평균구하기
	@Override
	public double getstaravg(int pro_no) throws Exception {

		return proDao.getstaravg(pro_no);
	}

	// 리뷰수 구하기
	@Override
	public int getrevcount(int pro_no) throws Exception {
		
		return proDao.getrevcount(pro_no);
	}
	
	// product 상세성보 구하기
	@Override
	public Product getprodetail(int pro_no) throws Exception {
	
		return proDao.getprodetail(pro_no);
	}

	// pphoto 리스트 구하기
	@Override
	public List getpplist(int pro_no) throws Exception {
		
		return proDao.getpplist(pro_no);
	}

	//review 리스트 구하기	
	@Override
	public List getrevlist(int pro_no) throws Exception {
		
		return proDao.getrevlist(pro_no);
	}
	
	//상품수정
	@Override
	public int proupdate(Product pro) throws Exception{
		
		return proDao.proupdate(pro);
	}

	@Override
	public int ppupdate(PPhoto pp) throws Exception {

		return proDao.ppupdate(pp);
	}
	
	@Override
	public int deletepro(int pro_no) throws Exception {

		return proDao.deletepro(pro_no);
	}
	
	@Override
	public int deletepphoto(int pp_no) throws Exception {

		return proDao.deletepphoto(pp_no);
	}

	@Override
	public int deletepplist(int pro_no) throws Exception {

		return proDao.deletepplist(pro_no);
	}

	@Override
	public int ppcount(int pro_no) throws Exception {

		return proDao.ppcount(pro_no);
	}
	
	// +상품 다시제줄(pro_s 2를 0로)
	@Override
	public int resubmitpro_s(int pro_no) throws Exception {

		return proDao.resubmitpro_s(pro_no);
	}








}
