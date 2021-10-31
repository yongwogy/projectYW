<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header 파일 불러오기 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	$(function(){
	
		$("#loginok1").show();
		$("#loginok2").hide();

		$("#mem").click(function(){
			$("#loginok1").show();
			$("#loginok2").hide();
		});
		$("#sel").click(function(){
			$("#loginok1").hide();
			$("#loginok2").show();
		});
		
	});	

</script>
 <script type="text/javascript">
 function check1(){
	 		
	 if($.trim($("#mem_id").val())==""){
		 alert("회원아이디를 입력");
		 $("#mem_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_pw").val())==""){
		 alert("비번을 입력하세요!");
		 $("#mem_pw").val("").focus();
		 return false;
	 }

		
}	
 function check2(){
		
	 if($.trim($("#sel_id").val())==""){
		 alert("사업자아이디를 입력");
		 $("#sel_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_pw").val())==""){
		 alert("사업자비번을 입력하세요!");
		 $("#sel_pw").val("").focus();
		 return false;
	 }

}
 </script>
 <script>
        window.Kakao.init('8948944daf5aa0d2cb153b5336231c30');

        function kakaoLogin() {
            window.Kakao.Auth.login({
                scope: 'profile, account_email', //동의항목 페이지에 있는 개인정보 보호 테이블의 활성화된 ID값을 넣습니다.
                success: function(response) {
                    console.log(response) // 로그인 성공하면 받아오는 데이터
                    window.Kakao.API.request({ // 사용자 정보 가져오기 
                        url: '/v2/user/me',
                        success: (res) => {
                            const kakao_account = res.kakao_account;
                            console.log(kakao_account)
                            var id = res.id;
                            var email = res.kakao_account.email;
                            location.href='login_ok2?id='+id;
                        }
                    });
                },
                fail: function(error) {
                    console.log(error);
                }
            });
        }
    </script>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">

</head>
<body>
<%@ include file="../header.jsp"%>

<section class="col-8 container-fluid" >
 
	<div class="login1" border="1" align="center">
			<div align="center">
				<label><input type="radio" name="mem" id="mem" value="mem" checked>일반회원</label> &emsp;
				<label><input type="radio" name="mem"  id="sel" value="sel" >사업자회원</label>
			</div>
			
		<div id="loginok1">
			<form method="post" action="login_ok" onsubmit="return check1()">
			
				<table align="center">
					<tr>
						<td>아이디</td>
						<td><input type="text" id="mem_id" name="mem_id" ></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="mem_pw" id="mem_pw"></td>
					</tr>

				</table>
		
			<div align="center">
				<input type="submit" class="login" value="로그인" /><br>
				<input type="button" class="inf" value="회원가입" 
				 	onclick="location.href='join'"/>
				<input type="button" class="inf" value="아이디찾기"  
					onclick="location.href='idfind'"/>
				<input type="button" class="inf" value="비밀번호찾기"
					onclick="location.href='pwfind'" />
				</div>
		
		</form>
			</div>
			
			<div id="loginok2">
			<form method="post" action="login_ok1" onsubmit="return check2()">
			
				<table align="center">
					<tr>
						<td>사업자아이디</td>
						<td><input type="text" id="sel_id" name="sel_id"></td>
					</tr>
					<tr>
						<td>사업자비밀번호</td>
						<td><input type="password" name="sel_pw" id="sel_pw"></td>
					</tr>

				</table>
		
			<div align="center">
				<input type="submit" class="login" value="로그인" /><br>
				<input type="button" class="inf" value="회원가입" 
				 	onclick="location.href='join'"/>
				<input type="button" class="inf" value="아이디찾기"  
					onclick="location.href='idfind'"/>
				<input type="button" class="inf" value="비밀번호찾기"
					onclick="location.href='pwfind'" />
				</div>
		
		</form>
		</div>
			<div align="center">다른계정 간편 로그인</div>
			<div align="center">
				<a href="javascript:kakaoLogin();"><img class="ilogo" src="${pageContext.request.contextPath}/images/kakao.png" /></a>
				<a href="#"><img class="ilogo" src="${pageContext.request.contextPath}/images/naver.png"></a>
				<a href="#"><img class="ilogo" src="${pageContext.request.contextPath}/images/facebook.png"></a>
				<a href="#"><img class="ilogo" src="${pageContext.request.contextPath}/images/Google.png"></a>
			</div>
		</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>
</body>
