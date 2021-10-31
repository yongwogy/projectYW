<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- header 파일 불러오기 -->
<%@ include file="/WEB-INF/views/header.jsp" %>


<!-- 외부스크립트 불러오기 -->	
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/yw.css">


<section class="col-8 container-fluid ">
	<br>
	<div class="yw_listdiv"><h3>${sessionScope.id}의 등록신청 상품</h3></div>
	<br>	
	
	<c:forEach var="p" items="${prolist }">
							
		<c:if test="${p.pro_s eq 0 }">				

			<div class="yw_listdiv">
				<div id="prolist_ra" class="card mb-3">
				  <div class="row g-0">
				    <div class="col-md-4">
				      <a href="selprodetail?pro_no=${p.pro_no }">
				      <img src="${pageContext.request.contextPath}/upload/${p.pro_pic}" id="pics" title="이미지 없어" height="220" width="350"/>
				      </a>
				    </div>
				    
				    <div class="col-md-8">
				      <div class="card-body">
				        <h5 class="card-title" id="proname">상품명 :&nbsp ${p.pro_name}</h5>
				        <div class="card-text">주소 : &nbsp ${p.pro_addr}</div>
				        <br>
				        <div class="card-text" id="rmsize">객실 :&nbsp</div>			        
				        <c:forEach var="r" items="${s_rmlist }">
				        	<c:if test="${p.pro_no == r.pro_no }">
				     		   <div class="card-text" id="rmsize">${r.rm_tname}&nbsp/&nbsp</div>
			     		   </c:if>	     				      			
				        </c:forEach>							
						<br>
						<br>
						<div class="card-text" id="resize">별점평균: 
							<c:forEach var="i" begin="1" end="10">
								<c:if test="${p.star_avg == i}">
									<img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="...">
								</c:if>
							</c:forEach>							
						</div>
						<br>			
						<br>			
						<div class="card-text" id="revsize">(후기 : <span id="revsize_ch">${p.rv_total}</span>개)</div>
						<div class="card-text" id="revsize">(예약취소 : <span id="revsize_ch">${p.del_no}</span>건)</div>
						<div class="card-text" id="frisize">￦&nbsp<fmt:formatNumber value="${p.rev_cnt}" pattern="#,###"/>원</div>
				      </div>
				    </div>
				  </div>
				</div>
			</div>			

		</c:if>	

	</c:forEach>	

	<hr>

		
	<br>
	<div class="yw_listdiv"><h3>${sessionScope.id}의 영업중 상품</h3></div>
	<br>
		
	<c:forEach var="p" items="${prolist }">
					
		
		<c:if test="${p.pro_s eq 1 }">				

			<div class="yw_listdiv">
				<div id="prolist_ra" class="card mb-3">
				  <div class="row g-0">
				    <div class="col-md-4">
				      <a href="selprodetail?pro_no=${p.pro_no }">
				      <img src="${pageContext.request.contextPath}/upload/${p.pro_pic}" id="pics" title="이미지 없어" height="220" width="350"/>
				      </a>
				    </div>
				    
				    <div class="col-md-8">
				      <div class="card-body">
				        <h5 class="card-title" id="proname">상품명 :&nbsp ${p.pro_name}</h5>
				        <div class="card-text">주소 : &nbsp ${p.pro_addr}</div>
				        <br>
				        <div class="card-text" id="rmsize">객실 :&nbsp</div>			        
				        <c:forEach var="r" items="${s_rmlist }">
				        	<c:if test="${p.pro_no == r.pro_no }">
				     		   <div class="card-text" id="rmsize">${r.rm_tname}&nbsp/&nbsp</div>
			     		   </c:if>	     				      			
				        </c:forEach>							
						<br>
						<br>
						<div class="card-text" id="resize">별점평균: 
							<c:forEach var="i" begin="1" end="10">
								<c:if test="${p.star_avg == i}">
									<img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="...">
								</c:if>
							</c:forEach>							
						</div>
						<br>			
						<br>			
						<div class="card-text" id="revsize">(후기 : <span id="revsize_ch">${p.rv_total}</span>개)</div>
						<div class="card-text" id="revsize">(예약취소 : <span id="revsize_ch">${p.del_no}</span>건)</div>
						<div class="card-text" id="frisize">￦&nbsp<fmt:formatNumber value="${p.rev_cnt}" pattern="#,###"/>원</div>
				      </div>
				    </div>
				  </div>
				</div>
			</div>		

		</c:if>	

	</c:forEach>	

	<hr>

	<br>
	<div class="yw_listdiv"><h3>${sessionScope.id}의 반려된 상품</h3></div>
	<br>
	
	<c:forEach var="p" items="${prolist }">
					
		
		<c:if test="${p.pro_s eq 2 }">				

			<div class="yw_listdiv">
				<div id="prolist_ra" class="card mb-3">
				  <div class="row g-0">
				    <div class="col-md-4">
				      <a href="selprodetail?pro_no=${p.pro_no }">
				      <img src="${pageContext.request.contextPath}/upload/${p.pro_pic}" id="pics" title="이미지 없어" height="220" width="350"/>
				      </a>
				    </div>
				    
				    <div class="col-md-8">
				      <div class="card-body">
				        <h5 class="card-title" id="proname">상품명 :&nbsp ${p.pro_name}</h5>
				        <div class="card-text">주소 : &nbsp ${p.pro_addr}</div>
				        <br>
				        <div class="card-text" id="rmsize">객실 :&nbsp</div>		      
				        <c:forEach var="r" items="${s_rmlist }">
				        	<c:if test="${p.pro_no == r.pro_no }">
				     		   <div class="card-text" id="rmsize">${r.rm_tname}&nbsp/&nbsp</div>
			     		   </c:if>	     				      			
				        </c:forEach>							
						<br>
						<br>
						<div class="card-text" id="resize">별점평균: 
							<c:forEach var="i" begin="1" end="10">
								<c:if test="${p.star_avg == i}">
									<img src="${pageContext.request.contextPath }/images/star${i}.jpg" alt="...">
								</c:if>
							</c:forEach>							
						</div>
						<br>			
						<br>			
						<div class="card-text" id="revsize">(후기 : <span id="revsize_ch">${p.rv_total}</span>개)</div>
						<div class="card-text" id="revsize">(예약취소 : <span id="revsize_ch">${p.del_no}</span>건)</div>
						<div class="card-text" id="frisize">￦&nbsp<fmt:formatNumber value="${p.rev_cnt}" pattern="#,###"/>원</div>
				      </div>
				    </div>
				  </div>
				</div>
			</div>			

		</c:if>	

	</c:forEach>	

	<hr>
	
</section>

<!-- footer 파일 불러오기 -->
<%@ include file="/WEB-INF/views/footer.jsp" %>

