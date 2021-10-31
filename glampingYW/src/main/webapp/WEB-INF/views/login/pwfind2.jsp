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
 function check5(){
	 if($.trim($("#sel_id").val())==""){
		 alert("사업자아이디를 입력하세요!");
		 $("#sel_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_mail").val())==""){
		 alert("사업자회원메일을 입력하세요!");
		 $("#sel_mail").val("").focus();
		 return false;
	 }
 }
</script>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<section class="col-8 container-fluid">
<c:if test="${empty pwdok}"> 
	<div class="login3" border="1" align="center">
	
		<form method="post" action="pwfind_ok2"
  		onsubmit="return check5()">
			<h5 align="center">판매자회원 비밀번호 찾기</h5>
			<table align="center">
				<tr>
					<td id="title">사업자아이디</td>
					<td><input type="text" id="sel_id" name="sel_id"></td>
				</tr>
				 <tr>
               <td id="title">이메일</td>
               <td>
                   <input type="text" id="sel_mail" name="sel_mail" maxlength="15">@
                   <select id="sel_do" name="sel_do">
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

