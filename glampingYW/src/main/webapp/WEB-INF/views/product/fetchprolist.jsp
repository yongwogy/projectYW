<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:forEach var="product" items="${list }">
		<div class="card">
				<div class="row g-0">
					<div class="col-4 col-sm-3">
						<c:if test="${checkInS != null and checkOutS != null}">
							<a href="${pageContext.request.contextPath }/proView/pro_no/${product.pro_no}/checkInS/${checkInS}/checkOutS/${checkOutS}">
								<img src="${pageContext.request.contextPath }/upload/${product.pro_pic}" height="200" width="280">
							</a>
						</c:if>
						<c:if test="${checkInS == null and checkOutS == null}">
							<a href="${pageContext.request.contextPath }/proView/pro_no/${product.pro_no}">
								<img src="${pageContext.request.contextPath }/upload/${product.pro_pic}" height="200" width="280">
							</a>
						</c:if>
					</div>
					<div class="col-8 col-sm-9 protext">
						<h4>${product.pro_name }</h4><br>
						<p>${product.pro_addr }</p>
						<div class="else_info row">
							<div class="col-9">
								<c:if test="${product.rv_total != 0 }">
									<c:forEach var="i" begin="1" end="10">
										<c:if test="${product.star_avg == i}">
											<span class="avg_star">별점평균: <img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="..."></span>
										</c:if>
									</c:forEach>
									<span class="f14">(후기 ${product.rv_total})</span>
								</c:if>
								<c:if test="${product.rv_total == 0 }">
									<span class="f14">아직 후기가 없습니다</span>
								</c:if>
							</div>
							<div class="col-3">
								<p>최저 <span class="f18"><fmt:formatNumber value="${product.rev_cnt}" pattern="#,###"/>원</span></p> 
							</div>
						</div>
					</div>
				</div>
			</div>
	</c:forEach>
</body>
</html>