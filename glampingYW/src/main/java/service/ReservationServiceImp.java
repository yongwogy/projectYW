package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReservationDAOImp;
import model.Reservation;
import model.Review;


@Service
public class ReservationServiceImp implements ReservationService{
	
	@Autowired
	private ReservationDAOImp resDao;
	
	
	//예약실행
	@Override
	public int resinsertdo(Reservation res) throws Exception {
		
		return resDao.resinsertdo(res);
	}
	
	//reslist불러오기
	@Override
	public List getreslist(int rm_no) throws Exception {
		
		return resDao.getreslist(rm_no);
	}

	//myreslist불러오기
	@Override
	public List getmyreslist(String mem_id) throws Exception {
		
		return resDao.getmyreslist(mem_id);
	}

	//예약취소(상태값 2로바꿈)
	@Override
	public int delreserve(int res_no) throws Exception {
		
		return resDao.delreserve(res_no);
	}

	//id,pro_no으로 reslist 불러오기
	@Override
	public List getmyproreslist(Review rev) throws Exception {

		return resDao.getmyproreslist(rev);
	}
	
	//id,pro_no으로 reslist 불러오기2
	@Override
	public List getmyproreslist2(Review rev) throws Exception {
		
		return resDao.getmyproreslist2(rev);
	}
	
	//pro_no으로 reslist불러오기 캘린더용
	@Override
	public List getreslist_pro(int pro_no) throws Exception {

		return resDao.getreslist_pro(pro_no);
	}

	//res_no으로 고객 예약정보 1개 불러오기
	@Override
	public Reservation resdetailone(int res_no) throws Exception {
		
		return resDao.resdetailone(res_no);
	}

	//사용된 예약항목 상태값 0으로 변경
	@Override
	public int update_res_s(String mem_id) throws Exception {
		
		return resDao.update_res_s(mem_id);
	}

	//취소신청한 예약리스트 불러오기(각 상품당)
	@Override
	public List getdelreslist(int pro_no) throws Exception {

		return resDao.getdelreslist(pro_no);
	}

	//에약취소신청 거부
	@Override
	public int return_reserve(int res_no) throws Exception {

		return resDao.return_reserve(res_no);
	}

	//예약 완전삭제
	@Override
	public int terminate_reserve(int res_no) throws Exception {

		return resDao.terminate_reserve(res_no);
	}

	// 사용된 예약항목 상태값 0으로 변경(판매자)
	@Override
	public int update_res_sp(int pro_no) throws Exception {

		return resDao.update_res_sp(pro_no);
	}

	//상품삭제시 예약삭제
	@Override
	public int delete_proreservation(int pro_no) throws Exception {

		return resDao.delete_proreservation(pro_no);
	}

	

	
	
	


}
