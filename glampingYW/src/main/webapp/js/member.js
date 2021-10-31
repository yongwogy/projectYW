
 function check(){
	
	 var pattern= /^[a-z0-9_]+$/;
	 var mem_id = $("#mem_id").val();

	 if($.trim($("#mem_id").val())==""){
		 alert("회원아이디를 입력하세요!!");
		 $("#mem_id").val("").focus();
		 return false;
	 }
	 if($("#mem_id").val().length < 4 || $("#mem_id").val().length > 12){
		alert("아이디는 4~12자리 입니다");
		$("#mem_id").val("").focus();
		return false;	
	 }	
	 if(!pattern.test(mem_id)){
		alert("아이디는 영문소문자,숫자,_ 조합만 가능합니다");
		$("#mem_id").val("").focus();
		return false;	
	 }

	 if($.trim($("#mem_pw").val())==""){
		 alert("회원비번을 입력하세요!");
		 $("#mem_pw").val("").focus();
		 return false;
	 }

	 if($.trim($("#mem_name").val())==""){
		 alert("회원이름을 입력하세요!");
		 $("#mem_name").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_bir").val())==""){
		 alert("생년월일 입력하세요!");
		 $("#mem_bir").val("").focus();
		 return false;
	 }

	 if(isNaN($("#mem_bir").val())){
		alert("생년월일은 숫자만 입력하세요");
		$("#mem_bir").val("").focus();
		return false;
	 }
	 if($("#mem_bir").val().length != 6 ){
		alert("생년월일은 6자리로 입력하세요 예)900102")
		$("#mem_bir").val("").focus();
		return false;
	 }	


	 if($.trim($("#mem_mail").val())==""){
		 alert("메일 아이디를 입력하세요!");
		 $("#mem_mail").val("").focus();
		 return false;
	 }

	  if($.trim($("#mem_p2").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#mem_p2").val("").focus();
		 return false;
	 }
	 if(isNaN($("#mem_p2").val())){
		alert("휴대폰 둘째자리는 숫자만 입력하세요");
		$("#mem_p2").val("").focus();
		return false;
	 }

	 if($.trim($("#mem_p3").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#mem_p3").val("").focus();
		 return false;
	 }
	 if(isNaN($("#mem_p3").val())){
		alert("휴대폰 셋째자리는 숫자만 입력하세요");
		$("#mem_p3").val("").focus();
		return false;
	 }
	 if($.trim($("#mem_post").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#mem_post").val("").focus();
		 return false;
	 }

	 if($.trim($("#mem_addr2").val())==""){
		 alert("나머지 주소를 입력하세요!");
		 $("#mem_addr2").val("").focus();
		 return false;
	 }
	if($("input[name=mem_gen]:radio:checked").length<1){
		 alert("성별을 선택하세요!");
		 return false;
	}
/*	if($.trim($("#mem_pic1").val())==""){
		 alert("프로필 사진을 입력하세요!");
		 $("#mem_pic1").val("").focus();
		 return false;
	 }*/
	 	 
 }
 
function post_search(){
	alert("우편번호 검색 버튼을 클릭하세요!");
}

function post_check(){
	window.open("zipcode_find.nhn","우편번호검색",
			"width=420,height=200,scrollbars=yes");
	//폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 공지창을 만듬
}


 /* 회원정보 수정 경고창 */
function edit_check(){
	if($.trim($("#mem_pw").val())==""){
		 alert("비번을 입력하세요!");
		 $("#mem_pw").val("").focus();
		 return false;
	 }

	 var mem_pw = $('#mem_pw').val();	
	 var rtn = false;
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/mempw_check",
	        data: {"mem_pw":mem_pw},
			async:false,       
	        success: function (data) { 
	      	  if(data != 1){	//판매자 ID
		     	alert("기존 비밀번호가 일치하지 않습니다");
				rtn = true;
	      	  }   	  
	        }
	        ,
	    	  error:function(e){
	    	  }
	      });

		if (rtn) {
			$("#mem_pw").val("").focus();
			return false;
		}	


	 if($.trim($("#mem_name").val())==""){
		 alert("이름을 입력하세요!");
		 $("#mem_name").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_bir").val())==""){
		 alert("생년월일을 입력하세요!");
		 $("#mem_bir").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_mail").val())==""){
		 alert("메일 아이디를 입력하세요!");
		 $("#mem_mail").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_do").val())==""){
		 alert("메일 주소를 입력하세요!");
		 $("#mem_do").val("").focus();
		 return false;
	 }	
	 if($.trim($("#mem_p2").val())==""){
		 alert("휴대번호를 입력하세요!");
		 $("#mem_tel2").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_p3").val())==""){
		 alert("휴대번호를 입력하세요!");
		 $("#mem_tel3").val("").focus();
		 return false;
	 } 	
	 /*if($.trim($("#join_zip1").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#join_zip1").val("").focus();
		 return false;
	 }
	 if($.trim($("#join_zip2").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#join_zip2").val("").focus();
		 return false;
	 }
	 if($.trim($("#mem_addr1").val())==""){
		 alert("주소를 입력하세요!");
		 $("#mem_addr1").val("").focus();
		 return false;
	 }*/
	 if($.trim($("#mem_addr2").val())==""){
		 alert("나머지 주소를 입력하세요!");
		 $("#mem_addr2").val("").focus();
		 return false;
	 }
	 if($("input[name=mem_gen]:radio:checked").length<1){
		 alert("성별을 선택하세요!");
		 return false;
	}
	
	
	 
	  
}

 /* 회원정보 수정 경고창 */
function edit_check1(){
	if($.trim($("#sel_pw").val())==""){
		 alert("비번을 입력하세요!");
		 $("#sel_pw").val("").focus();
		 return false;
	 }
	 var sel_pw = $('#sel_pw').val();	
	 var rtn = false;
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/selpw_check",
	        data: {"sel_pw":sel_pw},
			async:false,       
	        success: function (data) { 
	      	  if(data != 1){	//판매자 ID
		     	alert("기존 비밀번호가 일치하지 않습니다");
				rtn = true;
	      	  }   	  
	        }
	        ,
	    	  error:function(e){
	    	  }
	      });

		if (rtn) {
			$("#sel_pw").val("").focus();
			return false;
		}	

	
	 if($.trim($("#sel_name").val())==""){
		 alert("이름을 입력하세요!");
		 $("#sel_name").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_mail").val())==""){
		 alert("메일 아이디를 입력하세요!");
		 $("#sel_mail").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_do").val())==""){
		 alert("메일 주소를 입력하세요!");
		 $("#sel_do").val("").focus();
		 return false;
	 }	
	 if($.trim($("#sel_p2").val())==""){
		 alert("휴대번호를 입력하세요!");
		 $("#sel_p2").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_p3").val())==""){
		 alert("휴대번호를 입력하세요!");
		 $("#sel_p3").val("").focus();
		 return false;
	 } 	
	 
	 if($.trim($("#sel_addr2").val())==""){
		 alert("나머지 주소를 입력하세요!");
		 $("#sel_addr2").val("").focus();
		 return false;
	 }
	 if($.trim($("#sel_n1").val())==""){
		 alert("사업자 번호를 입력하세요!");
		 $("#sel_n1").val("").focus();
		 return false;
	 }if($.trim($("#sel_n2").val())==""){
		 alert("사업자 번호를 입력하세요!");
		 $("#sel_n2").val("").focus();
		 return false;
	 }
	 
	 
	
	 
	  
}

 function check4(){
	
	 var pattern= /^[a-z0-9_]+$/;
     var sel_id = $("#sel_id").val();
	
	 if($.trim($("#sel_id").val())==""){
		 alert("사업자아이디를 입력");
		 $("#sel_id").val("").focus();
		 return false;
	 }
	 if($("#sel_id").val().length < 4 || $("#sel_id").val().length > 12){
		alert("사업자아이디는 4~12자리 입니다");
		$("#sel_id").val("").focus();
		return false;	
	 }	
	 if(!pattern.test(sel_id)){
		alert("사업자아이디는 영문소문자,숫자,_ 조합만 가능합니다");
		$("#sel_id").val("").focus();
		return false;	
	 }

	 if($.trim($("#sel_pw").val())==""){
		 alert("사업자비번을 입력하세요!");
		 $("#sel_pw").val("").focus();
		 return false;
	 }

	 if($.trim($("#sel_name").val())==""){
		 alert("사업자이름을 입력하세요!");
		 $("#sel_name").val("").focus();
		 return false;
	 }
	  if($.trim($("#sel_mail").val())==""){
		 alert("메일 아이디를 입력하세요!");
		 $("#sel_mail").val("").focus();
		 return false;
	 }

	  if($.trim($("#sel_p2").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#sel_p2").val("").focus();
		 return false;
	 }
	 if(isNaN($("#sel_p2").val())){
		alert("휴대폰 둘째자리는 숫자만 입력하세요");
		$("#sel_p2").val("").focus();
		return false;
	 }
	 if($.trim($("#sel_p3").val())==""){
		 alert("휴대전화번호를 입력하세요!");
		 $("#sel_p3").val("").focus();
		 return false;
	 }
	 if(isNaN($("#sel_p3").val())){
		alert("휴대폰 셋째자리는 숫자만 입력하세요");
		$("#sel_p3").val("").focus();
		return false;
	 }
	 if($.trim($("#sel_post").val())==""){
		 alert("우편번호를 입력하세요!");
		 $("#sel_post").val("").focus();
		 return false;
	 }

	 if($.trim($("#sel_addr2").val())==""){
		 alert("나머지 주소를 입력하세요!");
		 $("#sel_addr2").val("").focus();
		 return false;
	 }
	if($.trim($("#sel_n1").val())==""){
		 alert("사업자번호를 입력하세요!");
		 $("#sel_n1").val("").focus();
		 return false;
	 }
	 if(isNaN($("#sel_n1").val())){
		alert("사업자번호는 숫자만 입력하세요");
		$("#sel_n1").val("").focus();
		return false;
	 }
	 if($.trim($("#sel_n2").val())==""){
		 alert("사업자번호를 입력하세요!");
		 $("#sel_n2").val("").focus();
		 return false;
	 }
	 if(isNaN($("#sel_n2").val())){
		alert("사업자번호는 숫자만 입력하세요");
		$("#sel_n2").val("").focus();
		return false;
	 }
/*	 if($.trim($("#sel_pic1").val())==""){
		 alert("프로필 사진을 입력하세요!");
		 $("#sel_pic1").val("").focus();
		 return false;
	 }*/
	 	 
 }

// 비번수정
function mpw_check(){
	if($.trim($("#mem_pw").val())==""){
		 alert("비번을 입력하세요!");
		 $("#mem_pw").val("").focus();
		 return false;
	 }

	 var mem_pw = $('#mem_pw').val();	
	 var rtn = false;
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/mempw_check",
	        data: {"mem_pw":mem_pw},
			async:false,       
	        success: function (data) { 
	      	  if(data != 1){	//판매자 ID
		     	alert("기존 비밀번호가 일치하지 않습니다");
				rtn = true;
	      	  }   	  
	        }
	        ,
	    	  error:function(e){
	    	  }
	      });

		if (rtn) {
			$("#mem_pw").val("").focus();
			return false;
		}	

 		if($('#newmem_pw').val() == ""){
		 alert("새로운 비번을 입력하세요!");
		 $("#newmem_pw").val("").focus();
		 return false;
		}
		if($('#newmem_pw1').val() == ""){
		 alert("새로운 비번 확인란을 입력하세요!");
		 $("#newmem_pw1").val("").focus();
		 return false;
		}
		if($('#newmem_pw').val() != $('#newmem_pw1').val()){
		 alert("새로운 비번과 비번확인이 일치하지 않습니다!");
		 $("#newmem_pw1").val("").focus();
		 return false;
		}
		
}

