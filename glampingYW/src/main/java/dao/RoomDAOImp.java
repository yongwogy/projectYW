package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import model.RPhoto;
import model.Room;

@Repository
public class RoomDAOImp implements RoomDAO{

	@Autowired
	private SqlSession sqlsession;
	
	// room 상품등록신청
	@Override
	public int rminsertdo(Room rm) throws Exception {

		return sqlsession.insert("rooms.rminsertdo", rm);
	}

	// room 등록시점 rm_no 구하기
	@Override
	public Room rmload(int pro_no) throws Exception {

		return (Room) sqlsession.selectOne("rooms.rmload", pro_no);
	}

	// rphoto 상품등록신청
	@Override
	public int rpinsertdo(RPhoto rp) throws Exception {

		return sqlsession.insert("rphotos.rpinsertdo", rp);
	}

	// room 목록구하기
	@Override
	public List<Room> getrmlist(int pro_no) throws Exception {

		List<Room> rmlist = sqlsession.selectList("rooms.getrmlist", pro_no);
		return rmlist;
	}

	// product 중 젤 싼방 값구하기
	@Override
	public Room getlowpri(int pro_no) throws Exception {

		return (Room) sqlsession.selectOne("rooms.getlowpri", pro_no);
	}
	// room 정보 1개 구하기
	@Override
	public Room getrmdetail(int rm_no) throws Exception {

		return (Room) sqlsession.selectOne("rooms.getrmdetail", rm_no);
	}
	// rplist 목록 구하기
	@Override
	public List<RPhoto> getrplist(int rm_no) throws Exception {
		
		List<RPhoto> rplist = sqlsession.selectList("rphotos.getrplist", rm_no);
		return rplist;
	}

	
	//rm 수정
	@Override
	public int rmupdate(Room rm) throws Exception {

		return sqlsession.update("rooms.rmupdate", rm);
	}
	
	//rp 수정
	@Override
	public int rpupdate(RPhoto rp) throws Exception {

		return sqlsession.update("rphotos.rpupdate", rp);
	}
	
	//rm 삭제
	@Override
	public int deleterm(int rm_no) throws Exception {

		return sqlsession.delete("rooms.deleterm", rm_no);	
	}
	
	//rp 삭제
	@Override
	public int deleterphoto(int rp_no) throws Exception {
		
		return sqlsession.delete("rphotos.deleterphoto", rp_no);	
	}
	
	//rplist 삭제
	@Override
	public int deleterplist(int rm_no) throws Exception {

		return sqlsession.delete("rphotos.deleterplist", rm_no);	
	}

	// rplist 개수
	@Override
	public int rpcount(int rm_no) throws Exception {
		int rpcount = sqlsession.selectOne("rphotos.rpcount", rm_no);
		return rpcount;
	}

	//객실 영업중지
	@Override
	public int stop_rmsales(int rm_no) throws Exception {

		return sqlsession.update("rooms.stop_rmsales", rm_no);
	}

	//객실영업 재개
	@Override
	public int restart_rmsales(int rm_no) throws Exception {

		return sqlsession.update("rooms.restart_rmsales", rm_no);
	}








	



	
}
