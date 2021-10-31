
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
		onClose: function( selectedDate ) {
			var sdate = new Date(selectedDate);
			sdate.setDate(sdate.getDate()+1);
			$("#checkOut").datepicker( "option", "minDate", sdate );
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
		onClose: function( selectedDate ) {
			$("#checkIn").datepicker( "option", "maxDate", selectedDate );
		}
	});
	
	// 체크인 체크아웃 유효성
	$('form').submit(function(){
		if($("#checkOut").val() != "" && $("#checkIn").val() == ""){
			alert("체크인 날짜를 선택해주세요");
			return false;
		}
		if($("#checkIn").val() != "" && $("#checkOut").val() == ""){
			alert("체크아웃 날짜를 선택해주세요");
			return false;
		}
	});
	
});

/*무한 스크롤*/
$(function() {
	
	let page = 2;
	let pCount = $("#pageCount").val();
	
	let win = $(window);
 
    win.scroll(function() {
        if ($(document).height() - win.height() == win.scrollTop()) {
        	
        	 $.ajax({
                url: '/glamping/fetchprolist',
                data: {"pageNum" : page,
				"regionS" : $("#regionS").val(),
				"checkInS" : $("#checkIn").val(),
				"checkOutS" : $("#checkOut").val(),
				"capS" : $("#capS").val(),
				"keyword" : $("#keyword").val()},
				method: "POST", 
                dataType: 'html',
                success: function(html) {
                    $('#fetchMore').append(html);
                }
            });
			page++;
			sleep(200);
        }
        
    });
    
	if(pCount <= page){
		return false;
	}

});

/*지연*/
function sleep(ms) {
	const wakeUpTime = Date.now() + ms;
	while (Date.now() < wakeUpTime) {}
}
	
