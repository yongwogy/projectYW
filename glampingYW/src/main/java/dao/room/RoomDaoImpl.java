package dao.room;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Room;

@Repository
public class RoomDaoImpl implements RoomDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<Room> list(int pro_no) {
		return sst.selectList("rooms.list", pro_no);
	}
}
