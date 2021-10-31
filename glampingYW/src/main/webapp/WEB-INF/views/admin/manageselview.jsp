<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header 파일 불러오기 -->
<%@ include file="/WEB-INF/views/header.jsp" %>


<!-- 외부스크립트 불러오기 -->	
<script src="${pageContext.request.contextPath }/js/ad.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/adpages.css">

<section class="col-8 container-fluid ">
	<div class="wids">
		<span>사업자회원</span><span>: ${listcount }명</span>
		
	</div>
	
	<div class="wids">
		
		
		<table class="table table-striped">
	
			<tr class="colum_title">
				<td>번호</td>
				<td>프로필</td>
				<td>아이디</td>
				<td>연락처</td>
				<td>등록신청일</td>
				<td>가입일</td>
				<td>승인여부</td>
				<td>승인 및 탈퇴</td>
			</tr>
			
			<c:set var="num" value="${listcount - (page-1) *20 }" />
			<c:forEach var="sel" items="${sellist}">
			<tr>
				<td>${num} <c:set var="num" value="${num-1 }" /></td>
				<td>
					<c:if test="${sel.sel_pic == null}">
						<img src="${pageContext.request.contextPath }/images/profilex.PNG" alt="..." style="width: 40px; height: 40px; border-radius: 20px;">
					</c:if>									
					<c:if test="${sel.sel_pic != null}">
						<img src="${pageContext.request.contextPath }/upload/${sel.sel_pic }" alt="..." style="width: 40px; height: 40px; border-radius: 20px;">
					</c:if>
				</td>
				<td>${sel.sel_id}</td>
				<td>${sel.sel_p1}-${sel.sel_p2}-${sel.sel_p3}</td>
				<td><fmt:formatDate value="${sel.sel_app}" pattern="yyyy-MM-dd" /></td>
				<td>
					<c:if test="${sel.sel_joind != null }">
						<fmt:formatDate value="${sel.sel_joind}" pattern="yyyy-MM-dd" />
					</c:if>
					<c:if test="${sel.sel_joind == null }">
						<div>없음</div>
					</c:if>
				</td>
				<td>
					<c:if test="${sel.sel_s eq 0 }">미승인됨</c:if>
					<c:if test="${sel.sel_s eq 1 }">승인됨</c:if>
					<c:if test="${sel.sel_s eq 2 }">탈퇴됨</c:if>
				</td>
				<td>
<%-- 					<c:if test="${sel.sel_s eq 0 }"><a href="approveseller?sel_id=${sel.sel_id}"><input type="button" class="adbt-deco" value="승인처리"/></a></c:if>
					<c:if test="${sel.sel_s eq 1 }"><a href="banseller?sel_id=${sel.sel_id}"><input type="button" class="adbt-deco1" value="탈퇴처리"/></a></c:if> --%>
					<input type="hidden" id="sel_id" value="${sel.sel_id}">
					<c:if test="${sel.sel_s eq 0 }"><input type="button" class="adbt-deco" value="승인처리" onclick="apps('${sel.sel_id}')"/></c:if>
					<c:if test="${sel.sel_s eq 1 }"><input type="button" class="adbt-deco1" value="탈퇴처리" onclick="bans('${sel.sel_id}')"/></c:if>
					<c:if test="${sel.sel_s eq 2 }"><input type="button" class="adbt-deco2" value="재승인처리" onclick="apps('${sel.sel_id}')"/></c:if>
				</td>
			</tr>
			</c:forEach>
			
			<tr><td colspan="8" align="center">
				<div>
					<!-- bootstrap -->
					<c:if test="${listcount > 0 }">
						<div aria-label="...">
							<ul class="pagination justify-content-center">
								<!-- 1 페이지로 이동 -->
								<li class="page-item">
									<a class="page-link" href="./manageseller?page=1"> << </a>
								</li>
								
								<!-- 이전 블럭으로 이동 -->
								<c:if test="${startPage > 10 }">
									<li class="page-item">
										<a class="page-link" href="./manageseller?page=${startPage-10}"> < </a>
									</li>
								</c:if>
								
								<!-- 각 블럭에 10개의 페이지 출력 -->
								<c:forEach var="i" begin="${startPage }" end="${endPage }">
									<c:if test="${i == page }">
										<!-- 현재 페이지 -->
										<li class="page-item active">
											<a class="page-link">${i}</a>
										</li>
									</c:if>
									<c:if test="${i != page }">
										<!-- 현재 페이지가 아닌 경우 -->
										<li class="page-item">
											<a class="page-link" href="./manageseller?page=${i}">${i}</a>
										</li>
									</c:if>
								</c:forEach>
								
								<!-- 다음 블럭으로 이동 -->
								<c:if test="${endPage < pageCount }">
									<li class="page-item" aria-current="page">
										<a class="page-link" href="./manageseller?page=${startPage+10 }"> > </a>
									</li>
								</c:if>
							
								<!-- 마지막 페이지로 이동 -->
								<li class="page-item">
									<a class="page-link" href="./manageseller?page=${pageCount }"> >> </a>
								</li>
							</ul>
						</div>
					</c:if>
				</div>
			</td></tr>
			
		</table>
		<!-- 페이징 영역 -->

		
	</div>
	
	
	
	
		
	

</section>

<!-- footer 파일 불러오기 -->
<%@ include file="/WEB-INF/views/footer.jsp" %>

