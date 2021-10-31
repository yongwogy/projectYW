<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/member.js"></script>
<title>글램핑</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/primary.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/yw.css">
</head>
<body>
<script type="text/javascript">
function close1() {
	window.close();
}

</script>

<section class="col-12 container-fluid" style="min-height: 350px;">

	<div class="container">
	
		<div class="row">
			<div id="info" class="col-sm-8 col-md-9">
				<div id="carousel_pro" class="carousel slide" data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button"
							data-bs-target="#carousel_pro"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<c:set var="size" value="${fn:length(rplist)}"/>
						<c:forEach var="i" begin="1" end="${size}">
							<button type="button"
								data-bs-target="#carousel_pro"
								data-bs-slide-to="${i}" aria-label="Slide ${i+1}"></button>
						</c:forEach>	
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="${pageContext.request.contextPath }/upload/${rm.rm_pic }" class="d-block w-100" alt="..." width="350" height="250">
						</div>
						<c:forEach var="rp" items="${rplist}">
							<div class="carousel-item">
								<img src="${pageContext.request.contextPath }/upload/${rp.rp_name}" class="d-block w-100" alt="..." width="350" height="250">
							</div>
						</c:forEach>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carousel_pro" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carousel_pro" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>

		</div>
		<div>
			<ui>
				<li>객실명:&nbsp${rm.rm_tname}</li>
				<li>객실인원:&nbsp${rm.rm_pno}인실</li>
				<li>가격(1박):&nbsp￦<fmt:formatNumber value="${rm.rm_price}" pattern="#,###"/>원</li>
			</ui>
		</div>
		
		<hr>
		
		<div align=center>
				<input type="button" value="닫기" class="bt-deco" onclick="close1()"/>
		</div>	
		
	</div>
</section>
	
	
	
</body>
</html>