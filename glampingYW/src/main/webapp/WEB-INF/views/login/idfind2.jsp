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
 function check8(){
	 if($.trim($("#sel_name").val())==""){
		 alert("이름를 입력하세요!");
		 $("#sel_name").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_p2").val())==""){
		 alert("휴대폰을 입력하세요!");
		 $("#sel_p2").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_p3").val())==""){
		 alert("휴대폰을 입력하세요!");
		 $("#sel_p3").val("").focus();
		 return false;
	 }
 }
</script>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<section class="col-8 container-fluid" >
<c:if test="${empty iddok}">
	<div class="login3" border="1" align="center">
	
		<form action="idfind_ok2" method="post" onsubmit="return check8()">
			<h5 align="center">판매자회원 아이디 찾기</h5>
			<table align="center">
				<tr>
					<td id="title">이름</td>
					<td><input type="text" name="sel_name" id="sel_name"></td>
				</tr>
				 <tr>
               <td id="title">휴대폰</td>
               <td>
                   <select name="sel_p1">
                       <option value="010">010</option>
                       <option value="016">016</option>
                       <option value="017">017</option>
                       <option value="018">018</option>
                       <option value="011">011</option>                        
                  </select>-
                   <input type="text" name="sel_p2" id="sel_p2"/>-
                   <input type="text" name="sel_p3" id="sel_p3"/>
               </td>
           </tr>
				</table>
				<input type="submit" id="idfind" value="아이디 찾기" />
		</form>
		

		</div>
		</c:if>
		
		<c:if test="${!empty iddok}">
    <h2 class="pwd_title2">아이디찾기 결과</h2>
    <table id="pwd_t2">
     <tr>
      <th>검색한 아이디:</th>
      <td>${iddok}</td>
     </tr>
    </table>
    
  </c:if> 
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>

