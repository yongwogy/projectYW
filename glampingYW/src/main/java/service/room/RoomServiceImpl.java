package service.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.room.RoomDao;
import model.Room;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomDao rmd;
	
	public List<Room> list(int pro_no) {
		return rmd.list(pro_no);
	}
}
