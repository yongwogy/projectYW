package dao.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	public int getTotal(Product product) {
		return sst.selectOne("products.gettotal", product);
	}
	
	public List<Product> listTop(Product product) {
		
		return sst.selectList("products.listtop", product);
	}
	
	public List<Product> listBest(Product product) {
		
		return sst.selectList("products.listbest", product);
	}
	
	public List<Product> list(Product product) {
		return sst.selectList("products.list", product);
	}
	
	public Product proview(int pro_no) {
		
		return sst.selectOne("products.select", pro_no);
	}
}
