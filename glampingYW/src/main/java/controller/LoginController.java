package controller;

import java.io.File;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.Member;
import model.Seller;
import service.BoardserviceImpl;


@Controller
public class LoginController {
	
	@Autowired
	private BoardserviceImpl boardservice;
	
	
	@RequestMapping("login")
	public String member_login(Model mo) {
	
		return "login/login";
	}
	
	
	/* 비번찾기 폼 */
	@RequestMapping("pwfind")
	public String pwfind()throws Exception{
		
		return "login/memorselpw";
		
	}
	@RequestMapping("pwfind1")
	public String pwfind1()throws Exception{
		
		return "login/pwfind1";
		
	}
	@RequestMapping("pwfind2")
	public String pwfind2()throws Exception{
		
		return "login/pwfind2";
		
	}
	
	/* 아이디찾기 폼 */
	@RequestMapping("idfind")
	public String idfind() {

		return "login/memorselid";
		
	}
	@RequestMapping("idfind1")
	public String idfind1() {

		return "login/idfind1";
		
	}
	@RequestMapping("idfind2")
	public String idfind2() {

		return "login/idfind2";
		
	}
	
	@RequestMapping("join")
	public String join() {

		return "login/memorselj";
	}
	@RequestMapping("memjoin")
	public String join1() {

		return "login/join1";
	}
	@RequestMapping("seljoin")
	public String join2() {

		return "login/join2";
	}
	@RequestMapping("mainpage")
	public String log() {
			
		return "login/join1";
	}
	
	/* 일반회원 가입 저장(fileupload) */
	@RequestMapping("join_ok")
	public String member_join_ok(@RequestParam("mem_pic1") MultipartFile mf, @RequestParam("mem_id") String mem_id,
								 Member member,
								 HttpServletRequest request,
								 Model model) throws Exception {

		// 파일이름앞에 난수및 무작위문자
		String filename1 = mf.getOriginalFilename();
		
		int ran = ((int)(Math.random()*1000000000));	
		StringBuffer stsum = new StringBuffer();
	    for (int i = 0; i <= 8; i++) {
	        char ch = (char) ((Math.random() * 26) + 65);
	        String chc = String.valueOf(ch);        
	        stsum.append(chc);
	      }		
		StringBuffer stsum2 = stsum.append(ran);
		String picf = stsum2.toString();
		
		String filename = picf.concat(filename1);
		// 파일이름앞에 난수및 무작위문자 종료
		
		int size = (int) mf.getSize();
		
		if(size > 0) {
		String path = request.getRealPath("upload");

		int result=0;
		
		String file[] = new String[2];

		StringTokenizer st = new StringTokenizer(filename, ".");
		file[0] = st.nextToken();		
		file[1] = st.nextToken();		// 확장자	
		
		if(size > 100000){
			result=1;
			model.addAttribute("result", result);
			
			return "login/uploadresult";
			
		}else if(!file[1].equals("jpg") &&
				 !file[1].equals("gif") &&
				 !file[1].equals("png") ){
			
			result=2;
			model.addAttribute("result", result);
			
			return "login/uploadresult";
		}
		

		if (size > 0) { // 첨부파일이 전송된 경우

			mf.transferTo(new File(path + "/" + filename));
			member.setMem_pic(filename);

		}
		
		}
		
		String mem_gen = request.getParameter("mem_gen").trim();	
		member.setMem_gen(mem_gen);
		
		
		int re = boardservice.checkMemberId(mem_id);		
		if(re == 1) {
			model.addAttribute("re", re);
			return "login/uploadresult";
		}
		
		int meminsert_result = boardservice.insertMember(member);
		model.addAttribute("meminsert_result", meminsert_result);
		return "login/okresult";
	}
	
