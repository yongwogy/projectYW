package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Member;
import model.Seller;

@Repository
public class BoarddaoImpl implements Boarddao {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertMember(Member member) throws Exception {
//		getSession();
		return sqlSession.insert("join", member);
	}
	
	public int checkMemberId(String id) throws Exception{
		int re = -1;
		Seller seller = (Seller) sqlSession.selectOne("login_check1", id);
		Member member = (Member) sqlSession.selectOne("login_check", id);
		if (member != null || seller != null)
			re = 1; 	// 중복id
		return re;
	}
	//아이디 체크
	public Member usercheck(String id) throws Exception{
		return (Member) sqlSession.selectOne("login_check", id);
	}
	public Seller usercheck1(String id1) throws Exception{
		return (Seller) sqlSession.selectOne("login_check1", id1);
	}
	//회원수정
	public int updatemember(Member member) throws Exception {
//		getSession();
		return sqlSession.update("edit", member);
	}
	public int updateseller(Seller seller) throws Exception {
//		getSession();
		return sqlSession.update("edit1", seller);
	}
	/* 회원삭제 */
//	@Transactional
	public int deletemember(Member delm) throws Exception {
//		getSession();
		return sqlSession.update("member_delete", delm);
	}
	/* 회원삭제 */
//	@Transactional
	public int deletesel(Seller dels) throws Exception {
//		getSession();
		return sqlSession.update("member_delete1", dels);
	}
	
	/* 비번 검색 */
	public Member findpw(Member pm) throws Exception {
//		getSession();
		return (Member) sqlSession.selectOne("pwfind", pm);
	}
	public Seller findpw1(Seller ps) throws Exception {
//		getSession();
		return (Seller) sqlSession.selectOne("pwfind1", ps);
	}
	/* 아이디 검색 */
	public Member findid1(Member pm) throws Exception {
//		getSession();
		return (Member) sqlSession.selectOne("idfind1", pm);
	}
	public Seller findid2(Seller ps) throws Exception {
//		getSession();
		return (Seller) sqlSession.selectOne("idfind2", ps);
	}
	public int insertsel(Seller seller) throws Exception {
//		getSession();
		return sqlSession.insert("join1", seller);
	}
	//리뷰쓴 유저찾기(사진용)
	public Member revuserfind(String id) throws Exception{
		return (Member) sqlSession.selectOne("revuserfind", id);
	}
	//예약시 판매자id 불가체크
	public int idcheck_nonsel(String sel_id) throws Exception{
		int re = -1;
		Seller seller = (Seller) sqlSession.selectOne("idcheck_nonsel", sel_id);
		if (seller != null)
			re = 1; 	
		return re;
	}
}
