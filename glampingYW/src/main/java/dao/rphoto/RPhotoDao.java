package dao.rphoto;

import java.util.List;

import model.RPhoto;

public interface RPhotoDao {
	List<RPhoto> list(int rm_no);
}
