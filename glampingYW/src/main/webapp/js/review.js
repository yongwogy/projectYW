$(document).ready(function() {
	
	/*최근 후기찾기*/
	$('#getmyreview').click(function(){
		
		var mem_id = $('#getreviewform').val();
		var pro_no = $('#pro_no').val();
		
		$.ajax({
			type: "POST",
			url: "/glampingYW/researchreview",
			data: {"mem_id":mem_id, "pro_no":pro_no},
			success: function(data) {
				var rev_no = data.rev_no;
		        var position = $("#myresearch_"+rev_no).position();
      			$('#sc').animate({ scrollTop: position.top }, 400);			
			},
			error: function() {
				alert("후기를 찾을수 없습니다");
			}
	
		});	
		

	});
	

	
	
	/*후기입력창 열기*/
	$('#getreviewform').click(function() {
		var mem_id = $('#getreviewform').val();
		var pro_no = $('#pro_no').val();
		
		if(mem_id == ""){
			alert("후기를 작성하려면 로그인을 해야합니다");
			return false;
		}
		$.ajax({
			type: "POST",
			url: "/glampingYW/reviewprepare",
			data: {"mem_id":mem_id, "pro_no":pro_no},
			success: function(data) {
				if(data == 1){
			
				var output = '';
				output += '<div>';
				output += '<span>';
				output += '<select id="rev_star" is="ms-dropdown" style="width: 19%;">';		
				output += '<option value="0" id="zero">평점</option>';
				for(var i=10; i>=1; i--){
				output += '<option value="' + i + '" data-image="/glampingYW/images/star' + i + '.jpg">' + i + '점</option>';
				}
				output += '</select>';
				output += '</span>';
				output += '<span class="avg_star">' + '&nbsp&nbsp새로운 후기 입력' + '</span>';
				output += '</div>';
				output += '<div>';
				output += '<textarea id="rev_con" class="re_conwr" rows="5" cols="115">' + '</textarea>';
				output += '</div>';
				output += '<div align="center">' + '<br>';
				output += '<input type="button" id="re_sub" class="re_sub" value="작성">' + '<input type="button" id="re_reset" class="re_reset" value="취소">';
				output += '</div>' + '<br>';			
				document.getElementById('revform').innerHTML = output;
/*				$("#revform").append(output);*/

				} else {
					alert("후기는 해당숙소 예약하신분만 가능합니다")
				}
			},
			error: function() {
				alert("request error!");
			}
	
		});	
		
	});
	
	/*후기입력 실행*/
	$(document).on("click", "#re_sub", function(){
		
		if($("#rev_con").val() == "") {
			alert("후기를 입력하세요");
			$("#rev_con").focus();
			return false;
		}
		if($("#rev_star").val() == 0) {
			alert("평점을 입력하세요");
			$("#rev_star").focus();
			return false;
		}

		var mem_id = $('#getreviewform').val();
		var pro_no = $('#pro_no').val();
		var rev_star = $('#rev_star').val();
		var rev_con = $('#rev_con').val();
		
		$.ajax({
			type: "POST",
			url: "/glampingYW/reviewinsert",
			data: {"mem_id":mem_id, "pro_no":pro_no, "rev_star":rev_star, "rev_con":rev_con},
			success: function(data) {
				if(data == 1){
					alert("후기를 작성하셧습니다!");
					location.reload();
				} else {
					alert("후기입력 실패");
				}
			},
			error: function() {
				alert("후기는 예약한 건당 1개씩 작성 가능합니다");
				location.reload();
			}
	
		});	
		

	});
	
	
	/*작성중 후기 초기화*/
	$(document).on("click", "#re_reset", function(){
		$('#rev_con').val("");
	});
	
	

	

});

/*후기 수정창 열기*/
function getrevno(event) {

	var rev_no = event.target.value;	

	var star = document.getElementById('set_restar_' + rev_no).innerText;
	var con = document.getElementById('set_recon_' + rev_no).innerText;
	
	
	document.getElementById('re_starb_'+rev_no).remove();
	var output2 = '';
	output2 += '<select id="rev_star_' + rev_no + '" is="ms-dropdown" style="width: 19%;">';		
	output2 += '<option value="0" id="zero">평점</option>';
	for(var i=10; i>=1; i--){
	output2 += '<option ';
	if(star == i){
	output2 += 'selected="selected"';	
	}	
	output2 += 'value="' + i + '" data-image="/glampingYW/images/star' + i + '.jpg">';
	output2 += i + '점</option>';
	}
	output2 += '</select>';				
	document.getElementById('re_stara_'+rev_no).innerHTML = output2;
	
	
	document.getElementById('re_conb_'+rev_no).remove();
	var output = '';
	output += '<span class="re_con">';			
	output += '<textarea id="rev_con_' + rev_no + '" class="re_conwr" rows="5" cols="110">' + con + '</textarea>';	
	output += '<div align="center">' + '<br>';
	output += '<input type="button" id="reed_sub_' + rev_no + '" class="re_sub" value="수정">' + '<input type="button" id="reed_reset_' + rev_no + '" class="re_reset" value="취소">';
	output += '</div>' + '<br>';			
	output += '</span>';			
	document.getElementById('re_cona_'+rev_no).innerHTML = output;
				
	/*수정중 후기 초기화*/
	$(document).on("click", "#reed_reset_"+rev_no, function(){
		$('#rev_con_'+rev_no).val("");
	});
	

	
	/*후기수정 실행*/
	$(document).on("click", "#reed_sub_"+rev_no, function(){
		var rev_star = $('#rev_star_'+rev_no).val();
		var rev_con = $('#rev_con_'+rev_no).val();
			
		/*후기수정 유효성검사*/
		if($("#rev_con_"+rev_no).val() == "") {
			alert("후기를 입력하세요");
			$("#rev_con").focus();
			return false;
		}
		if($("#rev_star_"+rev_no).val() == 0) {
			alert("평점을 입력하세요");
			$("#rev_star").focus();
			return false;
		}
		
		
		$.ajax({
			type: "POST",
			url: "/glampingYW/updatereview",
			data: {"rev_no":rev_no, "rev_star":rev_star, "rev_con":rev_con},
			success: function(data) {
				if(data == 1){
					alert("후기를 수정하였습니다!");
					location.reload();
				} else {
					alert("후기수정 실패");
				}
			},
			error: function() {
				alert("후기수정 실패");
				location.reload();
			}
	
		});	
				
	});
			
}	

/*후기삭제*/
function delrevno(event) {
	var rev_no = event.target.value;	
	if(!confirm('후기를 삭제하실래요?')){
		return false;
	} else {
		$.ajax({
			type: "POST",
			url: "/glampingYW/delreview",
			data: {"rev_no":rev_no},
			success: function(data) {
				if(data == 1){
					alert("후기를 삭제하였습니다!");
					location.reload();
				} else {
					alert("후기삭제 실패");
				}
			},
			error: function() {
				alert("후기삭제 실패");
				location.reload();
			}
	
		});			
	}
}
	


