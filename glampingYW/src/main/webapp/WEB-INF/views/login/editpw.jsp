<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>

</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<body>
	<section class="col-8 container-fluid">
		<div class="login1" border="1" align="center">
			<h2 class="del_title" align="center">비밀번호 수정</h2>
			<c:if test="${mem.mem_id != null }">
				<form method="post" action="editpw_okm" onsubmit="return mpw_check()" enctype="multipart/form-data">
					<table id="del_t">
						<tr>
							<th>회원아이디</th>
							<td>${m_id}</td>
						</tr>



						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="mem_pw" size="14"
								class="input_box" /></td>
						</tr>
						<tr>
							<th>새 비밀번호</th>
							<td><input type="password" name="newmem_pw" id="newmem_pw" size="14"
								class="input_box" /></td>
						</tr>
						<tr>
							<th>새 비밀번호 확인</th>
							<td><input type="password" id="newmem_pw1" size="14"
								class="input_box" /></td>
						</tr>


					</table>
					<br>	
					<div id="del_menu" align="center">
						<input type="submit" id="editpwin" value="비번수정"/>
					</div>
				</form>
			</c:if>

			<c:if test="${sel.sel_id != null }">
				<form method="post" action="editpw_oks" onsubmit="return spw_check()" enctype="multipart/form-data">
					<table id="del_t">
						<tr>
							<th>판매자아이디</th>
							<td>${s_id}</td>
						</tr>



						<tr>
							<th>비밀번호</th>
							<td><input type="password" id="sel_pw" size="14"
								class="input_box" /></td>
						</tr>
						<tr>
							<th>새 비밀번호</th>
							<td><input type="password" name="newsel_pw" id="newsel_pw" size="14"
								class="input_box" /></td>
						</tr>
						<tr>
							<th>새 비밀번호 확인</th>
							<td><input type="password" id="newsel_pw1" size="14"
								class="input_box" /></td>
						</tr>


					</table>
					<br>
					<div id="del_menu" align="center">
						<input type="submit" id="editpwin" value="비번수정"/>
					</div>
				</form>
			</c:if>
		</div>
	</section>
</body>
</html>
<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>