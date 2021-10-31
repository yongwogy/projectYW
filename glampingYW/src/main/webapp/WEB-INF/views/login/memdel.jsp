<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<section class="col-8 container-fluid" >
	<div class="login4" border="1" align="center">
		<form action="#">
			<h5 align="center">회원 탈퇴</h5>
			<table align="center">
				<tr>
					<td id="title1">비밀번호</td>
					<td><input type="password" name="mem_pw" id="mem_pw"></td>
				</tr>
				</table>
				<input type="submit" id="memdel" value="회원탈퇴" />
		</form>
			
		</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>

