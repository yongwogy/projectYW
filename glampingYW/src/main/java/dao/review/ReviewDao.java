package dao.review;

import java.util.List;

import model.Review;

public interface ReviewDao {
	List<Review> list(int pro_no);
	
	int getTotal(int pro_no);
}
