<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/yw.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=05274b64af0d95b6ced6532db8a1d75c&libraries=services"></script>


<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<script type="text/javascript">
function apppro(pro_no) {
	if(!confirm('상품을 승인하시겠습니까?')){
		return false;
	} else {
		location.href = "appproduct?pro_no="+pro_no;
	}
}

function banpro(pro_no) {
	if(!confirm('상품을 반려하시겠습니까?')){
		return false;
	} else {
		location.href = "banproduct?pro_no="+pro_no;
	}
}
</script>

<section class="col-8 container-fluid">

	<div class="container">
				
		<div class="row">
			<div id="info" class="col-sm-8 col-md-12">
				<div id="cont_sec">
				
					
				
					<h3>승인대기 상품</h3>
					<div class="row row-cols-1 row-cols-md-5 g-2">
					
						<c:forEach var="pro" items="${prolist}">
							<c:if test="${pro.pro_s eq 0 }">
							<div class="col">
								<div class="card">
									<a class="a_best" href="${pageContext.request.contextPath }/proView/pro_no/${pro.pro_no}">
										<img src="${pageContext.request.contextPath}/upload/${pro.pro_pic}" class="card-img-top" title="룸 클릭" width="200" height="150">
									</a>
									 <div class="card-body">
									  	<p class="card-text" style="font-weight: bold;">판매자: ${pro.sel_id}</p>
									  	<p class="card-text" style="font-weight: bold;">${pro.pro_name}</p>
									</div>
									<div align="center">
									<input type="button" value="상품승인" class="bt-deco" onclick="apppro('${pro.pro_no}')"/>
									<input type="button" value="상품반려" class="bt-deco" onclick="banpro('${pro.pro_no}')"/>
									</div>
								</div>

							</div>
							</c:if>
						</c:forEach>
					</div>
					
					<hr>
					
					<h3>운영중 상품</h3>
					<div class="row row-cols-1 row-cols-md-5 g-2">
					
						<c:forEach var="pro" items="${prolist}">
							<c:if test="${pro.pro_s eq 1 }">
							<div class="col">
								<div class="card">
									<a class="a_best" href="${pageContext.request.contextPath }/proView/pro_no/${pro.pro_no}">
										<img src="${pageContext.request.contextPath}/upload/${pro.pro_pic}" class="card-img-top" title="룸 클릭" width="200" height="150">
									</a>
									 <div class="card-body">
									  	<p class="card-text" style="font-weight: bold;">판매자: ${pro.sel_id}</p>
									  	<p class="card-text" style="font-weight: bold;">${pro.pro_name}</p>
									</div>
									<div align="center">
									<input type="button" value="상품반려" class="bt-deco" onclick="banpro('${pro.pro_no}')"/>
									</div>
								</div>

							</div>
							</c:if>
						</c:forEach>
					</div>
					
					
				</div>
			</div>

		</div>
	</div>
</section>



<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>