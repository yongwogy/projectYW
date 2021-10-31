package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Reservation;
import model.Review;
import model.Room;




@Repository
public class ReviewDAOImp implements ReviewDAO{

	@Autowired
	private SqlSession sqlsession;

	//리뷰리스트구하기
	@Override
	public List getrevlist(int pro_no) throws Exception {
	
		List<Review> revlist = sqlsession.selectList("reviews.getrevlist", pro_no);
		return revlist;
	}

	//내 리뷰리스트구하기(insert용)
	@Override
	public List getmyrevlist(Review rev) throws Exception {
		
		List<Review> revlist = sqlsession.selectList("reviews.getmyrevlist", rev);
		return revlist;
	}

	//리뷰입력
	@Override
	public int reviewinsertdo(Review rev) throws Exception {

		return sqlsession.insert("reviews.reviewinsertdo", rev);
	}
	
	//리뷰수정
	@Override
	public int reviewupdatedo(Review rev) throws Exception {

		return sqlsession.update("reviews.reviewupdatedo", rev);
	}

	//리뷰삭제
	@Override
	public int deletereview(int rev_no) throws Exception {

		return sqlsession.delete("reviews.deletereview", rev_no);
	}

	//내리뷰 찾기 
	@Override
	public Review researchreviewdo(Review rev) throws Exception {

		return (Review) sqlsession.selectOne("reviews.researchreviewdo", rev);
	}

	//리뷰수 구하기
	@Override
	public int getTotal(int pro_no) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("reviews.gettotal", pro_no);
	}

	//리뷰삭제(예약 완전삭제시 덤)
	@Override
	public int terminate_review(int res_no) throws Exception {

		return sqlsession.delete("reviews.terminate_review", res_no);
	}

	//상품삭제시 리뷰삭제
	@Override
	public int delete_proreview(int pro_no) throws Exception {
		
		return sqlsession.delete("reviews.delete_proreview", pro_no);
	}
	



	







	



	
}
