package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Reservation;
import model.Review;
import model.Room;




@Repository
public class ReservationDAOImp implements ReservationDAO{

	@Autowired
	private SqlSession sqlsession;
	
	//예약입력
	@Override
	public int resinsertdo(Reservation res) throws Exception {
		
		return sqlsession.insert("reservations.resinsertdo", res);
	}
	
	//reslist불러오기
	@Override
	public List getreslist(int rm_no) throws Exception {

		List<Reservation> reslist = sqlsession.selectList("reservations.getreslist", rm_no);
		return reslist;
	}
	
	//myreslist불러오기
	@Override
	public List getmyreslist(String mem_id) throws Exception {
		
		List<Reservation> reslist = sqlsession.selectList("reservations.getmyreslist", mem_id);
		return reslist;
	}

	//예약취소(상태값 2로바꿈)
	@Override
	public int delreserve(int res_no) throws Exception {
		
		return sqlsession.update("reservations.delreserve", res_no);
	}

	//id,pro_no으로 reslist 불러오기
	@Override
	public List getmyproreslist(Review rev) throws Exception {
		
		List<Reservation> reslist = sqlsession.selectList("reservations.getmyproreslist", rev);
		return reslist;
	}

	//id,pro_no으로 reslist 불러오기2
	@Override
	public List getmyproreslist2(Review rev) throws Exception {
		
		List<Reservation> reslist = sqlsession.selectList("reservations.getmyproreslist2", rev);
		return reslist;
	}

	//pro_no으로 reslist불러오기 캘린더용
	@Override
	public List getreslist_pro(int pro_no) throws Exception {
	
		List<Reservation> reslist = sqlsession.selectList("reservations.getreslist_pro", pro_no);
		return reslist;
	}

	//res_no으로 고객 예약정보 1개 불러오기
	@Override
	public Reservation resdetailone(int res_no) throws Exception {

		return (Reservation) sqlsession.selectOne("reservations.resdetailone", res_no);
	}

	//사용된 예약항목 상태값 0으로 변경
	@Override
	public int update_res_s(String mem_id) throws Exception {
		
		return sqlsession.update("reservations.update_res_s", mem_id);
	}

	//취소신청한 예약리스트 불러오기(각 상품당)
	@Override
	public List getdelreslist(int pro_no) throws Exception {

		List<Reservation> delreslist = sqlsession.selectList("reservations.getdelreslist", pro_no);
		return delreslist;
	}

	//에약취소신청 거부
	@Override
	public int return_reserve(int res_no) throws Exception {

		return sqlsession.update("reservations.return_reserve", res_no);
	}

	//예약 완전삭제
	@Override
	public int terminate_reserve(int res_no) throws Exception {

		return sqlsession.delete("reservations.terminate_reserve", res_no);
	}

	// 사용된 예약항목 상태값 0으로 변경(판매자)
	@Override
	public int update_res_sp(int pro_no) throws Exception {
	
		return sqlsession.update("reservations.update_res_sp", pro_no);
	}

	//상품삭제시 예약삭제
	@Override
	public int delete_proreservation(int pro_no) throws Exception {
	
		return sqlsession.delete("reservations.delete_proreservation", pro_no);
	}


	







	



	
}
