package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoarddaoImpl;
import model.Member;
import model.Seller;

@Service
public class BoardserviceImpl implements Boardservice{
	@Autowired
	private BoarddaoImpl bd;
	
	public int insertMember(Member member) throws Exception{
		return bd.insertMember(member);
	}
	public int checkMemberId(String id) throws Exception{
		return bd.checkMemberId(id);
	}
	
	public Member usercheck(String id) throws Exception{
		return bd.usercheck(id);
	}
	public Seller usercheck1(String id1) throws Exception{
		return bd.usercheck1(id1);
	}
	public int updatemember(Member member) throws Exception{
		return bd.updatemember(member);
	}
	public int updateseller(Seller seller) throws Exception{
		return bd.updateseller(seller);
	}
	public int deletemember(Member member) throws Exception{
		return bd.deletemember(member);
	}
	public int deletesel(Seller seller) throws Exception{
		return bd.deletesel(seller);
	}
	public Member findpw(Member m)throws Exception {
		return bd.findpw(m);
	}
	public Seller findpw1(Seller s)throws Exception {
		return bd.findpw1(s);
	}
	public Member findid1(Member m)throws Exception {
		return bd.findid1(m);
	}
	public Seller findid2(Seller s)throws Exception {
		return bd.findid2(s);
	}
	public int insertsel(Seller s) throws Exception{
		return bd.insertsel(s);
	}
	//리뷰쓴 유저찾기(사진용)
	public Member revuserfind(String id) throws Exception{
		return bd.revuserfind(id);
	}
	//예약시 판매자id 불가체크
	public int idcheck_nonsel(String sel_id) throws Exception{
		return bd.idcheck_nonsel(sel_id);
	}
}
