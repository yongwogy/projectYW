package service.rphoto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.rphoto.RPhotoDao;
import model.RPhoto;

@Service
public class RPhotoServiceImpl  implements RPhotoService {
	@Autowired
	private RPhotoDao rpd;
	
	public List<RPhoto> list(int rm_no) {
		return rpd.list(rm_no);
	}
}