	/* 판매자 가입 저장(fileupload) */
	@RequestMapping("sel_join_ok")
	public String sel_join_ok(@RequestParam("sel_pic1") MultipartFile mf, @RequestParam("sel_id") String sel_id,
								 Seller s,
								 HttpServletRequest request,
								 Model model) throws Exception {

		// 파일이름앞에 난수및 무작위문자
		String filename1 = mf.getOriginalFilename();
		
		int ran = ((int)(Math.random()*1000000000));	
		StringBuffer stsum = new StringBuffer();
	    for (int i = 0; i <= 8; i++) {
	        char ch = (char) ((Math.random() * 26) + 65);
	        String chc = String.valueOf(ch);        
	        stsum.append(chc);
	      }		
		StringBuffer stsum2 = stsum.append(ran);
		String picf = stsum2.toString();
		
		String filename = picf.concat(filename1);
		// 파일이름앞에 난수및 무작위문자 종료
		
		int size = (int) mf.getSize();
		
		if(size > 0) {
			
		String path = request.getRealPath("upload");
		
		int result=0;
		
		String file[] = new String[2];

		
		StringTokenizer st = new StringTokenizer(filename, ".");
		file[0] = st.nextToken();		
		file[1] = st.nextToken();		// 확장자	
		
		if(size > 100000){
			result=1;
			model.addAttribute("result", result);
			
			return "login/uploadresult";
			
		}else if(!file[1].equals("jpg") &&
				 !file[1].equals("gif") &&
				 !file[1].equals("png") ){
			
			result=2;
			model.addAttribute("result", result);
			
			return "login/uploadresult";
		}
		

		if (size > 0) { // 첨부파일이 전송된 경우

			mf.transferTo(new File(path + "/" + filename));
			s.setSel_pic(filename);
		}
		
		}


		int re = boardservice.checkMemberId(sel_id);		
		if(re == 1) {
			model.addAttribute("re", re);
			return "login/uploadresult";
		}
		
		int selinsert_result = boardservice.insertsel(s);
		model.addAttribute("selinsert_result", selinsert_result);
		return "login/okresult";
	}
	
	
	// ID중복검사 ajax함수로 처리부분
		@RequestMapping("idcheck")
		public String member_idcheck(@RequestParam("mid") String id, Model model) throws Exception {
	
			int result = boardservice.checkMemberId(id);
			model.addAttribute("result", result);

			return "login/idcheckResult";
		}
		
	// 예약시 판매자 아이디 체크 ajax함수로 처리부분
		@ResponseBody
		@RequestMapping("idcheck_nonsel")
		public int idcheck_nonsel(String sel_id) throws Exception {
			int result = boardservice.idcheck_nonsel(sel_id);
			return result;
		}
		

		/* 로그인 인증 */
		@RequestMapping("login_ok1")
		public String member_login_ok1(@RequestParam("sel_id") String id, 
				                      @RequestParam("sel_pw") String pw1,
				                      HttpSession session, 
				                      Model model) throws Exception {
			
			
			int result=0;
			Seller s = boardservice.usercheck1(id);

			if (s == null) {	// 등록되지 않은 회원일때
				
				result = 1;
				model.addAttribute("result", result);
				
				return "login/loginresult";
				
			} else {			// 등록된 회원일때
				if (s.getSel_pw().equals(pw1)) {// 비번이 같을때
					session.setAttribute("id", id);

					String sel_name = s.getSel_name();
					String sel_pic = s.getSel_pic();

					model.addAttribute("sel_name", sel_name);
					model.addAttribute("sel_pic", sel_pic);

					int loginresult = 1;
					model.addAttribute("loginresult", loginresult);
					return "login/okresult";
					
				} else {// 비번이 다를때
					result = 2;
					model.addAttribute("result", result);
					
					return "login/loginresult";				
				}
			}
			

		}
		
		/* 로그인 인증 */
		@RequestMapping("login_ok")
		public String member_login_ok(@RequestParam("mem_id") String id, 
				                      @RequestParam("mem_pw") String pw,
				                      HttpSession session, 
				                      Model model) throws Exception {
			
			
			int result=0;
			Member m = boardservice.usercheck(id);

			if (m == null) {	// 등록되지 않은 회원일때
				
				result = 1;
				model.addAttribute("result", result);
				
				return "login/loginresult";
				
			} else {			// 등록된 회원일때
				if (m.getMem_pw().equals(pw)) {// 비번이 같을때
					session.setAttribute("id", id);

					String mem_name = m.getMem_name();
					String mem_pic = m.getMem_pic();

					model.addAttribute("mem_name", mem_name);
					model.addAttribute("mem_pic", mem_pic);

					int loginresult = 1;
					model.addAttribute("loginresult", loginresult);
					return "login/okresult";
					
				} else {// 비번이 다를때
					result = 2;
					model.addAttribute("result", result);
					
					return "login/loginresult";				
				}
			}
			

		}
		
