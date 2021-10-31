package dao.review;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<Review> list(int pro_no) {
		return sst.selectList("reviews.list", pro_no);
	}
	
	public int getTotal(int pro_no) {
		return sst.selectOne("reviews.gettotal", pro_no);
	}
}