function spw_check(){
	if($.trim($("#sel_pw").val())==""){
		 alert("비번을 입력하세요!");
		 $("#sel_pw").val("").focus();
		 return false;
	 }

	 var sel_pw = $('#sel_pw').val();	
	 var rtn = false;
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/selpw_check",
	        data: {"sel_pw":sel_pw},
			async:false,       
	        success: function (data) { 
	      	  if(data != 1){	//판매자 ID
		     	alert("기존 비밀번호가 일치하지 않습니다");
				rtn = true;
	      	  }   	  
	        }
	        ,
	    	  error:function(e){
	    	  }
	      });

		if (rtn) {
			$("#sel_pw").val("").focus();
			return false;
		}	

 		if($('#newsel_pw').val() == ""){
		 alert("새로운 비번을 입력하세요!");
		 $("#newsel_pw").val("").focus();
		 return false;
		}
		if($('#newsel_pw1').val() == ""){
		 alert("새로운 비번 확인란을 입력하세요!");
		 $("#newsel_pw1").val("").focus();
		 return false;
		}
		if($('#newsel_pw').val() != $('#newsel_pw1').val()){
		 alert("새로운 비번과 비번확인이 일치하지 않습니다!");
		 $("#newsel_pw1").val("").focus();
		 return false;
		}
		
}
	






