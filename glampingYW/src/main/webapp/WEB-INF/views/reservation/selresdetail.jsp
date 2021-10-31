<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/primary.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/yw2.css">

<script type="text/javascript">
function close1() {
	window.close();
}

</script>

<section class="col-8 container-fluid" style="min-height: 280px;">
	

		<div class="backwhite" border="1" align="center">
	
					
	
			<div class="backwhite2" align="left">
							
			
				<div id="le"><span id="res_t">예약자 ID: ${res.mem_id}</span></div>
				<div id="le">
					<span id="font_w">${pro.pro_name}:</span>
					<span>&nbsp&nbsp${pro.pro_addr}</span>
					<span id="ckr">&nbsp&nbsp연락처:&nbsp${sel.sel_p1}-${sel.sel_p2}-${sel.sel_p3}</span>
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
					<input type="button" value="창 닫기" class="bt-deco" onclick="close1()"/>
				</div>												
			</div>			
		</div>	

</section>



