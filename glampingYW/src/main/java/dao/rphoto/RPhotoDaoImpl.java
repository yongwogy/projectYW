package dao.rphoto;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.RPhoto;

@Repository
public class RPhotoDaoImpl implements RPhotoDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<RPhoto> list(int rm_no) {
		return sst.selectList("rphotos.list", rm_no);
	}
}
