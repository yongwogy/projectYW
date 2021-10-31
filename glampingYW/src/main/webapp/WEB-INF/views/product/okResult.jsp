<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${proresult == 1}">
	<script>
		alert("사업장 정보 등록완료");
		location.href = "rminsertform?pro_no=${pro_no}";
	</script>
</c:if>


<c:if test="${rmresult == 1}">
	<script>	
		alert("객실 정보 등록완료");
		location.href = "selprodetail?pro_no=${pro_no}";
	</script>
</c:if>

<c:if test="${proupdateresult == 1}">
	<script>
		alert("사업장 정보 수정완료");
		
		location.href = "selprodetail?pro_no=${pro_no}";
	</script>
</c:if>

<c:if test="${rmupdateresult == 1}">
	<script>
		alert("객실 정보 수정완료");
		
		location.href = "selprodetail?pro_no=${pro_no}";
	</script>
</c:if>

<c:if test="${prodeleteresult == 0}">
	<script>
		alert("아직 완료지 않은 예약이 남아있습니다.");	
		
		history.go(-1);
	</script>
</c:if>

<c:if test="${prodeleteresult == 1}">
	<script>
		alert("상품이 완전히 삭제되었습니다");
		
		location.href = "selprolist";
	</script>
</c:if>

<c:if test="${rmdeleteresult == 1}">
	<script>
		alert("객실 삭제");
		
		location.href = "selprodetail?pro_no=${pro_no}";
	</script>
</c:if>

<c:if test="${resubmitpro_result == 1}">
	<script>
		alert("상품이 다시 제출되었습니다");
		
		location.href = "selprolist";
	</script>
</c:if>