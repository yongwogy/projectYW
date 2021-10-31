<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header 파일 불러오기 -->
<%@ include file="/WEB-INF/views/header.jsp" %>

<!-- 카카오API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                document.getElementById('pro_post').value = data.zonecode;
                document.getElementById("pro_addr").value = data.address;
            }
        }).open();
    }
</script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=05274b64af0d95b6ced6532db8a1d75c&libraries=services"></script>






<!-- 외부스크립트 불러오기 -->	
<script src="./js/productinsert.js"></script>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/yw.css">

<section class="col-8 container-fluid ">
<div class="insert_ss" border="1" align="center">
	<form method="post" action="<%=request.getContextPath() %>/proupdate" enctype="multipart/form-data">
	<input type="hidden" id="pro_no" name="pro_no" value="${pro.pro_no }">
	<table class="yw_table">
	<br>
	<tbody>
	<h2>${sessionScope.id}님의 상품수정 페이지</h2>
		
		<tr>
			<td>대표자명:</td>
			<td><input id="pro_ceo" name="pro_ceo" size="10" value="${pro.pro_ceo }"></td>
		</tr>
		<tr>
			<td>상품명:</td>
			<td><input id="pro_name" name="pro_name" size="50" value="${pro.pro_name }"></td>
		</tr>
		<tr>
			<td>사업장 주소:</td>
			<td><input id="pro_post" name="pro_post" size="10" value="${pro.pro_post }" readonly><input type="button" id="spost" class="bt-deco" value="우편검색" onclick="execDaumPostcode()"></td>
		</tr>
		<tr>
			<td></td>
			<td><input id="pro_addr" name="pro_addr" size="50" value="${pro.pro_addr }" readonly></td>
		</tr>
					
		<tr>
			<td>좌표:</td>
			<td><input id="pro_x" name="pro_x" size="20" readonly>-<input id="pro_y" name="pro_y" size="20" readonly><input type="button" id="myad" class="bt-deco" value="좌표입력"/></td>
		</tr>	
						
		<tr>
			<td>사업자 번호:</td>
			<td><input id="pro_n1" name="pro_n1" size="10" value="${pro.pro_n1 }">-<input id="pro_n2" name="pro_n2" size="10" value="${pro.pro_n2 }"></td>
		</tr>
		<tr>
			<td>편의 시설:</td>
			<td>
				<input type="checkbox" id="con1" name="pro_con" value="와이파이"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='와이파이'}">${'checked'}</c:if></c:forEach> >와이파이
				<input type="checkbox" id="con2" name="pro_con" value="주차시설"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='주차시설'}">${'checked'}</c:if></c:forEach> >주차시설		
				<input type="checkbox" id="con3" name="pro_con" value="금연시설"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='금연시설'}">${'checked'}</c:if></c:forEach> >금연시설
				<input type="checkbox" id="con4" name="pro_con" value="야외풀장"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='야외풀장'}">${'checked'}</c:if></c:forEach> >야외풀장
				<input type="checkbox" id="con5" name="pro_con" value="바베큐장"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='바베큐장'}">${'checked'}</c:if></c:forEach> >바베큐장
				<input type="checkbox" id="con6" name="pro_con" value="캠프파이어"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='캠프파이어'}">${'checked'}</c:if></c:forEach> >캠프파이어
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td>
				<input type="checkbox" id="con7" name="pro_con" value="전용욕실"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='전용욕실'}">${'checked'}</c:if></c:forEach> >전용욕실
				<input type="checkbox" id="con8" name="pro_con" value="세탁시설"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='세탁시설'}">${'checked'}</c:if></c:forEach> >세탁시설
				<input type="checkbox" id="con9" name="pro_con" value="주방시설"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='주방시설'}">${'checked'}</c:if></c:forEach> >주방시설
				<input type="checkbox" id="con10" name="pro_con" value="세면용품"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='세면용품'}">${'checked'}</c:if></c:forEach> >세면용품
				<input type="checkbox" id="con11" name="pro_con" value="스포츠가능"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='스포츠가능'}">${'checked'}</c:if></c:forEach> >스포츠가능
				<input type="checkbox" id="con12" name="pro_con" value="애견동반"
					<c:forEach var="c" items="${con}">
					<c:if test="${c=='애견동반'}">${'checked'}</c:if></c:forEach> >애견동반
			</td>
		</tr>
	
	    <tr>
     		<td>업체 대표사진</td>
     		<td><input type="file" id="pro_pic1" name="pro_pic1"></td>
   		</tr>
   		
		<tr>
			<td>업체사진</td>
			<td><input type="button" value="사진추가" id="add_pp_name" class="bt-deco"/></td>
		</tr>

  		<tr>
  			<td></td>
  			<td><input type="file" id="pp_name1" name="pp_name1" /></td>
  		</tr>

        <tr id="tr_pp_name"></tr>
  		

  		
	    <tr>
     		<td>소개글:</td>
     		<td><textarea id="pro_intro" name="pro_intro" rows="8" cols="100"}">${pro.pro_intro }</textarea></td>
   		</tr>
 		
 		<tr>
 			<td colspan="2"><hr></td>
 		</tr>
 		
		<tr>
			<td colspan=2 align=center>
				<input type=submit value="수정신청" class="bt-deco"><input type=reset value="취소" class="bt-deco">
			</td>	
		</tr>
		
		</tbody>
				
			
		</table>	
		
	</form>
</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="/WEB-INF/views/footer.jsp" %>

