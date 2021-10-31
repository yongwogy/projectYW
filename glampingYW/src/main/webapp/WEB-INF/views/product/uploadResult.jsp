<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${result == 1 }">
	<script>
		alert("썸네일 사진파일은 10MB까지 업로드 가능합니다.");
		history.go(-1); 
	</script>
</c:if>

<c:if test="${result == 2 }">
	<script>
		alert("썸네일 사진첨부파일은 jpg, jpeg, gif, png파일만 업로드 가능합니다.");
		history.go(-1);
	</script>
</c:if>

<c:if test="${pp_result == 1 }">
	<script>
		alert("업체사진파일은 10MB까지 업로드 가능합니다.");
		location.href="errorppinsert";
	</script>
</c:if>

<c:if test="${pp_result == 2 }">
	<script>
		alert("업체사진 첨부파일은 jpg, jpeg, gif, png파일만 업로드 가능합니다.");
		location.href="errorppinsert";
	</script>
</c:if>

<c:if test="${insertfail == 1 }">
	<script>
		history.go(-1);
	</script>
</c:if>


<c:if test="${rm_result == 1 }">
	<script>
		alert("객실 썸네일 사진파일은 10MB까지 업로드 가능합니다.");
		history.go(-1); 
	</script>
</c:if>

<c:if test="${rm_result == 2 }">
	<script>
		alert("객실사진 첨부파일은 jpg, jpeg, gif, png파일만 업로드 가능합니다.");
		history.go(-1);
	</script>
</c:if>

<c:if test="${rp_result == 1 }">
	<script>
		alert("객실사진파일은 10MB까지 업로드 가능합니다.");
		location.href="errorrpinsert";
	</script>
</c:if>

<c:if test="${rp_result == 2 }">
	<script>
		alert("객실사진 첨부파일은 jpg, jpeg, gif, png파일만 업로드 가능합니다.");
		location.href="errorrpinsert";
	</script>
</c:if>