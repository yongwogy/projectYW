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
<script src="http://code.jquery.com/jquery-latest.js"></script>
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



</head>


<!-- <link rel="stylesheet" type="text/css" href="./css/member.css"> -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/member.css">
<section class="col-8 container-fluid" >	
	<div class="login2" border="1" align="center">
	<h2 align="center">내정보</h2>
	<c:if test="${editm.mem_id != null }">
	<form name="f" method="post" action="edit_ok"
  		onsubmit="return edit_check()" enctype="multipart/form-data">

       <table>
           <tr>
               <td id="title">아이디</td>
               <td>
                   ${id}
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
                   <input type="text" name="mem_name" id="mem_name"maxlength="40"
                   value="${editm.mem_name}">
               </td>
           </tr>
            <tr>
               <td id="title">생년월일</td>
               <td>
                   <input type="text" name="mem_bir" id="mem_bir" maxlength="6" value="${editm.mem_bir}" >
               </td>
           </tr>   
           <tr>
               <td id="title">이메일</td>
               <td>
                   <input type="text" id="mem_mail" name="mem_mail" maxlength="15" value="${editm.mem_mail}">@
                   <select  id="mem_do" name="mem_do" >
                       <option value="naver.com" <c:if test="${editm.mem_do == 'naver.com'}">${'selected'}
            </c:if>>naver.com</option>
                       <option value="daum.net" <c:if test="${editm.mem_do == 'daum.net'}">${'selected'}
            </c:if>>daum.net</option>
                       <option value="gmail.com" <c:if test="${editm.mem_do == 'gmail.com'}">${'selected'}
            </c:if>>gmail.com</option>
                       <option value="nate.com" <c:if test="${editm.mem_do == 'nate.com'}">${'selected'}
            </c:if>>nate.com</option>                        
                       <option value="kakao.com" <c:if test="${editm.mem_do == 'kakao.com'}">${'selected'}
            </c:if>>kakao.com</option>                        
                   </select>
               </td>
           </tr>
               
           <tr>
               <td id="title">휴대폰</td>
               <td>
               <select name="mem_p1" >
		            <option value="010" <c:if test="${editm.mem_p1 == '010'}">${'selected'}
		            </c:if>>010</option>
		            <option value="016" <c:if test="${editm.mem_p1 == '016'}">${'selected'}
		            </c:if>>016</option>
		            <option value="017" <c:if test="${editm.mem_p1 == '017'}">${'selected'}
		            </c:if>>017</option>
		            <option value="018" <c:if test="${editm.mem_p1 == '018'}">${'selected'}
		            </c:if>>018</option>
		            <option value="011" <c:if test="${editm.mem_p1 == '011'}">${'selected'}
		            </c:if>>011</option>               
                </select>-
                   <input type="text" name="mem_p2" id="mem_p2" value="${editm.mem_p2}"/>-
                   <input type="text" name="mem_p3" id="mem_p3" value="${editm.mem_p3}"/>
               </td>
           </tr>
           <tr>
               <td id="title">우편번호</td>
               <td>
                   <input name="mem_post" id="mem_post" size="5" 
      				value="${editm.mem_post}" readonly onclick="post_search()" />
      				<input type="button" value="우편번호검색" 
      				onclick="openDaumPostcode()" />
               </td>
           </tr>
           <tr>
               <td id="title">주소</td>
               <td>
                   <input name="mem_addr1" id="mem_addr1" size="30" value="${editm.mem_addr1}" readonly/>
               </td>
           </tr>
           <tr>
               <td id="title">나머지 주소</td>
               <td>
                   <input name="mem_addr2" id="mem_addr2" size="30" value="${editm.mem_addr2}"/>
               </td>
           </tr>
           
            <tr>
               <td id="title">성별</td>
               <td>
                   <label><input type="radio" name="mem_gen" id="mem_gen" value="man" <c:if test="${editm.mem_gen == 'man'}">${'checked'}
		            </c:if>>남자</label>
                   <label><input type="radio" name="mem_gen" id="mem_gen" value="woman" <c:if test="${editm.mem_gen == 'woman'}">${'checked'}
		            </c:if> >여자</label>
               </td>
           </tr>
           <tr>
              <td id="title">프로필사진</td>
              <td>
		       <input type="file" name="mem_pic1" id="mem_pic1" onchange="InputImage1();" />         
		      </td>
           </tr>
                     	
       </table>
            <br>
            <div align="center">
	            <input type="submit" id="edit" value="수정"/>  
	            <input type="button" id="editpw" value="비밀번호 수정" onclick="location='editpw'"/>
	            <input type="button" id="del" value="탈퇴" onclick="location='del'"/>
            </div>
      </form>
      </c:if>
      
      
      <c:if test="${edit1.sel_id != null }">
	<form name="f" method="post" action="edit_ok1"
  		onsubmit="return edit_check1()" enctype="multipart/form-data">

       <table>
           <tr>
               <td id="title">아이디</td>
               <td>
                   ${id}
               </td>
           </tr>
                   
           <tr>
               <td id="title">비밀번호</td>
               <td>
                   <input type="password" name="sel_pw" id="sel_pw" maxlength="15">
               </td>
           </tr>

           <tr>
               <td id="title">이름</td>
               <td>
                   <input type="text" name="sel_name" id="sel_name"maxlength="40"
                   value="${edit1.sel_name}">
               </td>
           </tr>
           <tr>
               <td id="title">이메일</td>
               <td>
                   <input type="text" id="sel_mail" name="sel_mail" maxlength="15" value="${edit1.sel_mail}">@
                   <select  id="sel_do" name="sel_do" >
                       <option value="naver.com" <c:if test="${edit1.sel_do == 'naver.com'}">${'selected'}
            </c:if>>naver.com</option>
                       <option value="daum.net" <c:if test="${edit1.sel_do == 'daum.net'}">${'selected'}
            </c:if>>daum.net</option>
                       <option value="gmail.com" <c:if test="${edit1.sel_do == 'gmail.com'}">${'selected'}
            </c:if>>gmail.com</option>
                       <option value="nate.com" <c:if test="${edit1.sel_do == 'nate.com'}">${'selected'}
            </c:if>>nate.com</option> 
            			<option value="kakao.com" <c:if test="${editm.mem_do == 'kakao.com'}">${'selected'}
            </c:if>>kakao.com</option>                        
                   </select>
               </td>
           </tr>
               
           <tr>
               <td id="title">휴대폰</td>
               <td>
               <select name="sel_p1" >
		            <option value="010" <c:if test="${edit1.sel_p1 == '010'}">${'selected'}
		            </c:if>>010</option>
		            <option value="016" <c:if test="${edit1.sel_p1 == '016'}">${'selected'}
		            </c:if>>016</option>
		            <option value="017" <c:if test="${edit1.sel_p1 == '017'}">${'selected'}
		            </c:if>>017</option>
		            <option value="018" <c:if test="${edit1.sel_p1 == '018'}">${'selected'}
		            </c:if>>018</option>
		            <option value="011" <c:if test="${edit1.sel_p1 == '011'}">${'selected'}
		            </c:if>>011</option>               
                </select>-
                   <input type="text" name="sel_p2" id="sel_p2" value="${edit1.sel_p2}"/>-
                   <input type="text" name="sel_p3" id="sel_p3" value="${edit1.sel_p3}"/>
               </td>
           </tr>
           <tr>
               <td id="title">우편번호</td>
               <td>
                   <input name="sel_post" id="sel_post" size="5" 
      				value="${edit1.sel_post}" readonly onclick="post_search()" />
      				<input type="button" value="우편번호검색" 
      				onclick="openDaumPostcode()" />
               </td>
           </tr>
           <tr>
               <td id="title">주소</td>
               <td>
                   <input name="sel_addr1" id="sel_addr1" size="30" value="${edit1.sel_addr1}" readonly/>
               </td>
           </tr>
           <tr>
               <td id="title">나머지 주소</td>
               <td>
                   <input name="sel_addr2" id="sel_addr2" size="30" value="${edit1.sel_addr2}"/>
               </td>
           </tr>
           <tr>
               <td id="title">사업자번호</td>
               <td>
                   <input name="sel_n1" id="sel_n1" size="10" value="${edit1.sel_n1 }"/>-
                   <input name="sel_n2" id="sel_n2" size="10" value="${edit1.sel_n2 }"/>
               </td>
             
           </tr>
            
           <tr>
              <td id="title">프로필사진</td>
              <td >
		       <input type="file" name="sel_pic1" id="sel_pic1" onchange="InputImage1();" />    
		     </td>
           </tr>         
          
       </table>
            <br>
            <div align="center">
	            <input type="submit" id="edit" value="수정"/>  
    	        <input type="button" id="editpw" value="비밀번호 수정" onclick="location='editpw'"/>
	            <input type="button" id="del" value="탈퇴" onclick="location='del'"/>
            </div>
      </form>
      </c:if>
      </div>
   </section>
<!-- footer 파일 불러오기 -->
<%@ include file="../footer.jsp"%>