		@RequestMapping("login_ok2")
		public String member_login_ok2(@RequestParam("id")String kid,
				                      HttpSession session
				                     ) throws Exception {
			
			
			
			session.setAttribute("kid", kid);

			return "product/main";				

		}
		
		
		//로그아웃
		@RequestMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			
			System.out.println("logout");
			return "login/logout";
		}

		/* 마이페이지 */
		@RequestMapping("mypage")
		public String mypage(HttpSession session,Model m1) throws Exception {
			String id = (String) session.getAttribute("id");
			
			Seller s = boardservice.usercheck1(id);
			Member m = boardservice.usercheck(id);
			
			m1.addAttribute("s", s);
			m1.addAttribute("m", m);
			return "login/mypage";
		}
		
		/* 회원정보 수정 폼 */
		@RequestMapping("myinfo")
		public String member_edit(HttpSession session, Model m) throws Exception {

			String id = (String) session.getAttribute("id");
			
			Seller edit1 = boardservice.usercheck1(id);
			Member editm = boardservice.usercheck(id);
		
			m.addAttribute("edit1", edit1);
			m.addAttribute("editm", editm);
			
			
			return "login/edit";
		}
		
		// 회원정보수정시 pw 체크 + 비번수정시 ajax함수로 처리부분 mem_pw
		@ResponseBody
		@RequestMapping("mempw_check")
		public int mempw_check(String mem_pw, HttpSession session) throws Exception {
			int result = 0;
			String id = (String) session.getAttribute("id");
			Member editm = this.boardservice.usercheck(id);
			if(editm.getMem_pw().equals(mem_pw)) {
				result = 1;
			}
			return result;
		}
	
		//회원정보 수정
		@RequestMapping("edit_ok")
		public String edit_ok(@RequestParam("mem_pic1") MultipartFile mf,
								Member member,
								 HttpServletRequest request, 
								 HttpSession session, 
								 Model model) throws Exception { 
			
			String id = (String) session.getAttribute("id");			
			Member editm = this.boardservice.usercheck(id);
										
	    	// 파일이름앞에 난수및 무작위문자
			String filename1 = mf.getOriginalFilename();
			int ran = ((int)(Math.random()*1000000000));	
			StringBuffer stsum = new StringBuffer();
		    for (int i = 0; i <= 8; i++) {
		        char ch = (char) ((Math.random() * 26) + 65);
		        String chc = String.valueOf(ch);        
		        stsum.append(chc);
		      }		
			StringBuffer stsum2 = stsum.append(ran);
			String picf = stsum2.toString();
			
			String filename = picf.concat(filename1);
			// 파일이름앞에 난수및 무작위문자 종료
			
			int size = (int) mf.getSize();	
			
			if (size > 0 ) { 	
			
			String path = request.getRealPath("upload");
					
			int result=0;		
			String file[] = new String[2];

	    	if(filename != ""){	 // 첨부파일이 전송된 경우		
			
			StringTokenizer st = new StringTokenizer(filename, ".");
			file[0] = st.nextToken();		
			file[1] = st.nextToken();		// 확장자
			
			
			if(size > 100000){
				result=1;
				model.addAttribute("result", result);
				
				return "login/uploadresult";
				
			}else if(!file[1].equals("jpg") &&
					 !file[1].equals("gif") &&
					 !file[1].equals("png") ){
				
				result=2;
				model.addAttribute("result", result);
				
				return "login/uploadresult";
			}	
				
			
		    }	
			if (size > 0) { // 첨부파일이 전송된 경우

				mf.transferTo(new File(path + "/" + filename));
				member.setMem_pic(filename);
				
				String im_path = path + "/" + editm.getMem_pic();
				File uploaded_image = new File(im_path);
				uploaded_image.delete();
			}
			
			} else { 
				member.setMem_pic(editm.getMem_pic());
			}
				
			
			member.setMem_id(id);
			int updateresult = boardservice.updatemember(member);
					
			model.addAttribute("mem_name", member.getMem_name());
			model.addAttribute("mem_pic", member.getMem_pic());
			model.addAttribute("updateresult", updateresult);
			
			return "login/okresult";
		}
		
		// 회원정보수정시 pw 체크 + 비번수정시 ajax함수로 처리부분 sel_pw
		@ResponseBody
		@RequestMapping("selpw_check")
		public int selpw_check(String sel_pw, HttpSession session) throws Exception {
			int result = 0;
			String id = (String) session.getAttribute("id");
			Seller edit1 = this.boardservice.usercheck1(id);
			if(edit1.getSel_pw().equals(sel_pw)) {
				result = 1;
			}
			return result;
		}
		
		@RequestMapping("edit_ok1")
		public String edit_ok1(@RequestParam("sel_pic1") MultipartFile mf,
								Seller seller,
								 HttpServletRequest request, 
								 HttpSession session, 
								 Model model) throws Exception { 
			
			String id = (String) session.getAttribute("id");		
			Seller edit1 = this.boardservice.usercheck1(id);
			
			
	    	// 파일이름앞에 난수및 무작위문자
			String filename1 = mf.getOriginalFilename();
			int ran = ((int)(Math.random()*1000000000));	
			StringBuffer stsum = new StringBuffer();
		    for (int i = 0; i <= 8; i++) {
		        char ch = (char) ((Math.random() * 26) + 65);
		        String chc = String.valueOf(ch);        
		        stsum.append(chc);
		      }		
			StringBuffer stsum2 = stsum.append(ran);
			String picf = stsum2.toString();
			
			String filename = picf.concat(filename1);
			// 파일이름앞에 난수및 무작위문자 종료
			
			int size = (int) mf.getSize();	
					
			if (size > 0 ) { 
			
			String path = request.getRealPath("upload");
					
			int result=0;		
			String file[] = new String[2];

			
	    	if(filename != ""){	 // 첨부파일이 전송된 경우		
			
			StringTokenizer st = new StringTokenizer(filename, ".");
			file[0] = st.nextToken();		
			file[1] = st.nextToken();		// 확장자
			
			
			if(size > 100000){
				result=1;
				model.addAttribute("result", result);
				
				return "login/uploadresult";
				
			}else if(!file[1].equals("jpg") &&
					 !file[1].equals("gif") &&
					 !file[1].equals("png") ){
				
				result=2;
				model.addAttribute("result", result);
				
				return "login/uploadresult";
			}	
				
			
		    }	
			if (size > 0) { // 첨부파일이 전송된 경우
				mf.transferTo(new File(path + "/" + filename));
				seller.setSel_pic(filename);
				
				String im_path = path + "/" + edit1.getSel_pic();
				File uploaded_image = new File(im_path);
				uploaded_image.delete();
			}
													
			} else {
				seller.setSel_pic(edit1.getSel_pic());
			}
			
			
			seller.setSel_id(id);
			int updateresult = boardservice.updateseller(seller);
			
			
			model.addAttribute("sel_name", seller.getSel_name());
			model.addAttribute("sel_pic", seller.getSel_pic());
			model.addAttribute("updateresult", updateresult);
			
			return "login/okresult";
		}
		
		/* 비밀번호 수정폼 */
		@RequestMapping("editpw")
		public String editpw(HttpSession session, Model m) throws Exception {
	
			String id = (String) session.getAttribute("id");
			
			Seller sel = boardservice.usercheck1(id);
			Member mem = boardservice.usercheck(id);
			
			m.addAttribute("mem", mem);
			m.addAttribute("m_id", id);
			
			m.addAttribute("sel", sel);
			m.addAttribute("s_id", id);

			return "login/editpw";
		}
		
		/* 회원 비밀번호 수정 */
		@RequestMapping("editpw_okm")
		public String editpw_okm(String newmem_pw, HttpSession session, Model m) throws Exception {
			String id = (String) session.getAttribute("id");
			Member mem = boardservice.usercheck(id);
			mem.setMem_pw(newmem_pw);
			
			int pwupdateresult = boardservice.updatemember(mem);
			m.addAttribute("pwupdateresult", pwupdateresult);
			return "login/okresult";
		}
		
		/* 판매자 비밀번호 수정 */
		@RequestMapping("editpw_oks")
		public String editpw_oks(String newsel_pw, HttpSession session, Model m) throws Exception {
			String id = (String) session.getAttribute("id");
			Seller sel = boardservice.usercheck1(id);
			sel.setSel_pw(newsel_pw);
			
			int pwupdateresult = boardservice.updateseller(sel);
			m.addAttribute("pwupdateresult", pwupdateresult);
			return "login/okresult";
		}
		
		/* 회원정보 삭제 폼 */
		@RequestMapping("del")
		public String member_del(HttpSession session, Model m) throws Exception {
			System.out.println("del");
			String id = (String) session.getAttribute("id");
			
			Seller dels = boardservice.usercheck1(id);
			Member delm = boardservice.usercheck(id);
			
			m.addAttribute("dels", dels);
			m.addAttribute("s_id", id);
			
			m.addAttribute("delm", delm);
			m.addAttribute("d_id", id);

			return "login/del";
		}
		
		/* 회원정보 삭제 완료 */
		@RequestMapping("del_ok1")
		public String member_del_ok(@RequestParam("pwd") String pass,
								    HttpSession session, Model m) throws Exception {
			System.out.println("del_ok");
			String id = (String) session.getAttribute("id");
			Member member = this.boardservice.usercheck(id);

			if (!member.getMem_pw().equals(pass)) {

				return "login/deleteresult";
				
			} else {// 비번이 같은 경우
				
				String up = session.getServletContext().getRealPath("upload");
				String fname = member.getMem_pic();
				System.out.println("up:"+up);
				
				// 디비에 저장된 기존 이진파일명을 가져옴
				if (fname != null) {// 기존 이진파일이 존재하면
					File delFile = new File(up +"/"+fname);
					delFile.delete();// 기존 이진파일을 삭제
				}
				Member delm = new Member();
				delm.setMem_id(id);

				int deleteresult = boardservice.deletemember(delm);// 삭제 메서드 호출
				m.addAttribute("deleteresult", deleteresult);	
				session.invalidate();	// 세션만료

				return "login/okresult";
			}
		}
		@RequestMapping("del_ok")
		public String member_del_ok1(@RequestParam("pwd") String pass,
								    HttpSession session, Model m) throws Exception {
			System.out.println("del_ok");
			String id = (String) session.getAttribute("id");
			Seller seller = this.boardservice.usercheck1(id);

			if (!seller.getSel_pw().equals(pass)) {

				return "login/deleteresult";
				
			} else {// 비번이 같은 경우
				
				String up = session.getServletContext().getRealPath("upload");
				String fname = seller.getSel_pic();
				System.out.println("up:"+up);
				
				// 디비에 저장된 기존 이진파일명을 가져옴
				if (fname != null) {// 기존 이진파일이 존재하면
					File delFile = new File(up +"/"+fname);
					delFile.delete();// 기존 이진파일을 삭제
				}
				Seller dels = new Seller();
				dels.setSel_id(id);

				int deleteresult = boardservice.deletesel(dels);// 삭제 메서드 호출
				m.addAttribute("deleteresult", deleteresult);	
				session.invalidate();	// 세션만료

				return "login/okresult";
			}
		}
		/* 비번찾기 완료 */
		@RequestMapping("pwfind_ok1")
		public String pwd_find_ok1(@ModelAttribute Member mem,HttpServletResponse response, Model model)
				throws Exception {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			Member member = boardservice.findpw(mem);
			
			if (member == null) {// 값이 없는 경우

				return "login/pwresult";

			} else {

				// Mail Server 설정
				String charSet = "utf-8";
				String hostSMTP = "smtp.naver.com";
				String hostSMTPid = "chyw2021@naver.com";
				String hostSMTPpwd = "dydvkfdl123="; // 비밀번호 입력해야함

				// 보내는 사람 EMail, 제목, 내용
				String fromEmail = "chyw2021@naver.com";
				String fromName = "관리자";
				String subject = "비밀번호 찾기";

				// 받는 사람 E-Mail 주소
				String mail = member.getMem_mail()+"@"+member.getMem_do();
				

				try {
					HtmlEmail email = new HtmlEmail();
					email.setDebug(true);
					email.setCharset(charSet);
					email.setSSL(true);
					email.setHostName(hostSMTP);
					email.setSmtpPort(587);

					email.setAuthentication(hostSMTPid, hostSMTPpwd);
					email.setTLS(true);
					email.addTo(mail, charSet);
					email.setFrom(fromEmail, fromName, charSet);
					email.setSubject(subject);
					email.setHtmlMsg("<p align = 'center'>비밀번호 찾기</p><br>" + "<div align='center'> 비밀번호 : "
							+ member.getMem_pw() + "</div>");
					email.send();
				} catch (Exception e) {
					System.out.println(e);
				}

				model.addAttribute("pwdok", "등록된 email을 확인 하세요~!!");
				return "login/pwfind1";

			}
			
			
			

		}
		
		
		@RequestMapping("pwfind_ok2")
		public String pwd_find_ok(@ModelAttribute Seller sel,HttpServletResponse response, Model model)
				throws Exception {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			Seller seller = boardservice.findpw1(sel);
			
			if (seller == null) {// 값이 없는 경우

				return "login/pwresult";

			} else {

				// Mail Server 설정
				String charSet = "utf-8";
				String hostSMTP = "smtp.naver.com";
				String hostSMTPid = "chyw2021@naver.com";
				String hostSMTPpwd = "dydvkfdl123="; // 비밀번호 입력해야함

				// 보내는 사람 EMail, 제목, 내용
				String fromEmail = "chyw2021@naver.com";
				String fromName = "관리자";
				String subject = "비밀번호 찾기";

				// 받는 사람 E-Mail 주소
				String mail = seller.getSel_mail()+"@"+seller.getSel_do();
				

				try {
					HtmlEmail email = new HtmlEmail();
					email.setDebug(true);
					email.setCharset(charSet);
					email.setSSL(true);
					email.setHostName(hostSMTP);
					email.setSmtpPort(587);

					email.setAuthentication(hostSMTPid, hostSMTPpwd);
					email.setTLS(true);
					email.addTo(mail, charSet);
					email.setFrom(fromEmail, fromName, charSet);
					email.setSubject(subject);
					email.setHtmlMsg("<p align = 'center'>비밀번호 찾기</p><br>" + "<div align='center'> 비밀번호 : "
							+ seller.getSel_pw() + "</div>");
					email.send();
				} catch (Exception e) {
					System.out.println(e);
				}

				model.addAttribute("pwdok", "등록된 email을 확인 하세요~!!");
				return "login/pwfind2";

			}
			
			
			

		}
		
		/* 아이디 완료 */
		@RequestMapping("idfind_ok1")
		public String id_find_ok1(@ModelAttribute Member mem,HttpServletResponse response, Model model)
				throws Exception {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("idfind_ok");
			Member member = boardservice.findid1(mem);
			
			if (member == null) {// 값이 없는 경우

				return "login/idresult";

			} else {

				model.addAttribute("iddok", member.getMem_id());
				return "login/idfind1";

			}

		}
		
		@RequestMapping("idfind_ok2")
		public String id_find_ok2(@ModelAttribute Seller sel,HttpServletResponse response, Model model)
				throws Exception {
			response.setContentType("text/html;charset=UTF-8");
			System.out.println("idfind_ok");
			Seller seller = boardservice.findid2(sel);
			
			if (seller == null) {// 값이 없는 경우

				return "login/idresult";

			} else {
				
				String id = seller.getSel_id();
				model.addAttribute("iddok", id);
				return "login/idfind2";

			}

		}
		
	

	
}
