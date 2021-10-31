/*datepicker*/
$(function() {
	
	


	$("#checkIn").datepicker({
		dateFormat: 'yy-mm-dd',
		minDate: 0,
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		showMonthAfterYear: true,
		yearSuffix: '년',
		beforeShowDay: IndisableAllTheseDays,
		onClose: function(selectedDate) {
			var sdate = new Date(selectedDate);
			sdate.setDate(sdate.getDate() + 1);
			$("#checkOut").datepicker("option", "minDate", sdate);
		}
	});

	$("#checkOut").datepicker({
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		showMonthAfterYear: true,
		yearSuffix: '년',
		beforeShowDay: OutdisableAllTheseDays,
		onClose: function(selectedDate) {
			$("#checkIn").datepicker("option", "maxDate", selectedDate);
		}
	});
	
	//예약된 날짜 선택막기(ckin)				
	function IndisableAllTheseDays(date) {
		
		var disabledDays = [];
		var jcount = document.getElementById('jcount').value;
		for(var i=0; i<jcount; i++){
			var cktime = document.getElementById('cktime_'+i).value;

			var monthNo = cktime.indexOf('-0');
			var dayNo = cktime.indexOf('-0', 6);
			
			console.log(i);
			// month, day 모두 앞자리 0인경우 monthNo = 4 dayNo = 7
			if((monthNo == 4) && (dayNo == 7)){
				cktime = cktime.substring(0, 5) + cktime.substring(6, 8) + cktime.substring(9, 10);
				console.log(cktime);
			}
			// month 앞자리만 0인경우 monthNo = 4 dayNo = -1
			if((monthNo == 4) && (dayNo == -1)){
				cktime = cktime.substring(0, 5) + cktime.substring(6, 10);
				console.log(cktime);
			}
			// day 앞자리만 0인경우 monthNo = 7 dayNo = 7
			if((monthNo == 7) && (dayNo == 7)){
				cktime = cktime.substring(0, 8) + cktime.substring(9, 10);
				console.log(cktime);
			}
			// month, day 모두 앞자리 0이 X경우 monthNo = -1 dayNo = -1
			if((monthNo == -1) && (dayNo == -1)){
				console.log(cktime);
			}
			

			
			disabledDays.push(cktime);
		}
						
	    var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
	    for (i = 0; i < disabledDays.length; i++) {
	        if($.inArray(y + '-' +(m+1) + '-' + d,disabledDays) != -1) {
	            return [false];
	        }
	    }
	    return [true];
	}
	
	//예약된 날짜 선택막기(ckout)
	function OutdisableAllTheseDays(date) {
		
		var disabledDays = [];
		var jcount = document.getElementById('jcount').value;
		for(var i=0; i<jcount; i++){
			var cktimeout = document.getElementById('cktimeout_'+i).value;
			
			var monthNo = cktimeout.indexOf('-0');
			var dayNo = cktimeout.indexOf('-0', 6);
			
			console.log(i);
			// month, day 모두 앞자리 0인경우 monthNo = 4 dayNo = 7
			if((monthNo == 4) && (dayNo == 7)){
				cktimeout = cktimeout.substring(0, 5) + cktimeout.substring(6, 8) + cktimeout.substring(9, 10);
				console.log(cktimeout);
			}
			// month 앞자리만 0인경우 monthNo = 4 dayNo = -1
			if((monthNo == 4) && (dayNo == -1)){
				cktimeout = cktimeout.substring(0, 5) + cktimeout.substring(6, 10);
				console.log(cktimeout);
			}
			// day 앞자리만 0인경우 monthNo = 7 dayNo = 7
			if((monthNo == 7) && (dayNo == 7)){
				cktimeout = cktimeout.substring(0, 8) + cktimeout.substring(9, 10);
				console.log(cktimeout);
			}
			// month, day 모두 앞자리 0이 X경우 monthNo = -1 dayNo = -1
			if((monthNo == -1) && (dayNo == -1)){
				console.log(cktimeout);
			}
			
			
			disabledDays.push(cktimeout);
		}
			
	    var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
	    for (i = 0; i < disabledDays.length; i++) {
	        if($.inArray(y + '-' +(m+1) + '-' + d,disabledDays) != -1) {
	            return [false];
	        }
	    }
	    return [true];
	}
	

	




	//일수 계산
	let start = $("#checkIn").datepicker('getDate');
	let end = $("#checkOut").datepicker('getDate');
	let days = (end - start) / 1000 / 60 / 60 / 24;
	let count = days + "박";


	if (days > 0) {
		$("#sel_count").text(count);
		$("#sel_count2").val(days);
	} else {
		$("#sel_count").text("1박");
		$("#sel_count2").val(1);
	}

	$("#checkOut").change(function() {
		
		if($("#checkIn").val() == ""){
			alert("체크인을 먼저 입력하세요")
			days = 0;
			$("#checkOut").val("");
			return false;
		}
		
		start = $("#checkIn").datepicker('getDate');
		end = $("#checkOut").datepicker('getDate');
		days = (end - start) / 1000 / 60 / 60 / 24;
		count = days + "박";

		var price = $("#sel_price").text().slice(0, -1);
		price = minusComma(price);
		price = parseInt(price);

		var cText = parseInt($("#sel_count").text());
		var setCm = (price / cText) * days;
		var setCm2 = (price / cText) * days;

		setCm = setCm + "";
		setCm = addComma(setCm) + "원";

		if (days > 0) {
			if ($("#sel_price").text() != "" && $("#sel_price").text() != null) {
				$("#sel_price").text(setCm);
				$("#res_price").val(setCm2);
			}

			$("#sel_count").text(count);
			$("#sel_count2").val(days);
		}
		
		
		var ckin = $("#checkIn").val();
		var ckout = $("#checkOut").val();
		var jcount = $("#jcount").val();
		for(var i=0; i<jcount; i++){
			var cktimeout = document.getElementById('cktimeout_'+i).value;	
			var Acktimeout = cktimeout.replace(/-/g,"") ;
			var Ackin = ckin.replace(/-/g,"") ;
			var Ackout = ckout.replace(/-/g,"") ;
			
						
			if((Acktimeout > Ackin) && (Acktimeout < Ackout)){
				alert("해당기간은 예약이 불가합니다!");
				$("#checkIn").val("");
				$("#checkOut").val("");
				return false;
			}

		}
		
		
	});

	$("#checkIn").change(function() {
		start = $("#checkIn").datepicker('getDate');
		end = $("#checkOut").datepicker('getDate');
		days = (end - start) / 1000 / 60 / 60 / 24;
		count = days + "박";

		var price = $("#sel_price").text().slice(0, -1);
		price = minusComma(price);
		price = parseInt(price);

		var cText = parseInt($("#sel_count").text());
		var setCm = (price / cText) * days;
		var setCm2 = (price / cText) * days;

		setCm = setCm + "";
		setCm = addComma(setCm) + "원";

		if (days > 0) {
			if ($("#sel_price").text() != "" && $("#sel_price").text() != null) {
				$("#sel_price").text(setCm);
				$("#res_price").val(setCm2);
			}
			$("#sel_count").text(count);
			$("#sel_count2").val(days);
		}
			
	});






	//인원선택시 제약사항 경고
	$("#capS").change(function() {

		var pnoval = $("#pno").val();
		var rnoval = $("#rno").val();
		var nototal = parseInt(pnoval) + parseInt(rnoval);
		var selectedval = $("#capS").val();

		if (selectedval > nototal) {
			alert("해당객실은 " + pnoval + "인실, 추가가능인원은 " + rnoval + "명입니다");
			$("#capS").val(pnoval);
		}

	});

	// 예약 유효성 검사
	$('form').submit(function() {
		if ($("#checkIn").val() == "") {
			alert("체크인 날짜를 선택해주세요");
			return false;
		}
		if ($("#checkOut").val() == "") {
			alert("체크아웃 날짜를 선택해주세요");
			return false;
		}
		if ($("#capS").val() == "0") {
			alert("인원 수를 선택해주세요");
			$("#capS").focus();
			return false;
		}
		if ($("input[name=rm_select]:radio:checked").length < 1) {
			alert("객실을 선택해주세요");
			return false;
		}
		var sel_id = $('#sessionid').val();
		if (sel_id == "") {
			alert("로그인 하셔야 예약가능합니다");
			return false;
		}
		
		//판매자 아이디는 예약금지
		var rtn = false;
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/idcheck_nonsel",
	        data: {"sel_id":sel_id},
			async:false,       
	        success: function (data) { 
	      	  if(data==1){	//판매자 ID
		     	alert("판매자 아이디로는 예약할 수 없습니다");
				rtn = true;
	      	  }  	  
	        }
	        ,
	    	  error:function(e){
	    	  }

	      });

		if (rtn) {
			return false;
		}
		
	});

	//예약창 스크롤
	$(window).scroll(function() {
		var scrollTop = $(document).scrollTop();
		if (scrollTop < 140) {
			scrollTop = 140;
		}
		$("#reserv").stop();
		$("#reserv").animate({ "top": scrollTop });
	});

	
	/*데이터시험*/
