
//일반회원 승인탈퇴
function appm(mem_id) {
	$.ajax({
		type: "POST",
		url: "/glampingYW/approvemember",
		data: { "mem_id": mem_id },
		success: function(data) {
			if (data == 1) {
				location.reload();
			}
		}
		,
		error: function(e) {
			alert("error");
		}

	});
}

function banm(mem_id) {
	$.ajax({
		type: "POST",
		url: "/glampingYW/banmember",
		data: { "mem_id": mem_id },
		success: function(data) {
			if (data == 1) {
				location.reload();
			}
		}
		,
		error: function(e) {
			alert("error");
		}

	});
}

//판매자회원 승인탈퇴
function apps(sel_id) {
	$.ajax({
		type: "POST",
		url: "/glampingYW/approveseller",
		data: { "sel_id": sel_id },
		success: function(data) {
			if (data == 1) {
				location.reload();
			}
		}
		,
		error: function(e) {
			alert("error");
		}

	});
}

function bans(sel_id) {
	$.ajax({
		type: "POST",
		url: "/glampingYW/banseller",
		data: { "sel_id": sel_id },
		success: function(data) {
			if (data == 1) {
				location.reload();
			}
		}
		,
		error: function(e) {
			alert("error");
		}

	});
}