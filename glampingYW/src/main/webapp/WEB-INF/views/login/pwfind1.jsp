<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비번찾기</title>
<script>
 function check6(){
	 if($.trim($("#mem_id").val())==""){
		 alert("아이디를 입력하세요!");
		 $("#mem_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_mail").val())==""){
		 alert("회원메일을 입력하세요!");
		 $("#mem_mail").val("").focus();
		 return false;
	 }
 }
</script>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<section class="col-8 container-fluid">
	<c:if test="${empty pwdok}">
	<div class="login3" border="1" align="center">
 
		<form method="post" action="pwfind_ok1"
  		onsubmit="return check6()">
			<h5 align="center">일반회원 비밀번호 찾기</h5>
			<table align="center">
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" id="mem_id" name="mem_id"></td>
				</tr>
				 <tr>
               <td id="title">이메일</td>
               <td>
                   <input type="text" id="mem_mail" name="mem_mail" maxlength="15">@
                   <select id="mem_do" name="mem_do">
                       <option>naver.com</option>
                       <option>daum.net</option>
                       <option>gmail.com</option>
                       <option>nate.com</option>                        
                   </select>
               </td>
           </tr>
				</table>
				<input type="submit" id="pwfind" value="비밀번호 찾기" />
		</form>
			
		</div>
		</c:if>
		
		
		<c:if test="${!empty pwdok}">
    <h2 class="pwd_title2">비번찾기 결과</h2>
    <table id="pwd_t2">
     <tr>
      <th>검색한 비번:</th>
      <td>${pwdok}</td>
     </tr>
    </table>
    <div id="pwd_close2">
    <!-- close()메서드로 공지창을 닫는다. self.close()는 자바스크립트이다. -->
    </div>
  </c:if> 
</section>
</html>
<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>

