<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link href='${pageContext.request.contextPath }/css/calen.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/js/calen.js'></script>



	<table id="calendar" class="calentable">
		<span class="green_con">가</span>&nbsp<span>:예약가능</span>
		&nbsp&nbsp<span class="red_con">완</span>&nbsp<span>:예약완료</span>
		&nbsp&nbsp<span class="grey_con">중</span>&nbsp<span>:영업중지</span>
		&nbsp&nbsp<span><input type="button" class="bt_dels" value="예약취소 신청목록" onclick="show_delres('${pro_no}')"></span>
		&nbsp<span class="count_del_no">${del_no}개</span>
        <thead>
            <tr>
                <th colspan="2"class="monthmove1"><input id="preMon" class="monthmovebu" type="button" value="이전달"></th>
                <th colspan="3" class="year_mon"></th>
                <th colspan="2"class="monthmove2"><input id="nextMon" class="monthmovebu" type="button" value="다음달"></th>
            </tr>
            <tr>
                <th class="days">일</th>
                <th class="days">월</th>
                <th class="days">화</th>
                <th class="days">수</th>
                <th class="days">목</th>
                <th class="days">금</th>
                <th class="days">토</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
