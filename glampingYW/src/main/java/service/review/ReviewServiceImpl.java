package service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.review.ReviewDao;
import model.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDao rd;
	
	public List<Review> list(int pro_no) {
		return rd.list(pro_no);
	}
	
	public int getTotal(int pro_no) {
		return rd.getTotal(pro_no);
	}
}
