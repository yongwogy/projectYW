<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<!-- 외부스크립트 불러오기 -->	
<script src="./js/reservein.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/yw2.css">

<section class="col-8 container-fluid">
	<br>
	<br>
	<br>
	<br>
	<div class="backwhite" border="1" align="center">

		<div class="row row-cols-1 row-cols-md-4 g-2" id="pic">
			<div class="col">
				<div class="card" id="round">
					<img src="${pageContext.request.contextPath}/upload/${rm.rm_pic}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
				</div>
			</div>
			<c:forEach var="rp" items="${rplist}">
			<div class="col">									
				<div class="card" id="round">
					<img src="${pageContext.request.contextPath}/upload/${rp.rp_name}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
				</div>
			</div>
			</c:forEach>
		</div>
		
		<hr>
		

		<div class="backwhite2" align="left">
						
			<form method="post" action="<%=request.getContextPath() %>/reservedo" enctype="multipart/form-data">
				<div id="le"><span id="res_t">예약정보</span></div>
				<div id="le">
					<span id="font_w">${pro.pro_name}:</span>
					<span>&nbsp&nbsp${pro.pro_addr}</span>
					<span id="ckr">&nbsp&nbsp연락처:&nbsp${sel.sel_p1}-${sel.sel_p2}-${sel.sel_p3}</span>


				</div>
				<br>
				<div id="le">
					<span>객실명:</span> 
					<span>${res_tname}</span>
					<span id="ckg">(${res_pno}명)</span>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<span id="ckb">체크인:</span>
					<span id="ckb">${checkInS}</span>
					<span>/</span>
					<span id="ckr">체크아웃:</span>
					<span id="ckr">${checkOutS}</span>
					<span id="ckg">(${sel_count2}박)</span>
				</div>
				<br>	
				<div id="le">
					<span>예약자 이름:</span>
					<input type="text" id="res_name" name="res_name" size="8">
					&nbsp&nbsp
					<span>예약자 연락처:</span>
						<select id="res_p1" name="res_p1">
	                       <option value="010">010</option>
	                       <option value="016">016</option>
	                       <option value="017">017</option>
	                       <option value="018">018</option>
	                       <option value="011">011</option>                        
                	 	</select>
					-<input type="text" id="res_p2" name="res_p2" size="4" maxlength="4">
					-<input type="text" id="res_p3" name="res_p3" size="4" maxlength="4">
					<span id="ri">￦&nbsp<fmt:formatNumber value="${res_price}" pattern="#,###"/>원</span>
				</div>
				<br>
				<div align="center">
				<input type="hidden" name="ckin" value="${checkInS}">
				<input type="hidden" name="ckout" value="${checkOutS}">
				<input type="hidden" name="mem_id" value="${sessionScope.id}">
				<input type="hidden" name="res_pno" value="${res_pno}">
				<input type="hidden" name="res_price" value="${res_price}">
				<input type="hidden" name="res_tname" value="${res_tname}">
				<input type="hidden" name="rm_no" value="${rm.rm_no}">
				<input type="hidden" name="pro_no" value="${pro.pro_no}">
				<input type=submit value="예약" class="bt-deco">&nbsp<input type=reset value="취소" class="bt-deco1">
				</div>				
			</form>
				
			
		</div>


		
	</div>
	
</section>



<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>