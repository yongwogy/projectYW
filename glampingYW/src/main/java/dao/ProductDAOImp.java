package dao;

import model.PPhoto;
import model.Product;
import model.Review;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAOImp implements ProductDAO{

	@Autowired
	private SqlSession sqlsession;
	
	// product 상품등록신청
	@Override
	public int proinsertdo(Product pro) throws Exception {
		return sqlsession.insert("products.proinsertdo", pro);		
	}
	
	// product 등록시점 pro_no 구하기
	@Override
	public Product proload(String sel_id) throws Exception {	
		return (Product) sqlsession.selectOne("products.proload", sel_id);
	}
	// pphoto 상품등록신청
	@Override
	public int ppinsertdo(PPhoto pp) throws Exception {
		return sqlsession.insert("pphotos.ppinsertdo", pp);	
	}

	// product 목록구하기
	@Override
	public List<Product> getprolist(String sel_id) throws Exception {
		
		List<Product> prolist = sqlsession.selectList("products.getprolist", sel_id);
		return prolist;
	}

	// 별점평균구하기
	@Override
	public double getstaravg(int pro_no) throws Exception {
		double savg_no = 0;
		savg_no = sqlsession.selectOne("reviews.getstaravg", pro_no);
	
		return savg_no;
		
	}

	// 리뷰수 구하기
	@Override
	public int getrevcount(int pro_no) throws Exception {
		int rev_count = 0;	
		rev_count = sqlsession.selectOne("reviews.getrevcount", pro_no);
		return rev_count;
	}
	
	// product 상세성보 구하기
	@Override
	public Product getprodetail(int pro_no) throws Exception {

		return (Product) sqlsession.selectOne("products.getprodetail", pro_no);
	}

	// pphoto 리스트 구하기
	@Override
	public List getpplist(int pro_no) throws Exception {
		
		List<PPhoto> pplist = sqlsession.selectList("pphotos.getpplist", pro_no);
		return pplist;
	}
	
	//review 리스트 구하기
	@Override
	public List getrevlist(int pro_no) throws Exception {

		List<Review> relist = sqlsession.selectList("reviews.getrevlist", pro_no);	
		return relist;
	}
	
	// product 수정
	@Override
	public int proupdate(Product pro) throws Exception {
		
		return sqlsession.update("products.proupdate", pro);	
	}
	// pp 수정
	@Override
	public int ppupdate(PPhoto pp) throws Exception {

		return sqlsession.update("pphotos.ppupdate", pp);
	}
	
	//product 삭제
	@Override
	public int deletepro(int pro_no) throws Exception {

		return sqlsession.delete("products.deletepro", pro_no);	
	}
	
	//pphoto 삭제
	@Override
	public int deletepphoto(int pp_no) throws Exception {
		
		return sqlsession.delete("pphotos.deletepphoto", pp_no);	
	}

	//pplist 삭제
	@Override
	public int deletepplist(int pro_no) throws Exception {
		
		return sqlsession.delete("pphotos.deletepplist", pro_no);	
	}
	
	//pplist 수 구하기
	@Override
	public int ppcount(int pro_no) throws Exception {
		int ppcount = sqlsession.selectOne("pphotos.ppcount", pro_no);
		return ppcount;
	}

	// +상품 다시제줄(pro_s 2를 0로)
	@Override
	public int resubmitpro_s(int pro_no) throws Exception {

		return sqlsession.update("products.resubmitpro_s", pro_no);
	}




}
