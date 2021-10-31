<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header 파일 불러오기 -->
<%@ include file="/WEB-INF/views/header.jsp" %>



<!-- 외부스크립트 불러오기 -->	
<script src="./js/roominsert.js"></script>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/yw.css">

<section class="col-8 container-fluid ">
<div class="insert_ss" border="1" align="center">
	<form method="post" action="<%=request.getContextPath() %>/rminsert" enctype="multipart/form-data">
	<input type="hidden" id="pro_no" name="pro_no" value="${pro_no }">
	<table class="yw_table">
	<br>
	<tbody>
	<h2>${sessionScope.id}님의 객실등록 페이지</h2>
		
<%-- 		<tr>
   			<td><h4>객실정보</h4></td>
   			<c:if test="${rt == null }">
			<td>1번 객실<input type="hidden" name="rm_type" value=1></td>
			</c:if>
   			<c:if test="${rt >= 1 }">
			<td>${rt }번 객실<input type="hidden" name="rm_type" value="${rt }"></td>
			</c:if>
 		</tr> --%>

		<tr>
			<td>객실명:</td>
			<td><input id="rm_tname" name="rm_tname" size="50"></td>
		</tr>
		
		<tr>
			<td>인원수(객실당):</td>
			<td><input id="rm_pno" name="rm_pno" size="2">명</td>
		</tr>
		
   		<tr>
			<td>인원수(추가):</td>
			<td><input id="rm_rno" name="rm_rno" size="2">명</td>
		</tr>
		
   		<tr>
			<td>가격(1박):</td>
			<td><input id="rm_price" name="rm_price" size="10">원</td>
		</tr>
		
	    <tr>
     		<td>객실대표사진</td>
     		<td><input type="file" id="rm_pic1" name="rm_pic1" /></td>
   		</tr>
   		
   		<tr>
			<td>객실사진</td>
			<td><input type="button" value="사진추가" id="add_rp_name" class="bt-deco"/></td>
		</tr>
   		
   		<tr>
  			<td></td>
  			<td><input type="file" id="rp_name1" name="rp_name1" /></td>
  		</tr>		
   		
   		<tr id="tr_rp_name"></tr>
   		
 		<tr>
 			<td colspan="2"><hr></td>
 		</tr>
 		
 		</tbody>
 		
 


		
		
		<tbody>
		<tr>
			<td colspan=2 align=center>
				<input type=submit id="add_room" value="객실등록" class="bt-deco"><input type=reset value="취소" class="bt-deco">
				<a href="selprolist">
				<input type="button" value="목록으로" class="bt-deco">
				</a>
			</td>	
		</tr>
		</tbody>
			
		</table>	
		
	</form>
</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="/WEB-INF/views/footer.jsp" %>

