<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/yw.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/proview.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=05274b64af0d95b6ced6532db8a1d75c&libraries=services"></script>


<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<!-- 외부스크립트 불러오기 -->	
<script src="${pageContext.request.contextPath }/js/selprodetail.js"></script>


<script type="text/javascript">
	$(function() {
		$('#rescalendar').load('getrescalendar?pro_no=${pro.pro_no}')
	});
</script>


<section class="col-8 container-fluid">

	<div class="container">
		<div id="title" class="col-12">
			<h2>${pro.pro_name}</h2>
			<p>${pro.pro_addr}</p>
		</div>
		
		
		<div class="row">
			<div id="info" class="col-sm-8 col-md-12">
				<div>
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
									<img src="${pageContext.request.contextPath }/upload/${pro.pro_pic }" class="d-block w-100" alt="..." style="width: 800px; height: 700px;">
								</div>
								<c:forEach var="pp" items="${pplist}">
									<div class="carousel-item">
										<img src="${pageContext.request.contextPath }/upload/${pp.pp_name}" class="d-block w-100" alt="..." style="width: 800px; height: 700px;">
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
						<h5>숙소소개</h5>
						<p>${intro}</p>
					</div>
					
					<hr>
					
					<div>
						<h5>주요 편의 시설</h5>
						<c:forEach var="con" items="${con}">
							<span class="con_left"><img src="${pageContext.request.contextPath }/images/wood.png" alt="..." width="20" height="18">${con}&nbsp&nbsp</span>
						</c:forEach>					
					<br>
					</div>
					
					<hr>
									
					<div>		
						<h5>객실 정보</h5>------
						<a href="rminsertform?pro_no=${pro.pro_no}"><input type="button" value="객실추가" class="bt-deco"/></a>
					</div>
				
					
					<div class="row row-cols-1 row-cols-md-4 g-2">
 
						<c:forEach var="rm" items="${rmlist}">
							<c:if test="${rm.rm_s == 1}">
								<div class="col">
									<div class="card">
										<img src="${pageContext.request.contextPath}/upload/${rm.rm_pic}" class="card-img-top" title="룸 클릭" width="200" height="200" onclick="roomdetail('${rm.rm_no}')">
										 <div class="card-body">
										  	<p class="card-text" style="font-weight: bold;">${rm.rm_tname}&nbsp(${rm.rm_pno}인실)</p>
										  	<p class="card-text" style="font-weight: bold;">￦&nbsp<fmt:formatNumber value="${rm.rm_price}" pattern="#,###"/>원</p>
										</div>
										<div align="center">
											<a href="rmupdateform?rm_no=${rm.rm_no}"><input type="button" value="객실수정" class="bt-deco"/></a>
											<input type="button" value="영업중지" class="bt-deco1" onclick="stop_sales('${rm.rm_no}')"/>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>	
					<br>
					<div class="row row-cols-1 row-cols-md-4 g-2">
						<c:forEach var="rm" items="${rmlist}">
							<c:if test="${rm.rm_s == 0}">
								<div class="col">
									<div class="card">
										<img src="${pageContext.request.contextPath}/upload/${rm.rm_pic}" id="fil_pic" class="card-img-top" title="룸 클릭" width="200" height="200" onclick="roomdetail('${rm.rm_no}')">
										 <div class="card-body">
										  	<p class="card-text" style="font-weight: bold;">${rm.rm_tname}&nbsp(${rm.rm_pno}인실)</p>
											<p class="stop_sal">(영업중지)</p>
										  	<p class="card-text" style="font-weight: bold;">￦&nbsp<fmt:formatNumber value="${rm.rm_price}" pattern="#,###"/>원</p>
										</div>
										<div align="center">
											<a href="rmupdateform?rm_no=${rm.rm_no}"><input type="button" value="객실수정" class="bt-deco"/></a>
											<input type="button" value="객실삭제" class="bt-deco1" onclick="delr('${rm.rm_no}')"/>
											<input type="button" value="영업재개" class="bt-deco2" onclick="restart_sales('${rm.rm_no}')"/>
										</div>
									</div>

								</div>
							</c:if>
						</c:forEach>
					</div>	
					
					
					<hr>
				
					<h5>예약 현황</h5>
					<div id="rescalendar"></div>
					
					<hr>
					
					<input type="hidden" id="pro_no" value="${pro.pro_no}">
					<div>				
						<h5 class="bold">후기</h5>
						<div class="re_op">
							<c:forEach var="i" begin="1" end="10">
								<c:if test="${star_avg == i}">
									<span class="avg_star">별점평균: <img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="..."></span>
								</c:if>
							</c:forEach>
							<span class="retotal">(후기 ${retotal}개)</span>
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
					

					
					<hr>
					
					<div>
						<h5>위치</h5>
						<div id="map" style="width: 900px; height: 400px;"></div>
						<script>
							var container = document.getElementById('map');
							var options = {
								center: new kakao.maps.LatLng(${pro.pro_y}, ${pro.pro_x}),
								level: 3
							};
					
							var map = new kakao.maps.Map(container, options);
													
							var markerPosition  = new kakao.maps.LatLng(${pro.pro_y}, ${pro.pro_x}); 

							// 마커를 생성합니다
							var marker = new kakao.maps.Marker({
							    position: markerPosition
							});

							// 마커가 지도 위에 표시되도록 설정합니다
							marker.setMap(map);
						</script>
					</div>
					
					<hr>
					
					<div>
						<h5>사업장 정보</h5>
						<p>상호명: ${pro.pro_name}</p>
						<p>대표자: ${pro.pro_ceo}</p>
						<p>사업자 등록번호: ${pro.pro_n1}-${pro.pro_n2}</p>
						<p>사업장 주소: ${pro.pro_addr}</p>
					</div>
					
					<div align=center>
					<tr>
						<td>
							<a href="proupdateform?pro_no=${pro.pro_no}"><input type="button" value="상품수정" class="bt-deco"/></a>
						<%-- 	<input type="button" value="상품삭제" class="bt-deco1" onclick="delp('${pro.pro_no}')"/> --%>
							<input type="button" id="show_delform" value="상품삭제" class="bt-deco1"/>
							
							<div id="show_form" class="prodel_contain">
								<div>			
									<input type="hidden" id="sel_id" value="${sessionScope.id}">
									<span class="sel_ps">판매자 비밀번호:</span>
									<span><input type="password" id="sel_pass" class="round_p"></span>
									<span><input type="button" id="selpassact" class="bt-deco1" value="삭제"></span>
								</div>	
								<br>
								<div class="warn_text">
									<p>경고: 해당상품을 삭제하시면 해당상품에 예약했던</p>
									<p>모든 예약정보 및 후기정보가 삭제됩니다.</p>
									<p>진행중인 예약정보가 없는지 꼭 확인하세요</p>
								</div>
								
								<hr>		
								<div align=center>
										<input type="button" id="hide_form" value="닫기" class="bt-deco"/>
								</div>	
							</div>
							
							<c:if test="${pro.pro_s == 2}">
							<input type="button" value="다시제출" class="bt-deco2" onclick="re_submit('${pro.pro_no}')"/>
							</c:if>
						</td>	
					</tr>
					</div>	
					
				</div>
			</div>

		</div>
	</div>
</section>



<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>