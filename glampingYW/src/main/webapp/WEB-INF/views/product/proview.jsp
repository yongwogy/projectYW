<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/proview.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=05274b64af0d95b6ced6532db8a1d75c&libraries=services"></script>


<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<!-- jquery ui css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script type="text/javascript">
 function roomdetail(rm_no){
	 var roomdetail = "${pageContext.request.contextPath}/roomdetail?rm_no="+rm_no;
 
	 window.open(roomdetail ,"아무이름","width=450,height=350,resizable=no");

 }
</script>

<script type="text/javascript">
	$(function() {
		$('#memcalendar').load('${pageContext.request.contextPath }/getmemcalendar?pro_no=${product.pro_no}')
	});
</script>

<script src="${pageContext.request.contextPath }/js/proview.js"></script>
<script src="${pageContext.request.contextPath }/js/review.js"></script>



<section class="col-8 container-fluid">
<input type="hidden" id="sessionid" value="${sessionScope.id}">
	<div class="container">
		<div id="title_view" class="col-12">
			<h2>${product.pro_name}</h2>
			<p>${product.pro_addr}</p>
		</div>
		<div class="row">
			<div id="info" class="col-sm-8 col-md-9">
				<div id="cont_sec">
					<div>
						<div id="carousel_pro" class="carousel slide"
							data-bs-ride="carousel">
							<div class="carousel-indicators">
								<button type="button"
									data-bs-target="#carousel_pro"
									data-bs-slide-to="0" class="active" aria-current="true"
									aria-label="Slide 1"></button>
								<c:set var="size" value="${fn:length(pplist)}"/>
								<c:forEach var="i" begin="1" end="${size}">
									<button type="button"
										data-bs-target="#carousel_pro"
										data-bs-slide-to="${i}" aria-label="Slide ${i+1}"></button>
								</c:forEach>	
							</div>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="${pageContext.request.contextPath }/upload/${product.pro_pic }" class="d-block w-100" alt="..." style="width: 800px; height: 500px;">
								</div>
								<c:forEach var="pp" items="${pplist}">
									<div class="carousel-item">
										<img src="${pageContext.request.contextPath }/upload/${pp.pp_name}" class="d-block w-100" alt="..." style="width: 800px; height: 500px;">
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
					<hr>
					<div>
						<h5 class="bold">숙소소개</h5>
						<p>${intro}</p>
					</div>
					<div>
						<h5 class="bold">주요 편의 시설</h5>
					
						<c:forEach var="con" items="${con}">
							<span class="con_left"><img src="${pageContext.request.contextPath }/images/wood.png" alt="..." width="20" height="18">${con}&nbsp&nbsp</span>
						</c:forEach>		
					<br>	
					<br>	
					</div>

					<div>
						<h5 class="bold">객실 정보</h5>
						<div class="row row-cols-1 row-cols-md-4 g-2">
				
						<c:forEach var="rm" items="${rmlist}">
						<div class="col">
							<div class="card">
								<img src="${pageContext.request.contextPath}/upload/${rm.rm_pic}" class="card-img-top" title="룸 클릭" width="200" height="160" onclick="roomdetail('${rm.rm_no}')">
								 <div class="card-body">
								  	<p class="card-text" style="font-weight: bold;">${rm.rm_tname}&nbsp(${rm.rm_pno}인실)</p>
								  	<p class="card-text" style="font-weight: bold;">￦&nbsp<fmt:formatNumber value="${rm.rm_price}" pattern="#,###"/>원</p>
								  				
									<span id="set_name_${rm.rm_no}" hidden="hidden">${rm.rm_tname}</span>
									<span id="set_price_${rm.rm_no}" hidden="hidden">${rm.rm_price}</span>
									<span id="set_pno_${rm.rm_no}" hidden="hidden">${rm.rm_pno}</span>
									<span id="set_rno_${rm.rm_no}" hidden="hidden">${rm.rm_rno}</span>
									<span id="set_rmno_${rm.rm_no}" hidden="hidden">${rm.rm_no}</span>
									
									<c:forEach var="res" items="${reslist}">
										<c:if test="${rm.rm_no == res.rm_no}">
											<span id="set_resno_${rm.rm_no}" hidden="hidden">${res.res_no}</span>	
										</c:if>
									</c:forEach>									
									<input type="radio" class="form-check-input" id="rm_select" name="rm_select" value="${rm.rm_no}" onclick='getRmInfo(event)'>
									
								</div>
							</div>
						</div>
												
						</c:forEach>
						</div>
					</div>
					
					<h5>예약 현황</h5>
					<div id="memcalendar"></div>			
					
					<div>
						<input type="hidden" id="pro_no" value="${product.pro_no}">
						<h5 class="bold">후기</h5>
						<div class="re_op">
							<c:forEach var="i" begin="1" end="10">
								<c:if test="${star_avg == i}">
									<span class="avg_star">별점평균: <img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="..."></span>
								</c:if>
							</c:forEach>
							<span class="retotal">(후기 ${retotal}개)</span>
							<span><button id="getmyreview" class="b_rev_sear">최신후기 찾기</button>
							<button id="getreviewform" class="b_rev_write" value="${sessionScope.id}">후기 작성</button></span>
						</div>
															
						<c:if test="${empty relist}">						
							<div class="no_re">
								<div id="revform"></div>	
								<div class="no_recon" align="center">아직 후기가 없습니다</div>		
							</div>
						</c:if>
						
						<c:if test="${not empty relist}">						
							<div id="sc" class="yes_re">													
								<div id="revform">
								</div>	
								<c:forEach var="re" items="${relist}">
									<div class="re_detail">
										<div>
											<c:if test="${re.mem_pic == null}">
												<span><img src="${pageContext.request.contextPath }/images/profilex.PNG" alt="..." style="width: 40px; height: 40px; border-radius: 20px;"></span>
											</c:if>									
											<c:if test="${re.mem_pic != null}">
												<span><img src="${pageContext.request.contextPath }/upload/${re.mem_pic }" alt="..." style="width: 40px; height: 40px; border-radius: 20px;"></span>
											</c:if>
											
											<c:forEach var="i" begin="1" end="10">
												<c:if test="${re.rev_star == i}">
													<span id="re_stara_${re.rev_no}" class="re_star"></span>
													<span id="re_starb_${re.rev_no}" class="re_star">별점: <img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="..."></span>
												</c:if>
											</c:forEach>
											<span id="myresearch_${re.rev_no}" class="re_writer">작성자: ${re.mem_id}</span>
											&nbsp&nbsp
											<span class="re_date">작성일: <fmt:formatDate value = "${re.rev_date}" pattern = "yyyy년MM월dd일 HH시mm분" var = "rev_date"/>${rev_date}</span>
											<c:if test="${sessionScope.id == re.mem_id}">
												<span id="set_recon_${re.rev_no}" hidden="hidden">${re.rev_con}</span>
												<span id="set_restar_${re.rev_no}" hidden="hidden">${re.rev_star}</span>
												<span id="set_revno_${re.rev_no}" hidden="hidden">${re.rev_no}</span>
												<span><button id="del_rev_${re.rev_no}" class="del_rev" value="${re.rev_no}" onclick='delrevno(event)'>후기삭제</button></span>
												<span><button id="open_reed_${re.rev_no}" class="update_rev" value="${re.rev_no}" onclick='getrevno(event)'>후기수정</button></span>
											</c:if>
										</div>
										<div id="re_cona_${re.rev_no}"></div>
										<div id="re_conb_${re.rev_no}">
											<span class="re_con">${re.rev_con}</span>
										</div>
									</div>
									<br>
								</c:forEach>
							</div>
							
						</c:if>
						<br>
					</div>
					
					<div id="loc">
						<h5 class="bold">위치</h5>
						<p>주소 : ${product.pro_addr}</p>
						<div id="map" style="width: 800px; height: 400px;"></div>
						<script>
							var container = document.getElementById('map');
							var options = {
								center: new kakao.maps.LatLng(${product.pro_y}, ${product.pro_x}),
								level: 3
							};
					
							var map = new kakao.maps.Map(container, options);
													
							var markerPosition  = new kakao.maps.LatLng(${product.pro_y}, ${product.pro_x}); 

							// 마커를 생성합니다
							var marker = new kakao.maps.Marker({
							    position: markerPosition
							});

							// 마커가 지도 위에 표시되도록 설정합니다
							marker.setMap(map);
						</script>
					</div>
					<div id="cmp_info">
						<h5 class="bold">사업장 정보</h5>
						<p>상호명: ${product.pro_name} / 대표자: ${product.pro_ceo}</p>
						<p>사업자 등록번호: ${product.pro_n1}-${product.pro_n2} / 사업장 주소: ${product.pro_addr}</p>

					</div>
				</div>
			</div>
			
																

			<div id="reserv" class="col-sm-4 col-md-3 ">
				<div id="rev_sec">
					<h5>예약 가격 정보</h5>
					<form method="post" action="<%=request.getContextPath() %>/reserveprevious">
						<div align="center" class="row">
							<div class="col-sm-6 col-md-6">체크인</div>
							<div class="col-sm-6 col-md-6">체크아웃</div>
						</div>
						<div class="row">
							<input class="col-sm-6 col-md-6 input-sm" type="text" id="checkIn" name="checkInS"
										value="${checkInS}" readonly="readonly">
							<input class="col-sm-6 col-md-6 input-sm" type="text" id="checkOut" name="checkOutS"
										value="${checkOutS}" readonly="readonly">
						</div>
						<div>
						<input type="hidden" id="pno">
						<input type="hidden" id="rno">
						<input type="hidden" id="rmno" name="rm_no">
							인원 <select name="res_pno" id="capS">
										<option value="0" <c:if test="${cap=='0'}">selected="selected" </c:if>>인원</option>
										
										<option value="1" <c:if test="${cap=='1'}">selected="selected" </c:if>>1</option>
																	
										<option value="2" <c:if test="${cap=='2'}">selected="selected" </c:if>>2</option>
										
										<option value="3" <c:if test="${cap=='3'}">selected="selected" </c:if>>3</option>
										
										<option value="4" <c:if test="${cap=='4'}">selected="selected" </c:if>>4</option>
										
										<option value="5" <c:if test="${cap=='5'}">selected="selected" </c:if>>5</option>
										
										<option value="6" <c:if test="${cap=='6'}">selected="selected" </c:if>>6</option>
										
										<option value="7" <c:if test="${cap=='7'}">selected="selected" </c:if>>7</option>
											
										<option value="8" <c:if test="${cap=='8'}">selected="selected" </c:if>>8</option>
											
										<option value="9" <c:if test="${cap=='9'}">selected="selected" </c:if>>9</option>
											
										<option value="10" <c:if test="${cap=='10'}">selected="selected" </c:if>>10</option>
											
							</select>
						</div>
						<div id="rm_price" class="row">
							<span id="sel_nm" class="col-sm-12 col-md-12 bold"></span><br>						
						</div>
						<div class="row">
							<span class="col-sm-4 col-md-4" id="sel_count"></span><span class="col-sm-8 col-md-8" id="sel_price"></span>					
						</div>
						<hr>
						<input type="hidden" id="tname" name="res_tname">
						<input type="hidden" id="sel_count2" name="sel_count2">
						<input type="hidden" id="res_price" name="res_price">
						<input type="hidden" id="pro_no" name="pro_no" value="${product.pro_no}">
						
						<div id="chday"></div>						
						
						<input type="submit" class="btn btn-primary col-sm-12 col-md-12" value="예약하기">
				
					</form>
				</div>
			</div>
			

		</div>
	</div>
</section>



<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>