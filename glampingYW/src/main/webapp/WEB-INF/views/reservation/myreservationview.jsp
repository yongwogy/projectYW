<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<!-- 외부스크립트 불러오기 -->	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/yw2.css">

<script type="text/javascript">
function delresrve(res_no) {
	if(!confirm('예약 취소를 신청합니다. 판매자가 승인해야 취소해야 합니다.')){
		return false;
	} else {
		location.href = "deletereservation?res_no="+res_no;
	}
}
</script>

<section class="col-8 container-fluid">
	
	<c:if test="${empty reslist}">
		<br>
		<div class="backwhite" border="1" align="center">
			<div class="no_res">
				현재 예약이 없습니다.
			</div>
		</div>
	</c:if>
	
	
	
	<c:forEach var="res" items="${reslist}">
		
		<!-- 진행중 예약 -->
		<c:if test="${res.res_s == 1 }">
		<br>
		<div class="backwhite" border="1" align="center">		
			<div class="row row-cols-1 row-cols-md-4 g-2" id="pic">
			
				<c:forEach var="rm" items="${rmlist }">
					<c:if test="${res.res_no == rm.res_no && res.rm_no == rm.rm_no}">
						<div class="col">
							<div class="card" id="round">
								<img src="${pageContext.request.contextPath}/upload/${rm.rm_pic}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
							</div>
						</div>
					</c:if>
					<c:if test="${res.res_no == rm.res_no && res.rm_no != rm.rm_no}">
						<div class="col">
							<div class="card" id="round_none">
								<p>기존에 예약하셧던 객실이 삭제되었습니다<p>
								<p>판매자에게 문의하세요<p>
							</div>
						</div>
					</c:if>		
				</c:forEach>
								
				<c:forEach var="rp" items="${rplistall}">
					<c:if test="${res.res_no == rp.res_no }">
						<div class="col">						
							<div class="card" id="round">
								<img src="${pageContext.request.contextPath}/upload/${rp.rp_name}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
							</div>
						</div>
					</c:if>
				</c:forEach>		

			</div>
			
			<hr>
			
	
			<div class="backwhite2" align="left">
							
				<form method="post" action="<%=request.getContextPath() %>/reviewform" enctype="multipart/form-data">
					<div id="le"><span id="res_t">${sessionScope.id}님의 예약정보</span></div>
					<div id="le">
						<c:forEach var="pro" items="${prolist }">
							<c:if test="${res.res_no == pro.res_no }">
							<a href="${pageContext.request.contextPath }/proView/pro_no/${pro.pro_no}"><span id="font_w">${pro.pro_name}:</span></a>
							<span>&nbsp&nbsp${pro.pro_addr}</span>
							</c:if>
						</c:forEach>
						<c:forEach var="sel" items="${sellist }">
							<c:if test="${res.res_no == sel.res_no }">
							<span id="ckr">&nbsp&nbsp연락처:&nbsp${sel.sel_p1}-${sel.sel_p2}-${sel.sel_p3}</span>
							</c:if>
						</c:forEach>
						
	
					</div>
					<br>
					<div id="le">
						<span>객실명:</span> 
						<span>${res.res_tname}</span>
						<span id="ckg">(${res.res_pno}명)</span>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<span id="ckb">체크인:</span>
						<span id="ckb"><fmt:formatDate value = "${res.res_ckin}" pattern = "yyyy-MM-dd" var = "ckin"/>${ckin}</span>
						<span>/</span>
						<span id="ckr">체크아웃:</span>
						<span id="ckr"><fmt:formatDate value = "${res.res_ckout}" pattern = "yyyy-MM-dd" var = "ckout"/>${ckout}</span>
						<span id="ckg">(${res.daygap}박)</span>
					</div>
					<br>	
					<div id="le">
						<span>예약자 이름:&nbsp</span>
						<span>${res.res_name}</span>						
						&nbsp&nbsp
						<span>예약자 연락처:&nbsp</span>
						<span>${res.res_p1}-${res.res_p2}-${res.res_p3}</span>
						<span id="ri">￦&nbsp<fmt:formatNumber value="${res.res_price}" pattern="#,###"/>원</span>
					</div>
					<br>
					<div align="center">
					<input type="hidden" name="res_no" value="${res.res_no}">
					<c:forEach var="pro" items="${prolist }">
						<c:if test="${res.res_no == pro.res_no }">
							<a href="${pageContext.request.contextPath }/proView/pro_no/${pro.pro_no}">
							<input type="button" value="후기작성" class="bt-deco">
							</a>
						</c:if>
					</c:forEach>		
					<input type=button value="예약취소신청" class="bt-deco1" onclick="delresrve('${res.res_no}')">
					</div>				
				</form>					
			</div>
		</div>	
		</c:if>
		
		<!-- 취소진행중 예약 -->
		<c:if test="${res.res_s == 2 }">
		<br>
		<div class="backwhite_borred" border="1" align="center">	
			<div class="row row-cols-1 row-cols-md-4 g-2" id="pic">
			
				<c:forEach var="rm" items="${rmlist }">
					<c:if test="${res.res_no == rm.res_no && res.rm_no == rm.rm_no}">
						<div class="col">
							<div class="card" id="round_fur">
								<img src="${pageContext.request.contextPath}/upload/${rm.rm_pic}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
							</div>
						</div>
					</c:if>
					<c:if test="${res.res_no == rm.res_no && res.rm_no != rm.rm_no}">
						<div class="col">
							<div class="card" id="round_none">
								<p>기존에 예약하셧던 객실이 삭제되었습니다<p>
								<p>판매자에게 문의하세요<p>
							</div>
						</div>
					</c:if>		
				</c:forEach>
								
				<c:forEach var="rp" items="${rplistall}">
					<c:if test="${res.res_no == rp.res_no }">
						<div class="col">						
							<div class="card" id="round_fur">
								<img src="${pageContext.request.contextPath}/upload/${rp.rp_name}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
							</div>
						</div>
					</c:if>
				</c:forEach>		

			</div>
			
			<hr>
			
	
			<div class="backwhite2" align="left">
							
				<form method="post" action="<%=request.getContextPath() %>/reviewform" enctype="multipart/form-data">
					<div id="le"><span id="res_t">${sessionScope.id}님의 예약정보</span>&nbsp&nbsp<span id="res_tred">(취소신청 함)</span></div>
					<div id="le">
						<c:forEach var="pro" items="${prolist }">
							<c:if test="${res.res_no == pro.res_no }">
							<a href="${pageContext.request.contextPath }/proView/pro_no/${pro.pro_no}"><span id="font_w">${pro.pro_name}:</span></a>
							<span>&nbsp&nbsp${pro.pro_addr}</span>
							</c:if>
						</c:forEach>
						<c:forEach var="sel" items="${sellist }">
							<c:if test="${res.res_no == sel.res_no }">
							<span id="ckr">&nbsp&nbsp연락처:&nbsp${sel.sel_p1}-${sel.sel_p2}-${sel.sel_p3}</span>
							</c:if>
						</c:forEach>
						
	
					</div>
					<br>
					<div id="le">
						<span>객실명:</span> 
						<span>${res.res_tname}</span>
						<span id="ckg">(${res.res_pno}명)</span>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<span id="ckb">체크인:</span>
						<span id="ckb"><fmt:formatDate value = "${res.res_ckin}" pattern = "yyyy-MM-dd" var = "ckin"/>${ckin}</span>
						<span>/</span>
						<span id="ckr">체크아웃:</span>
						<span id="ckr"><fmt:formatDate value = "${res.res_ckout}" pattern = "yyyy-MM-dd" var = "ckout"/>${ckout}</span>
						<span id="ckg">(${res.daygap}박)</span>
					</div>
					<br>	
					<div id="le">
						<span>예약자 이름:&nbsp</span>
						<span>${res.res_name}</span>						
						&nbsp&nbsp
						<span>예약자 연락처:&nbsp</span>
						<span>${res.res_p1}-${res.res_p2}-${res.res_p3}</span>
						<span id="ri">￦&nbsp<fmt:formatNumber value="${res.res_price}" pattern="#,###"/>원</span>
					</div>
					<br>
				
				</form>					
			</div>
		</div>	
		</c:if>
		
	</c:forEach>
	
	
	<hr>
	
	<!-- 지난 에약항목 -->
	<c:forEach var="res" items="${reslist}">
		<c:if test="${res.res_s eq 0 }">
		<br>
		<div class="backwhite" border="1" align="center">
	
			<div class="row row-cols-1 row-cols-md-4 g-2" id="pic">
			
				<c:forEach var="rm" items="${rmlist }">
					<c:if test="${res.res_no == rm.res_no && res.rm_no == rm.rm_no}">
						<div class="col">
							<div class="card" id="round_imblack">
								<img src="${pageContext.request.contextPath}/upload/${rm.rm_pic}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
							</div>
						</div>
					</c:if>
					<c:if test="${res.res_no == rm.res_no && res.rm_no != rm.rm_no}">
						<div class="col">
							<div class="card" id="round_none">
								<p>기존에 예약하셧던 객실이 삭제되었습니다<p>
								<p>판매자에게 문의하세요<p>
							</div>
						</div>
					</c:if>		
				</c:forEach>
								
				<c:forEach var="rp" items="${rplistall}">
					<c:if test="${res.res_no == rp.res_no }">
						<div class="col">									
							<div class="card" id="round_imblack">
								<img src="${pageContext.request.contextPath}/upload/${rp.rp_name}" id="round" class="card-img-top" title="룸 클릭" width="200" height="180">
							</div>
						</div>
					</c:if>
				</c:forEach>		

			</div>
			
			<hr>
			
	
			<div class="backwhite2" align="left">
							
				<form method="post" action="<%=request.getContextPath() %>/reviewform" enctype="multipart/form-data">
					<div id="le"><span id="res_t">${sessionScope.id}님의 지난 예약정보</span></div>
					<div id="le">
						<c:forEach var="pro" items="${prolist }">
							<c:if test="${res.res_no == pro.res_no }">
							<span id="font_w">${pro.pro_name}:</span>
							<span>&nbsp&nbsp${pro.pro_addr}</span>
							</c:if>
						</c:forEach>
						<c:forEach var="sel" items="${sellist }">
							<c:if test="${res.res_no == sel.res_no }">
							<span id="ckr">&nbsp&nbsp연락처:&nbsp${sel.sel_p1}-${sel.sel_p2}-${sel.sel_p3}</span>
							</c:if>
						</c:forEach>
						
	
					</div>
					<br>
					<div id="le">
						<span>객실명:</span> 
						<span>${res.res_tname}</span>
						<span id="ckg">(${res.res_pno}명)</span>
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
						<span id="ckb">체크인:</span>
						<span id="ckb"><fmt:formatDate value = "${res.res_ckin}" pattern = "yyyy-MM-dd" var = "ckin"/>${ckin}</span>
						<span>/</span>
						<span id="ckr">체크아웃:</span>
						<span id="ckr"><fmt:formatDate value = "${res.res_ckout}" pattern = "yyyy-MM-dd" var = "ckout"/>${ckout}</span>
						<span id="ckg">(${res.daygap}박)</span>
					</div>
					<br>	
					<div id="le">
						<span>예약자 이름:&nbsp</span>
						<span>${res.res_name}</span>						
						&nbsp&nbsp
						<span>예약자 연락처:&nbsp</span>
						<span>${res.res_p1}-${res.res_p2}-${res.res_p3}</span>
						<span id="ri">￦&nbsp<fmt:formatNumber value="${res.res_price}" pattern="#,###"/>원</span>
					</div>
					<br>
					<div align="center">
					<input type="hidden" name="res_no" value="${res.res_no}">
					<c:forEach var="pro" items="${prolist }">
						<c:if test="${res.res_no == pro.res_no }">
							<a href="${pageContext.request.contextPath }/proView/pro_no/${pro.pro_no}">
							<input type="button" value="후기작성" class="bt-deco">
							</a>
						</c:if>
					</c:forEach>	
					</div>				
				</form>					
			</div>
		</div>	
		</c:if>
	</c:forEach>
	
</section>



<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>