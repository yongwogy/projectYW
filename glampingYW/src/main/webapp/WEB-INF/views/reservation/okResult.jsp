<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${reservation_result == 1}">
	<script>
		alert("예약되었습니다");
		location.href = "main";
	</script>
</c:if>

<c:if test="${delreservation_result == 1}">
	<script>
		alert("예약취소 신청되었습니다");
		location.href = "mypage";
	</script>
</c:if>

<c:if test="${return_reservation_result == 1}">
	<script>
		alert("예약취소신청을 거부하였습니다!");
		location.href = "show_delres?pro_no=${pro_no}";
		window.opener.location.reload();
	</script>
</c:if>

<c:if test="${terminate_reservation_result == 1}">
	<script>
		alert("예약이 완전히 삭제되었습니다!");
		location.href = "show_delres?pro_no=${pro_no}";
		window.opener.location.reload();
	</script>
</c:if>