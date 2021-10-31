<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<script>
 function check2(){
	 if($.trim($("#pwd").val())==""){
		 alert("비밀번호를 입력하세요!");
		 $("#pwd").val("").focus();
		 return false;
	 }
	
	 
 }
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
</head>
<body>
<section class="col-8 container-fluid" >
<div class="login1" border="1" align="center">
  <h2 class="del_title" align="center">회원탈퇴</h2>
  <c:if test="${dels.sel_id != null }">
  <form method="post" action="del_ok" 
  					  onsubmit="return check2()">
    <table id="del_t">
     <tr>
      <th>회원아이디</th>
      <td>
      	${s_id}
      </td>
     </tr>
     
    
     
     <tr>
      <th>비밀번호</th>
      <td>
      <input type="password" name="pwd" id="pwd" size="14" 
      			class="input_box" />
      </td>
     </tr>
     
     
    </table>
    <br>
    <div id="del_menu" align="center">
     <input type="submit" id="del" value="탈퇴" />
    </div>
  </form>
   </c:if>
   
    <c:if test="${delm.mem_id != null }">
  <form method="post" action="del_ok1" 
  					  onsubmit="return check2()">
    <table id="del_t">
     <tr>
      <th>회원아이디</th>
      <td>
      	${d_id}
      </td>
     </tr>
     
    
     
     <tr>
      <th>비밀번호</th>
      <td>
      <input type="password" name="pwd" id="pwd" size="14" 
      			class="input_box" />
      </td>
     </tr>
     
     
    </table>
    <br>
    <div id="del_menu" align="center">
     <input type="submit" id="del" value="탈퇴" />
    </div>
  </form>
   </c:if>
 </div>
 </section>
</body>
</html>
<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>