$(document).ready(function() {


	// 유효성 검사(product)
	$("form").submit(function() {

		if ($("#res_name").val() == "") {
			alert("예약자명을 입력하세요");
			$("#res_name").focus();
			return false;
		}

		if ($("#res_p1").val() == "") {
			alert("연락처 첫째자리를 입력하세요");
			$("#res_p1").focus();
			return false;
		}
		if (isNaN($("#res_p1").val())) {
			alert("연락처 첫째자리 숫자만 입력 가능합니다");
			$("#res_p1").val("").focus();
			return false;
		}
		if ($("#res_p2").val() == "") {
			alert("연락처 둘째자리를 입력하세요");
			$("#res_p2").focus();
			return false;
		}
		if (isNaN($("#res_p2").val())) {
			alert("연락처 둘째자리 숫자만 입력 가능합니다");
			$("#res_p2").val("").focus();
			return false;
		}
		if ($("#res_p3").val() == "") {
			alert("연락처 셋째자리를 입력하세요");
			$("#res_p3").focus();
			return false;
		}
		if (isNaN($("#res_p3").val())) {
			alert("연락처 셋째자리 숫자만 입력 가능합니다");
			$("#res_p3").val("").focus();
			return false;
		}


	

	});




}); // ready end




