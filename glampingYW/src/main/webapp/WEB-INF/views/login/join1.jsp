<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- header 파일 불러오기 -->
<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html>
<head>

<title>회원가입폼</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
//우편번호, 주소 Daum API
function openDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {				
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
			document.getElementById('mem_post').value = data.zonecode;
			document.getElementById('mem_addr1').value = data.address;				
		}
	}).open();
}
</script>

<script src="http://code.jquery.com/jquery-latest.js"></script>


<script>

	function validate_userid(mid){
	  var pattern= new RegExp(/^[a-z0-9_]+$/);
	  //영문 소문자,숫자 ,_가능,정규표현식
	  return pattern.test(mid);
	};
	
	$(document).ready(function() {
//	    alert( "test loaded" );
	    
	    $("#id_check").click(function(){
	    	var mid=$("#mem_id").val();
//			alert("test");
			if($.trim($("#mem_id").val()).length < 4){
				var newtext='<font color="red">아이디는 4자 이상이어야 합니다.</font>';
				$("#idcheck").text('');
				$("#idcheck").show();
				$("#idcheck").append(newtext);//span 아이디 영역에 경고문자 추가
				$("#mem_id").val("").focus();
				return false;
			};
			if($.trim($("#mem_id").val()).length >12){
				var newtext='<font color="red">아이디는 12자 이하이어야 합니다.</font>';
				$("#idcheck").text('');
				$("#idcheck").show();
				$("#idcheck").append(newtext);//span 아이디 영역에 경고문자 추가
				$("#mem_id").val("").focus();
				return false;
			};
			//입력아이디 유효성 검사
			if(!(validate_userid(mid))){
				var newtext='<font color="red">아이디는 영문소문자,숫자,_ 조합만 가능합니다.</font>';
				$("#idcheck").text('');//문자 초기화
				$("#idcheck").show();//span 아이디 영역을 보이게 한다.
				$("#idcheck").append(newtext);
				$("#mem_id").val("").focus();
				return false;
			};
			
			//아이디 중복확인
		    $.ajax({
		        type:"POST",
		        url:"/glampingYW/idcheck",
		        data: {"mid":mid},        
		        success: function (data) { 
//		        	alert("return success="+data);
		      	  if(data==1){	//중복 ID
		      		var newtext='<font color="red">중복 아이디입니다.</font>';
		      			$("#idcheck").text('');
		        		$("#idcheck").show();
		        		$("#idcheck").append(newtext);
		          		$("#mem_id").val('').focus();
		          		return false;
			     
		      	  }else{	//사용 가능한 ID
		      		var newtext='<font color="blue">사용가능한 아이디입니다.</font>';
		      		$("#idcheck").text('');
		      		$("#idcheck").show();
		      		$("#idcheck").append(newtext);
		      		$("#mem_pw").focus();
		      	  }  	    	  
		        }
		        ,
		    	  error:function(e){
		    		  alert("data error"+e);
		    	  }
		      });
		     
		});
	    
	}); 
	
</script>

</head>

<!-- <link rel="stylesheet" type="text/css" href="./css/member.css"> -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<section class="col-8 container-fluid" >
	
	<div class="login2" border="1" align="center">
	<h2 align="center">일반 회원가입</h2>
	<form name="f" method="post" action="join_ok"
  		onsubmit="return check()" enctype="multipart/form-data">
       <table>
           <tr>
               <td id="title">아이디</td>
               <td>
                   <input type="text" id="mem_id" name="mem_id" maxlength="20">
                  <input type="button" id=id_check value="아이디 중복체크"  />
               <div id="idcheck"></div>
               </td>
           </tr>
                   
           <tr>
               <td id="title">비밀번호</td>
               <td>
                   <input type="password" name="mem_pw" id="mem_pw" maxlength="15">
               </td>
           </tr>

           <tr>
               <td id="title">이름</td>
               <td>
                   <input type="text" name="mem_name" id="mem_name"maxlength="40">
               </td>
           </tr>
            <tr>
               <td id="title">생년월일</td>
               <td>
                   <input type="text" name="mem_bir" id="mem_bir" maxlength="6" placeholder="ex)900911" >
               </td>
           </tr>   
           <tr>
               <td id="title">이메일</td>
               <td>
                   <input type="text" id="mem_mail" name="mem_mail" maxlength="15" ">@
                   <select  id="mem_do" name="mem_do">
                       <option value="naver.com">naver.com</option>
                       <option value="daum.net">daum.net</option>
                       <option value="gmail.com">gmail.com</option>
                       <option value="nate.com">nate.com</option>                        
                       <option value="kakao.com">kakao.com</option>                        
                   </select>
               </td>
           </tr>
               
           <tr>
               <td id="title">휴대폰</td>
               <td>
               <select name="mem_p1">
                       <option value="010">010</option>
                       <option value="016">016</option>
                       <option value="017">017</option>
                       <option value="018">018</option>
                       <option value="011">011</option>                        
                  </select>-
                   <input type="text" name="mem_p2" id="mem_p2"/>-
                   <input type="text" name="mem_p3" id="mem_p3"/>
               </td>
           </tr>
           <tr>
               <td id="title">우편번호</td>
               <td>
                   <input name="mem_post" id="mem_post" size="5" 
      				readonly onclick="post_search()" />
      				<input type="button" value="우편번호검색" 
      				onclick="openDaumPostcode()" />
               </td>
           </tr>
           <tr>
               <td id="title">주소</td>
               <td>
                   <input name="mem_addr1" id="mem_addr1" size="30" readonly/>
               </td>
           </tr>
           <tr>
               <td id="title">나머지 주소</td>
               <td>
                   <input name="mem_addr2" id="mem_addr2" size="30"/>
               </td>
           </tr>
           
            <tr>
               <td id="title">성별</td>
               <td>
                   <label><input type="radio" name="mem_gen" id="mem_gen" value="man" >남자</label>
                   <label><input type="radio" name="mem_gen" id="mem_gen" value="woman" >여자</label>
               </td>
           </tr>
           <tr>
              <td id="title">프로필사진</td>
              <td >
		       <input type="file" name="mem_pic1" id="mem_pic1" onchange="InputImage1();" />
		     </td>
           </tr>
           
           <tr>
           		<td id="title">미리보기</td>
           		<td id="profilex"><img class="profilex" src="${pageContext.request.contextPath}/images/profilex.PNG"></td>
           		<td id="imagePreview"></td>
           </tr>
 
           
       </table>
            <br>
            <div align="center">
	            <input type="submit" id="join" value="가입"/>  
	            <input type=reset id="back" value="초기화">
            </div>
      </form>
      </div>
   </section>
<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>