package dao.pphoto;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.PPhoto;

@Repository
public class PPhotoDaoImpl implements PPhotoDao{
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<PPhoto> list(int pro_no) {
		
		return sst.selectList("pphotos.list", pro_no);
	}
}
