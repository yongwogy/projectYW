$(function(){
    var today = new Date();
    var date = new Date();           

    $("#preMon").click(function() { // 이전달
        $("#calendar > tbody > td").remove();
        $("#calendar > tbody > tr").remove();
        today = new Date ( today.getFullYear(), today.getMonth()-1, today.getDate());
        buildCalendar();
    });
    
    $("#nextMon").click(function(){ //다음달
        $("#calendar > tbody > td").remove();
        $("#calendar > tbody > tr").remove();
        today = new Date ( today.getFullYear(), today.getMonth()+1, today.getDate());
        buildCalendar();
    });


    function buildCalendar() {
        
		var pro_no = $('#pro_no').val();
		var thisYear = today.getFullYear();
		var thisMonth = today.getMonth()+1;
		var thisdays = today.getDate();

				
		//resday가 포함된 rmlist불러오기
		$.ajax({
			type: "POST",
			url: "/glampingYW/getrmresday",
			data: { "pro_no": pro_no},
			dataType: "json",
			success: function(data) {
				
		        nowYear = today.getFullYear();
		        nowMonth = today.getMonth();
		        firstDate = new Date(nowYear,nowMonth,1).getDate();
		        firstDay = new Date(nowYear,nowMonth,1).getDay(); //1st의 요일
		        lastDate = new Date(nowYear,nowMonth+1,0).getDate();
		
		        if((nowYear%4===0 && nowYear % 100 !==0) || nowYear%400===0) { //윤년 적용
		            lastDate[1]=29;
		        }
		
		        $(".year_mon").text(nowYear+"년 "+(nowMonth+1)+"월");
		
		        for (i=0; i<firstDay; i++) { //첫번째 줄 빈칸
		            $("#calendar tbody:last").append('<td class="tdx"></td>');
		        }
		
		
		        for (i=1; i <=lastDate; i++){ // 날짜 채우기
					
		            plusDate = new Date(nowYear,nowMonth,i).getDay();
		            if (plusDate==0) {
		                $("#calendar tbody:last").append("<tr></tr>");
		            }		
					var contime = (thisYear+ "-" +thisMonth+ "-" +i);								
					var output = '';
					output += '<td class="tdy">';
					output += '<div class="date" hidden="hidden">' + i + '</div>'
					output += '<div class="datefont">' + i + '일' + '</div>'								
					$.each(data, function() {	
						var n = 0;						
					for(var j=0; j<this.iplus; j++){
						if(contime == this.res_ckin[j]){
						output += '<div>' + '<span class="res_red" onclick="resdetail(' + this.res_no[j] + ')">' + this.rm_tname + '</span>';						
						output += '<span class="red_con">' + '완' + '</span>' + '</div>';						
						output += '<input type="hidden" id="res_no" value="' + this.res_no[j] + '">';
						output += '<input type="hidden" id="res_ckin" value="' + this.res_ckin[j] + '">';
						n++;
						}
					}
					if(n == 0){
						if(this.rm_s == 1) {
							output += '<div>' + '<span class="res_green">' + this.rm_tname + '</span>';	
							output += '<span class="green_con">' + '가' + '</span>' + '</div>';	
						}
						if(this.rm_s == 0) {
							output += '<div>' + '<span class="res_grey">' + this.rm_tname + '</span>';	
							output += '<span class="grey_con">' + '중' + '</span>' + '</div>';	
						}
						
					}
					});				
					output += '</td>';
							
		            $("#calendar tbody:last").append(output);
		  	    }
		
		
		        if($("#calendar > tbody > td").length%7!=0) { //마지막 줄 빈칸
		            for(i=1; i<= $("#calendar > tbody > td").length%7; i++) {
		                $("#calendar tbody:last").append('<td class="tdx"></td>');
		            }
		        }
		        $(".date").each(function(index){ // 오늘 날짜 표시
		            if(nowYear==date.getFullYear() && nowMonth==date.getMonth() && $(".date").eq(index).text()==date.getDate()) {
		                $(".tdy").eq(index).addClass('colToday');
		            }
		        }); 


			},
			error: function() {	
				alert("ajax error");		
			}
	
		});


    }

    buildCalendar();
	

});

//날짜 및 객실당 에약 자세히 보기 창
function resdetail(res_no){
	var resdetail = "resdetail?res_no="+res_no
	window.open(resdetail ,"아무이름","width=900,height=280,resizable=no");
}

function show_delres(pro_no){
	var show_delres = "show_delres?pro_no="+pro_no
	window.open(show_delres ,"아무이름","width=900,height=280,resizable=no");
}
