
function roomdetail(rm_no){
	var roomdetail = "roomdetail?rm_no="+rm_no
	window.open(roomdetail ,"아무이름","width=450,height=350,resizable=no");
}

function stop_sales(rm_no) {
	if(!confirm('해당객실실 영업을 중지합니까?')){
		return false;
	} else {
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/stop_sales",
	        data: {"rm_no":rm_no},      
	        success: function (data) { 
	      	  if(data==1){	
		     	location.reload();
	      	  }  	  
	        }
	        ,
	    	  error:function(e){
	    	  }

	      });

	
	}
}

function restart_sales(rm_no) {
	if(!confirm('해당객실 영업을 재개합니까?')){
		return false;
	} else {
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/restart_sales",
	        data: {"rm_no":rm_no},      
	        success: function (data) { 
	      	  if(data==1){	
		     	location.reload();
	      	  }  	  
	        }
	        ,
	    	  error:function(e){
	    	  }

	      });

	
	}
}


function delr(rm_no) {
	if(!confirm('객실을 삭제하실래요?')){
		return false;
	} else {
		location.href = "rmdelete?rm_no="+rm_no;
	}
}



function re_submit(pro_no) {
	if(!confirm('상품신청을 다시 합니다. 상품정보를 수정하셧나요?')){
		return false;
	} else {
		location.href = "resubmitpro?pro_no="+pro_no;
	}
}

$(function(){
	$("#show_form").hide();
	
	$('#show_delform').click(function() {
		$("#show_form").show();
		 
	});
	 
	$('#hide_form').click(function() {
		$("#show_form").hide();

	});
	
	$('#selpassact').click(function() {
		
	var sel_id = $('#sel_id').val();
	var sel_pw = $('#sel_pass').val();
	var pro_no = $('#pro_no').val();
	
		if($('#sel_pass').val() == ""){
			alert("비밀번호를 입력하세요");
			$("#sel_pass").focus();
			return false;		
		}
		
	    $.ajax({
	        type:"POST",
	        url:"/glampingYW/delbefore",
	        data: {"sel_id":sel_id, "sel_pw":sel_pw},      
	        success: function (data) { 
	      	  if(data==1){	
		     	location.href = "prodelete?pro_no="+pro_no;				
	      	  } else {
				alert("비밀번호가 틀렸습니다");
				$("#sel_pass").val("");
				$("#sel_pass").focus();
				return false;
				} 	  
	        }
	        ,
	    	  error:function(e){
				alert("error");
	    	  }

	      });
	
	});
});
