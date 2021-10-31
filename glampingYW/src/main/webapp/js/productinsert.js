$(document).ready(function() {

	//좌표구하기

	$('#myad').click(function() {

		var geocoder = new kakao.maps.services.Geocoder();

		geocoder.addressSearch($("#pro_addr").val(), function(result, status) {
			
		$("#pro_x").val(result[0].x);
		$("#pro_y").val(result[0].y);
		});
		
	});
	
	$('#spost').click(function() {
		$("#pro_x").val("");
		$("#pro_y").val("");
	});


	//업체사진 추가 버튼
	var ppcount = 1;
	$("#add_pp_name").click(function() {	
		ppcount++;

		var addPicText = '<tr id="tr_pp_name">' +
			'    <td></td>' +
			'    <td>' + 
			'        <input type="file" id="pp_name'+ (ppcount) +'" name="pp_name1"/>' +
			'        <button name="del_pp_name" class="bt-deco1">삭제</button>' +
			'    </td>' +
			'</tr>';

		var trHtml = $("tr[id=tr_pp_name]:last"); //last를 사용하여 tr_pp_name라는 명을 가진 마지막 태그 호출

		trHtml.after(addPicText);	
		
	});

	
	//업체사진 삭제 버튼
	$(document).on("click", "button[name=del_pp_name]", function() {

		var trHtml = $(this).parent().parent();
		
		trHtml.remove(); //tr 테그 삭제

	});
	
	
	// 대표사진 첨부파일 검사
	$("#pro_pic1").change(function() {

		var imgFile = $('#pro_pic1').val();
		var fileForm = /(.*?)\.(jpg|jpeg|png|PNG|gif|bmp|pdf)$/;
		var maxSize = 3 * 1024 * 1024;
		var fileSize;

		if(imgFile != "" && imgFile != null) {
			fileSize = document.getElementById("pro_pic1").files[0].size;
		    
		    if(!imgFile.match(fileForm)) {
		    	alert("이미지 파일만 업로드 가능");
		    	$("#pro_pic1").val("")
		        return false;
		    } else if(fileSize > maxSize) {
		    	alert("파일 사이즈는 3MB까지 가능");
		    	$("#pro_pic1").val("")
		        return false;
		    }
		}
		
		
	});	
	
	// 업체사진 첨부파일 검사
	$(document).on("change", "input:file[name='pp_name1']",function(){
	
		for(var i=1; i<=ppcount; i++){
	
			var imgFile = $('#pp_name'+i).val();
			var fileForm = /(.*?)\.(jpg|jpeg|png|PNG|gif|bmp|pdf)$/;
			var maxSize = 3 * 1024 * 1024;
			var fileSize;
	
			if(imgFile != "" && imgFile != null) {
				fileSize = document.getElementById("pp_name"+i).files[0].size;
			    
			    if(!imgFile.match(fileForm)) {
			    	alert("이미지 파일만 업로드 가능");
			    	$("#pp_name"+i).val("")
			        return false;
			    } else if(fileSize > maxSize) {
			    	alert("파일 사이즈는 3MB까지 가능");
			    	$("#pp_name"+i).val("")
			        return false;
			    }
			}
		
		}
			
	});

	

	// 유효성 검사(product)
	$("form").submit(function() {

		if ($("#pro_ceo").val() == "") {
			alert("대표자명을 입력하세요");
			$("#pro_ceo").focus();
			return false;
		}
		if ($("#pro_name").val() == "") {
			alert("상품명을 입력하세요");
			$("#pro_name").focus();
			return false;
		}
		if ($("#pro_post").val() == "") {
			alert("우편번호를 입력하세요");
			$("#pro_post").focus();
			return false;
		}
		if ($("#pro_addr").val() == "") {
			alert("주소를 입력하세요");
			$("#pro_addr").focus();
			return false;
		}
		if ($("#pro_x").val() == "") {
			alert("좌표를 입력 버튼을 클릭하세요");
			$("#pro_x").focus();
			return false;
		}
		if ($("#pro_y").val() == "") {
			alert("좌표를 입력 버튼을 클릭하세요");
			$("#pro_y").focus();
			return false;
		}
		if ($("#pro_n1").val() == "") {
			alert("사업자번호 앞자리를 입력하세요");
			$("#pro_n1").focus();
			return false;
		}
		if (isNaN($("#pro_n1").val())) {
			alert("사업자번호 앞자리는 숫자만 입력하세요");
			$("#pro_n1").val("").focus();
			return false;
		}
		if ($("#pro_n2").val() == "") {
			alert("사업자번호 뒷자리를 입력하세요");
			$("#pro_n2").focus();
			return false;
		}
		if (isNaN($("#pro_n2").val())) {
			alert("사업자번호 뒷자리는 숫자만 입력하세요");
			$("#pro_n2").val("").focus();
			return false;
		}
		if ($("input:checkbox[name='pro_con']:checked").length < 1) {
			alert("편의시설은 1개 이상 선택하세요");
			return false;
		}
		if ($("#pro_pic1").val() == "") {
			alert("업체대표사진을 입력하세요");
			$("#pro_pic").focus();
			return false;
		}

		for(var i=1; i<=ppcount; i++){
			if ($("#pp_name"+i).val() == "") {
				alert("업체사진을 입력하세요");
				$("#pp_name").focus();
				return false;
			}
		}
		if ($("#pro_intro").val() == "") {
			alert("업체 소개글을 작성하세요");
			$("#pro_intro").focus();
			return false;
		}
	

	});




}); // ready end




