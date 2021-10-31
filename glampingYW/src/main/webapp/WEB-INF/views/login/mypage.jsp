<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>


</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/member.css">
<section class="col-8 container-fluid">
	<div class="login2" border="1" align="center">
	<c:if test="${m.mem_id != null}">
		<form method="post" action="myinfo">
			<table id="main_t">
			<tr>
					
					<td colspan="2">${sessionScope.id}님 환영합니다</td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="button" id="mb" value="공지사항"
						 onclick="location='#'" /> 
						<input type="button" id="mb" value="Q&A" 
						onclick="#'" /> 
						<input type="button" id="mb" value="내 예약 현황" 
						onclick="location.href='myreservation'"/>
						<input type="submit" id="mb" value="내 정보수정" /></td>
				</tr>

			    <tr>
				    <td id="title">이름</td>
				    <td>${m.mem_name}</td>
			    </tr>

			    <tr>
				    <td id="title">생년월일</td>
				    <td>${m.mem_bir}</td>
			    </tr>
			    
			    <tr>
				    <td id="title">이메일</td>
				    <td>${m.mem_mail}@${m.mem_do}</td>
			    </tr>
			    
			    <tr>
				    <td id="title">휴대폰</td>
				    <td>${m.mem_p1}-${m.mem_p2}-${m.mem_p3}</td>
			    </tr>
			    
   			    <tr>
				    <td id="title">우편번호</td>
				    <td>${m.mem_post}</td>
			    </tr>
			    
		        <tr>
				    <td id="title">주소</td>
				    <td>${m.mem_addr1}</td>
			    </tr>
			    
			    <tr>
				    <td id="title"></td>
				    <td>${m.mem_addr2}</td>
			    </tr>
			    
			   	<tr>
				    <td id="title">프로필사진</td>
				    <td>
				       <c:if test="${empty m.mem_pic}">
				       <img class="profilex" src="${pageContext.request.contextPath}/images/profilex.PNG">
				       </c:if>
				       <c:if test="${!empty m.mem_pic}">
				       <img src="<%=request.getContextPath() %>/upload/${m.mem_pic}" height="200" width="200" />
				       </c:if>
				     </td>
			    </tr>

				
			</table>
		</form>
		</c:if>
		
		<c:if test="${s.sel_id != null}">
		<form method="post" action="myinfo">
			<table id="main_t">
			<tr>
					
					<td colspan="2">${sessionScope.id}님 환영합니다</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" id="mb" value="공지사항"
						 onclick="location.href='#'" /> 
						<input type="button" id="mb" value="Q&A" 
						onclick="#'" /> 
						<input type="submit" id="mb" value="내 정보수정" />
						<input type="button" id="mb" value="내 상품 등록" 
						onclick="location.href='proinsertform'"/>
						<input type="button" id="mb" value="내 상품 현황" 
						onclick="location.href='selprolist'"/>

					</td>
				</tr>
				
			    <tr>
				    <td id="title">이름</td>
				    <td>${s.sel_name}</td>
			    </tr>
			    	    
			    <tr>
				    <td id="title">이메일</td>
				    <td>${s.sel_mail}@${s.sel_do}</td>
			    </tr>
			    
			    <tr>
				    <td id="title">휴대폰</td>
				    <td>${s.sel_p1}-${s.sel_p2}-${s.sel_p3}</td>
			    </tr>
			    
   			    <tr>
				    <td id="title">우편번호</td>
				    <td>${s.sel_post}</td>
			    </tr>
			    
		        <tr>
				    <td id="title">주소</td>
				    <td>${s.sel_addr1}</td>
			    </tr>
			    
			    <tr>
				    <td id="title"></td>
				    <td>${s.sel_addr2}</td>
			    </tr>
			    
			    <tr>
				    <td id="title">사업자번호</td>
				    <td>${s.sel_n1}-${s.sel_n2}</td>
			    </tr>
			    
			   	<tr>
				    <td id="title">프로필사진</td>
				    <td>
				       <c:if test="${empty s.sel_pic}">
				       <img class="profilex" src="${pageContext.request.contextPath}/images/profilex.PNG">
				       </c:if>
				       <c:if test="${!empty s.sel_pic}">
				       <img src="<%=request.getContextPath() %>/upload/${s.sel_pic}" height="200" width="200" />
				       </c:if>
				     </td>
			    </tr>
				
			</table>
		</form>
		</c:if>
		
		<c:if test="${kid != null}">
		<form method="post" action="myinfo">
			<table id="main_t">
			<tr>
					
					<td colspan="2">${sessionScope.kid}님 환영합니다</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" id="mb" value="공지사항"
						 onclick="location='#'" /> 
						<input type="button" id="mb" value="Q&A" 
						onclick="#'" /> 
						<input type="button" id="mb" value="내 예약 현황" 
						onclick="location='#'"/>
						<input type="submit" id="mb" value="내 정보수정" /></td>
				</tr>
				
				
			</table>
		</form>
		</c:if>

	</div>

</section>
<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>