// 업로드사진 미리보기(회원가입시)

var InputImage1 = 
	(function loadImageFile() {
    if (window.FileReader) {
        var ImagePre; 
        var ImgReader = new window.FileReader();
        var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i; 

        ImgReader.onload = function (Event) {
            if (!ImagePre) {
                var newPreview = document.getElementById("imagePreview");
                ImagePre = new Image();
                ImagePre.style.width = "200px";
                ImagePre.style.height = "200px";
                newPreview.appendChild(ImagePre);

            } 
            ImagePre.src = Event.target.result;
   			var profilex = $('#profilex');
			profilex.remove();         
        };

        return function () {
            var img = document.getElementById("mem_pic1").files;          
            if (!fileType.test(img[0].type)) { 
            	alert("이미지 파일을 업로드 하세요");
				$("#mem_pic1").val(""); 
            	return; 
            }
            
            ImgReader.readAsDataURL(img[0]);
        }

    } 
            document.getElementById("imagePreview").src = document.getElementById("mem_pic1").value;

})();

$(function() {
$('#mem_pic1').change(function () {
    var fileName = $('#mem_pic1').val();
    if (fileName == "") {
		var imagePreview = $('#imagePreview');
		imagePreview.remove(); 		
    }
});

		
});



// 업로드사진 미리보기(사업자회원가입시)

