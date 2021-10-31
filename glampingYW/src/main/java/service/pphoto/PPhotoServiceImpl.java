package service.pphoto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.pphoto.PPhotoDao;
import model.PPhoto;

@Service
public class PPhotoServiceImpl implements PPhotoService{
	@Autowired
	private PPhotoDao ppd;
	
	public List<PPhoto> list(int pro_no) {
		
		return ppd.list(pro_no);
	}
	
}
