$(document).ready(function(){	
	
	
	//객실사진 추가 버튼
	var rpcount = 1;
	$("#add_rp_name").click(function() {
		rpcount++;
		var addPicText = '<tr id="tr_rp_name">' +
			'    <td></td>' +
			'    <td>' +
			'        <input type="file" id="rp_name'+ (rpcount) +'" name="rp_name1" />' +
			'        <button name="del_rp_name" class="bt-deco1">삭제</button>' +
			'    </td>' +
			'</tr>';

		var trHtml = $("tr[id=tr_rp_name]:last"); //last를 사용하여 tr_pp_name라는 명을 가진 마지막 태그 호출

		trHtml.after(addPicText);


	});


	//객실사진 삭제 버튼
	$(document).on("click", "button[name=del_rp_name]", function() {

		var trHtml = $(this).parent().parent();

		trHtml.remove(); //tr 테그 삭제

	});
	
	
	// 객실대표사진 첨부파일 검사
	$("#rm_pic1").change(function() {

		var imgFile = $('#rm_pic1').val();
		var fileForm = /(.*?)\.(jpg|jpeg|png|PNG|gif|bmp|pdf)$/;
		var maxSize = 3 * 1024 * 1024;
		var fileSize;

		if(imgFile != "" && imgFile != null) {
			fileSize = document.getElementById("rm_pic1").files[0].size;
		    
		    if(!imgFile.match(fileForm)) {
		    	alert("이미지 파일만 업로드 가능");
		    	$("#rm_pic1").val("")
		        return false;
		    } else if(fileSize > maxSize) {
		    	alert("파일 사이즈는 3MB까지 가능");
		    	$("#rm_pic1").val("")
		        return false;
		    }
		}
		
		
	});	
	
	// 객실사진 첨부파일 검사
	$(document).on("change", "input:file[name='rp_name1']",function(){
		for(var i=1; i<=rpcount; i++){
			var imgFile = $('#rp_name'+i).val();
			var fileForm = /(.*?)\.(jpg|jpeg|png|PNG|gif|bmp|pdf)$/;
			var maxSize = 3 * 1024 * 1024;
			var fileSize;
	
			if(imgFile != "" && imgFile != null) {
				fileSize = document.getElementById("rp_name"+i).files[0].size;
			    
			    if(!imgFile.match(fileForm)) {
			    	alert("이미지 파일만 업로드 가능");
			    	$("#rp_name"+i).val("")
			        return false;
			    } else if(fileSize > maxSize) {
			    	alert("파일 사이즈는 3MB까지 가능");
			    	$("#rp_name"+i).val("")
			        return false;
			    }
			}
		}		
	});
	
/*-------------------------------------------------------------------------------------------------------*/	
	
		
	// 유효성 검사
	$("form").submit(function(){	
		
		if($("#rm_tname").val()==""){
			alert("객실명을 입력하세요");
			$("#rm_tname").focus();
			return false;
		}
		if($("#rm_pno").val()==""){
			alert("객실당 인원수를 입력하세요");
			$("#rm_pno").focus();
			return false;
		}
		if(isNaN($("#rm_pno").val())){
			alert("객실당 인원수는 숫자만 입력하세요");
			$("#rm_pno").val("").focus();
			return false;
		}
		if($("#rm_rno").val()==""){
			alert("객실 수량을 입력하세요");
			$("#rm_rno").focus();
			return false;
		}
		if(isNaN($("#rm_rno").val())){
			alert("객실 수량은 숫자만 입력하세요");
			$("#rm_rno").val("").focus();
			return false;
		}
		if($("#rm_price").val()==""){
			alert("객실 가격을 입력하세요");
			$("#rm_price").focus();
			return false;
		}
		if(isNaN($("#rm_price").val())){
			alert("객실 가격은 숫자만 입력하세요");
			$("#rm_price").val("").focus();
			return false;
		}
		if($("#rm_pic1").val()==""){
			alert("객실 대표사진을 입력하세요");
			$("#rm_pic1").focus();
			return false;
		}
		for(var i=1; i<=rpcount; i++){
			if ($("#rp_name"+i).val() == "") {
				alert("객실사진을 입력하세요");
				$("#rp_name").focus();
				return false;
			}
		}

	
	});
	
	
}); // ready end
	
