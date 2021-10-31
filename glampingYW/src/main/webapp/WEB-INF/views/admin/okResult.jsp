<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:if test="${proapp_result == 1}">
	<script>
		alert("상품승인 완료");
		location.href = "manageproduct";
	</script>
</c:if>

<c:if test="${proban_result == 1}">
	<script>
		alert("상품반려 완료");
		location.href = "manageproduct";
	</script>
</c:if>