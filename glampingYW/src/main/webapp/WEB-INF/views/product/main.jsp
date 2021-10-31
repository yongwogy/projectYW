<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<!-- jquery ui css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="${pageContext.request.contextPath }/js/main.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/prolist.css">

<section class="col-8 container-fluid ">
	<div id="null_sec"></div>
	<div id="search_box">
		<form action="${pageContext.request.contextPath }/prolist/pageNum/1" method="post">
			<div class="row">
				<div class="col-2">
					<span class="f14">지역</span>
					<div class="input-group mb-3">
						<select name="regionS" id="regionS" class="form-control">
<%-- 							<option value="all"
								<c:if test="${regionS=='all'}">selected="selected" </c:if>>전체</option>
							<option value="Gyeonggi"
								<c:if test="${regionS=='Gyeonggi'}">selected="selected" </c:if>>경기</option>
							<option value="Incheon"
								<c:if test="${regionS=='Incheon'}">selected="selected" </c:if>>인천</option>
							<option value="Chung"
								<c:if test="${regionS=='Chung'}">selected="selected" </c:if>>충청</option>
							<option value="Gyeongsang"
								<c:if test="${regionS=='Gyeongsang'}">selected="selected" </c:if>>경상</option>
							<option value="Busan"
								<c:if test="${regionS=='Busan'}">selected="selected" </c:if>>부산</option>
							<option value="Jeol"
								<c:if test="${regionS=='Jeol'}">selected="selected" </c:if>>전라</option>
							<option value="Jeju"
								<c:if test="${regionS=='Jeju'}">selected="selected" </c:if>>제주</option>
							<option value="Gangwon"
								<c:if test="${regionS=='Gangwon'}">selected="selected" </c:if>>강원</option> --%>
							<option value="all"
								<c:if test="${regionS=='all'}">selected="selected" </c:if>>전체</option>
							<option value="Gyeonggi"
								<c:if test="${regionS=='Gyeonggi'}">selected="selected" </c:if>>경기</option>
							<option value="Gangwon"
								<c:if test="${regionS=='Gangwon'}">selected="selected" </c:if>>강원</option>								
							<option value="Chungbuk"
								<c:if test="${regionS=='Chungbuk'}">selected="selected" </c:if>>충북</option>
							<option value="Chungnam"
								<c:if test="${regionS=='Chungnam'}">selected="selected" </c:if>>충남</option>
							<option value="Jeonbuk"
								<c:if test="${regionS=='Jeonbuk'}">selected="selected" </c:if>>전북</option>
							<option value="Jeonman"
								<c:if test="${regionS=='Jeonman'}">selected="selected" </c:if>>전남</option>
							<option value="Kyeongbuk"
								<c:if test="${regionS=='Kyeongbuk'}">selected="selected" </c:if>>경북</option>
							<option value="Gyeongnam"
								<c:if test="${regionS=='Gyeongnam'}">selected="selected" </c:if>>경남</option>
							<option value="Jeju"
								<c:if test="${regionS=='Jeju'}">selected="selected" </c:if>>제주</option>
							<option value="Seoul"
								<c:if test="${regionS=='Seoul'}">selected="selected" </c:if>>서울</option>
							<option value="Incheon"
								<c:if test="${regionS=='Incheon'}">selected="selected" </c:if>>인천</option>
							<option value="Busan"
								<c:if test="${regionS=='Busan'}">selected="selected" </c:if>>부산</option>
							<option value="Daejeon"
								<c:if test="${regionS=='Daejeon'}">selected="selected" </c:if>>대전</option>
							<option value="Gwangju"
								<c:if test="${regionS=='Gwangju'}">selected="selected" </c:if>>광주</option>
							<option value="Daegu"
								<c:if test="${regionS=='Daegu'}">selected="selected" </c:if>>대구</option>
							<option value="Ulsan"
								<c:if test="${regionS=='Ulsan'}">selected="selected" </c:if>>울산</option>
						</select> 
					</div>
				</div>
				<div class="col-4">
					<span class="f14">날짜</span>
					<div class="input-group mb-3">
						<input type="text" id="checkIn" class="form-control" name="checkInS" value="${checkInS}" readonly="readonly">
						<input type="text" id="checkOut" class="form-control" name="checkOutS" value="${checkOutS}" readonly="readonly">
					</div>
				</div>
				<div class="col-2">
					<span class="f14">인원</span>
					<div class="input-group mb-3">
						<select name="capS" id="capS" class="form-control">
							<option value="0"
								<c:if test="${cap=='0'}">selected="selected" </c:if>>인원</option>
							<option value="1"
								<c:if test="${cap=='1'}">selected="selected" </c:if>>1</option>
							<option value="2"
								<c:if test="${cap=='2'}">selected="selected" </c:if>>2</option>
							<option value="3"
								<c:if test="${cap=='3'}">selected="selected" </c:if>>3</option>
							<option value="4"
								<c:if test="${cap=='4'}">selected="selected" </c:if>>4</option>
							<option value="5"
								<c:if test="${cap=='5'}">selected="selected" </c:if>>5</option>
							<option value="6"
								<c:if test="${cap=='6'}">selected="selected" </c:if>>6</option>
							<option value="7"
								<c:if test="${cap=='7'}">selected="selected" </c:if>>7</option>
							<option value="8"
								<c:if test="${cap=='8'}">selected="selected" </c:if>>8</option>
							<option value="9"
								<c:if test="${cap=='9'}">selected="selected" </c:if>>9</option>
							<option value="10"
								<c:if test="${cap=='10'}">selected="selected" </c:if>>10</option>
						</select>
					</div>
				</div>
				<div class="col-4">
					<span class="f14">키워드</span>
					<div class="input-group mb-3">
						<input type="text" name="keyword" class="form-control" id="keyword" value="${keyword}">
						<input type="submit" class="btn btn-outline-secondary" value="검색">
					</div>
				</div>
			</div>
		</form>
	</div>
	<div id="title_set" class="col-12 align-self-center">
		<p>준비할 필요없이 즐기는 캠핑, 화려한 캠핑 글램핑! </p>
	</div>
	<div id="best_sec">
		<div id="carouselExampleCaptions" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<c:set var="size" value="${fn:length(listBest)}"/>
				<c:forEach var="i" begin="1" end="${size}">
					<button type="button" data-bs-target="#carouselExampleCaptions"
						data-bs-slide-to="${i}" aria-label="Slide ${i+1}"></button>
				</c:forEach>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="${pageContext.request.contextPath }/images/mainbest.jpg" class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>추천 상품 목록</h5>
						<p>인기 상승 중인 상품을 알려드립니다</p>
					</div>
				</div>
			<c:forEach var="best" items="${listBest }">
				<div class="carousel-item">
					<img src="${pageContext.request.contextPath }/upload/${best.pro_pic }" class="d-block w-100" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5><a class="a_best" href="${pageContext.request.contextPath }/proView/pro_no/${best.pro_no}">${best.pro_name }</a></h5>
						<p><a class="a_best" href="${pageContext.request.contextPath }/proView/pro_no/${best.pro_no}">${best.pro_addr }</a></p>
					</div>
				</div>
			</c:forEach>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
	<div>
		<div id="top_title">
			<h4>최신 글램핑장</h4>
		</div>
		
		<c:forEach var="top" items="${listTop }">
		<c:if test="${top.pro_s eq 1 }">
			<div class="card">
				<div class="row g-0">
					<div class="col-4 col-sm-3">
						<a href="${pageContext.request.contextPath }/proView/pro_no/${top.pro_no}">
							<img src="${pageContext.request.contextPath }/upload/${top.pro_pic}" height="200" width="280">
						</a>
					</div>
					<div class="col-8 col-sm-9 protext">
						<h4>${top.pro_name }</h4><br>
						<p>${top.pro_addr }</p>
						<div class="else_info row">
							<div class="col-9">
								<c:if test="${top.rv_total != 0 }">
									<c:forEach var="i" begin="1" end="10">
										<c:if test="${top.star_avg == i}">
											<span class="avg_star">별점평균: <img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="..."></span>
										</c:if>
									</c:forEach>
									<span class="f14">(후기 ${top.rv_total})</span>
								</c:if>
								<c:if test="${top.rv_total == 0 }">
									<span class="f14">아직 후기가 없습니다</span>
								</c:if>
							</div>
							<div class="col-3">
								<p>최저 <span class="f18"><fmt:formatNumber value="${top.rev_cnt}" pattern="#,###"/>원</span></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		</c:forEach>
		
	</div>
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>