var InputImage2 = 
	(function loadImageFile() {
    if (window.FileReader) {
        var ImagePre; 
        var ImgReader = new window.FileReader();
        var fileType = /^(?:image\/bmp|image\/gif|image\/jpeg|image\/png|image\/x\-xwindowdump|image\/x\-portable\-bitmap)$/i; 

        ImgReader.onload = function (Event) {
            if (!ImagePre) {
                var newPreview = document.getElementById("imagePreview");
                ImagePre = new Image();
                ImagePre.style.width = "200px";
                ImagePre.style.height = "200px";
                newPreview.appendChild(ImagePre);

            } 
            ImagePre.src = Event.target.result;
   			var profilex = $('#profilex');
			profilex.remove();         
        };

        return function () {
            var img = document.getElementById("sel_pic1").files;          
            if (!fileType.test(img[0].type)) { 
            	alert("이미지 파일을 업로드 하세요");
				$("#sel_pic1").val(""); 
            	return; 
            }
            
            ImgReader.readAsDataURL(img[0]);
        }

    } 
            document.getElementById("imagePreview").src = document.getElementById("sel_pic1").value;

})();


$(function() {
$('#sel_pic1').change(function () {
    var fileName = $('#sel_pic1').val();
    if (fileName == "") {
		var imagePreview = $('#imagePreview');
		imagePreview.remove(); 		
    }
});

		
});

 
 
 
 