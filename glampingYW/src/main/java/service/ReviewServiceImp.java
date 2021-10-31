package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReviewDAOImp;
import model.Review;


@Service
public class ReviewServiceImp implements ReviewService{
	
	@Autowired
	private ReviewDAOImp revDao;

	//리뷰리스트구하기
	@Override
	public List getrevlist(int pro_no) throws Exception {
		
		return revDao.getrevlist(pro_no);
	}

	//내 리뷰리스트구하기(insert용)
	@Override
	public List getmyrevlist(Review rev) throws Exception {
	
		return revDao.getmyrevlist(rev);
	}

	//리뷰입력
	@Override
	public int reviewinsertdo(Review rev) throws Exception {

		return revDao.reviewinsertdo(rev);
	}
	
	
	//리뷰수정
	@Override
	public int reviewupdatedo(Review rev) throws Exception {

		return revDao.reviewupdatedo(rev);
	}

	//리뷰삭제
	@Override
	public int deletereview(int rev_no) throws Exception {

		return revDao.deletereview(rev_no);
	}

	//내리뷰 찾기
	@Override
	public Review researchreviewdo(Review rev) throws Exception {
	
		return revDao.researchreviewdo(rev);
	}

	//리뷰수 구하기
	@Override
	public int getTotal(int pro_no) throws Exception {

		return revDao.getTotal(pro_no);
	}

	//리뷰삭제(예약 완전삭제시 덤)
	@Override
	public int terminate_review(int res_no) throws Exception {

		return revDao.terminate_review(res_no);
	}

	//상품삭제시 리뷰삭제
	@Override
	public int delete_proreview(int pro_no) throws Exception {

		return revDao.delete_proreview(pro_no);
	}




	

	
	
	


}
