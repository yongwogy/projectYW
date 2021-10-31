<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${meminsert_result == 1 }">
	<script>
		alert("회원가입 성공!");
		location.href="login";
	</script>
</c:if>

<c:if test="${selinsert_result == 1 }">
	<script>
		alert("판매자회원 등록신청하였습니다. 승인을 기다리세요");
		location.href="login";
	</script>
</c:if>

<c:if test="${updateresult == 1 }">
	<script>
		alert("회원수정 성공!");
		location.href="main";
	</script>
</c:if>

<c:if test="${pwupdateresult == 1 }">
	<script>
		alert("비밀번호수정 성공!");
		location.href="main";
	</script>
</c:if>

<c:if test="${deleteresult == 1 }">
	<script>
		alert("회원에서 탈퇴하였습니다!");
		location.href="login";
	</script>
</c:if>

<c:if test="${loginresult == 1 }">
	<script>
		alert("로그인!");
		location.href="main";
	</script>
</c:if>