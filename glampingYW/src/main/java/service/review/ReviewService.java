package service.review;

import java.util.List;

import model.Review;

public interface ReviewService {
	List<Review> list(int pro_no);
	
	int getTotal(int pro_no);
}