/*	$("#dtest").click(function() {
		var jcount = document.getElementById('jcount').value;
		
		for(var i=0; i<jcount; i++){
		var cktime = document.getElementById('cktime_'+i).value;
		var cktimeout = document.getElementById('cktimeout_'+i).value;
		alert("체크인불가" + cktime);
		alert("체크아웃불가" + cktimeout);
		}
		alert(jcount);
		console.log(jcount);
	});*/

})

// 가격 정보 출력
function getRmInfo(event) {
	$("#capS").val(0);

	var i = event.target.value;
	var setN = 'set_name_' + i;
	var setP = 'set_price_' + i;
	var setPno = 'set_pno_' + i;
	var setRno = 'set_rno_' + i;
	var setrmno = 'set_rmno_' + i;

	document.getElementById('sel_nm').innerText =
		document.getElementById(setN).innerText;

	document.getElementById('tname').value =
		document.getElementById(setN).innerText;

	document.getElementById('pno').value =
		document.getElementById(setPno).innerText;

	document.getElementById('rno').value =
		document.getElementById(setRno).innerText;

	document.getElementById('rmno').value =
		document.getElementById(setrmno).innerText;

	var price = (document.getElementById(setP).innerText) * (document.getElementById('sel_count').innerText).slice(0, -1);

	price = price + "";
	price = addComma(price);

	document.getElementById('sel_price').innerText = price + "원";

	var price2 = (document.getElementById(setP).innerText) * (document.getElementById('sel_count').innerText).slice(0, -1);
	document.getElementById('res_price').value = price2;

	$("#checkIn").val("");
	$("#checkOut").val("");


	//rm_no으로 해당객실에 이미 예약된 날짜 구해오기
	var rm_no = i;
	$.ajax({
		type: "POST",
		url: "/glampingYW/getreslist",
		data: { "rm_no": rm_no },
		dataType: "json",
		success: function(data) {
			output = '';
			var j = 0;
			$.each(data, function() {
				output += '<input type="hidden" style="color:red;" id="cktime_' + j + '" value="' + this.cktime + '">';					 				 
				output += '<input type="hidden" style="color:blue;" id="cktimeout_' + j + '" value="' + this.cktimeout + '">';					 				 
				j++;
			});
			output += '<input type="hidden" id="jcount" value="' + j + '">';
			document.getElementById('chday').innerHTML = output;
		},
		error: function() {
			alert("request error!");
		}

	});



}





//천단위 콤마 펑션
function addComma(value) {
	value = value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	return value;
}

function minusComma(value) {
	value = value.replace(/[^\d]+/g, "");
	return value;
}




