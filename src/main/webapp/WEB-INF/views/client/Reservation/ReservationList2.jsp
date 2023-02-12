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
<link rel = "stylesheet" href = "resources/css/reserveCSS.css">
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
				<td id="step2">날짜,인원 선택</td>
				<td id="step1">객실 선택</td>
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
					<td><input type = "date" name = "checkin" min = '<%=now %>' value = "${checkin}" /></td>
					<td><input type = "date" name = "checkout"  value = "${checkout }"/></td>
					<td><input type = "number" name = "adults" min = "1"  value = "${adults }"/></td>
					<td><input type = "number" name = "kids"  min = "0" value = "${kids }"/></td>
					<td><input type = "submit" value = "검색" id = "btn" /></td>
				</tr>
			</table>
		</form>
		<form action = "ReservationList3" method = "post" name = "regForm">
			<table width = "80%" align = "center" class = "reserveResult">
					<tr align = "center" id = "line">
						<td width = "30%" id = "line">
							<img  width="280" height="200">
						</td>
						<td width = "100%" id = "line">
							<table>
								<tr align="center">
									<th> Standand </th>
								</tr>
								<tr align="left">
									<td>침대수 :  </td>
								</tr>
								<tr align="left">
									<td>최대 수용 인원 : 명</td>
								</tr>
							</table>
						</td>
						<td width="25%" id="line"> </td>
						
						<td id="line"><input type = "submit" value = "예약하기" id = "btn" /></td>
				
					</tr>
			</table>
		<input type = "hidden" name = "roomtype" value = "Standand" />
		<input type = "hidden" name = "checkin" min = '<%=now %>' value = "${checkin}" />
		<input type = "hidden" name = "checkout"  value = "${checkout }"/>
		<input type = "hidden" name = "adults" value = "${adults }"/>
		<input type = "hidden" name = "kids" value = "${kids }"/>
		</form>
		<form action = "ReservationList3" method = "post" name = "regForm">
			<table width = "80%" align = "center" class = "reserveResult">
					<tr align = "center" id = "line">
						<td width = "30%" id = "line">
							<img  width="280" height="200" src="${contextpath}/resources/img/BIQUB-P0204-Deluxe-King-City-View.16x9.jpg">
						</td>
						<td width = "100%" id = "line" >
							<table>
								<tr align="center">
									<th>Deluxe </th>
								</tr>
								<tr align="left">
									<td>객실크기 : 30~33m²</td>
								</tr>
								<tr align="left">
									<td>최대 수용 인원 : 4 명</td>
								</tr>
							</table>
						</td>
						<td width="25%" id="line"> </td>
						
						<td id="line"><input type = "submit" value = "예약하기" id = "btn" /></td>
				
					</tr>
			</table>
			<input type = "hidden" name = "roomtype" value = "Deluxe" />
		<input type = "hidden" name = "checkin" min = '<%=now %>' value = "${checkin}" />
		<input type = "hidden" name = "checkout"  value = "${checkout }"/>
		<input type = "hidden" name = "adults" value = "${adults }"/>
		<input type = "hidden" name = "kids" value = "${kids }"/>
		</form>
		<form action = "ReservationList3" method = "post" name = "regForm">
			<table width = "80%" align = "center" class = "reserveResult">
					<tr align = "center" id = "line">
						<td width = "30%" id = "line">
							<img  width="280" height="200">
						</td>
						<td width = "100%" id = "line">
							<table>
								<tr align="center">
									<th>Suite </th>
								</tr>
								<tr align="left">
									<td>객실크기 : </td>
								</tr>
								<tr align="left">
									<td>최대 수용 인원 : 명</td>
								</tr>
							</table>
						</td>
						<td width="25%" id="line"> </td>
						
						<td id="line"><input type = "submit" value = "예약하기" id = "btn" /></td>
				
					</tr>
			</table>
			<input type = "hidden" name = "roomtype" value = "Suite" />
		<input type = "hidden" name = "checkin" min = '<%=now %>' value = "${checkin}" />
		<input type = "hidden" name = "checkout"  value = "${checkout }"/>
		<input type = "hidden" name = "adults" value = "${adults }"/>
		<input type = "hidden" name = "kids" value = "${kids }"/>
		</form>
				<form action = "ReservationList3" method = "post" name = "regForm">
			<table width = "80%" align = "center" class = "reserveResult">
					<tr align = "center" id = "line">
						<td width = "30%" id = "line">
							<img  width="280" height="200">
						</td>
						<td width = "100%" id = "line">
							<table>
								<tr align="center">
									<th>Royal </th>
								</tr>
								<tr align="left">
									<td>객실크기 : </td>
								</tr>
								<tr align="left">
									<td>최대 수용 인원 : 명</td>
								</tr>
							</table>
						</td>
						<td width="25%" id="line"> </td>
						
						<td id="line"><input type = "submit" value = "예약하기" id = "btn" /></td>
				
					</tr>
			</table>
			<input type = "hidden" name = "roomtype" value = "Royal" />
		<input type = "hidden" name = "checkin" min = '<%=now %>' value = "${checkin}" />
		<input type = "hidden" name = "checkout"  value = "${checkout }"/>
		<input type = "hidden" name = "adults" value = "${adults }"/>
		<input type = "hidden" name = "kids" value = "${kids }"/>
		</form>
		
		
		
		<br /><br /><br /><br /><br /><br /><br />
</body>
</html>