package dao.pphoto;

import java.util.List;

import model.PPhoto;

public interface PPhotoDao {
	
	List<PPhoto> list(int pro_no);
}
