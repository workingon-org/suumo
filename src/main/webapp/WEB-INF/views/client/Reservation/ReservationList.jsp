<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date today = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String now = simpleDateFormat.format(today);
 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 예약 : 날짜, 인원 선택</title>
<link rel="stylesheet" href="resources/css/reserveCSS.css">
	<style>
		#btn{
			margin-top:15px;
			margin-bottom:15px;
			background-color: #382f24;
		    width:120px;
		    height:50px;
		    border: none;
		    font-size:medium;
		    color:#f1ebd5;
			}
	</style>
</head>
<body>
	
<br/><br />
	&nbsp;&nbsp;&nbsp; <font size = "20">객실예약</font><br />
	
		<table align="center" class="reservelist1">
			<tr id="list1">
				<td id="step1">날짜,인원 선택</td>
				<td id="step2">객실 선택</td>
				<td id="step3">옵션 선택</td>
			</tr>
		</table>
		
		<form action = "ReservationList2" method = "post" name = "regForm">
			<table width = "80%" align = "center" class = "reserve1">
				<tr align = "center" style = "color:#a0a0a0; font-weight:bold;">
					<td>체크인</td>
					<td>체크아웃</td>
					<td width = "10%">성인</td>
					<td width = "10%">어린이</td>
				</tr>
				<tr align = "center">
					<td><input type = "date" name = "checkin" min='<%=now %>' /></td>
					<td><input type = "date" name = "checkout" /></td>
					<td><input type = "number" name = "adults" min = "1" value = "1"/></td>
					<td><input type = "number" name = "kids" value = "0" min = "0" /></td>
					<td><input type = "submit" value = "검색" id = "btn"/></td>
				</tr>
			</table>
		</form>

		
		<br /><br /><br /><br /><br /><br /><br />
</body>
</html>