<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
<title>Insert title here</title>
</head>
<body>
	<head>
		<meta charset="UTF-8">
		<title>객실 예약 : 날짜, 인원 선택</title>
		<link rel = "stylesheet" href = "resources/css/reserveCSS.css">
	<style>
		#btn{
			display: inline-block;
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
	
	<h1>객실예약</h1>
	<br/>
	
		<table align="center" class="reservelist1">
			<tr id="list1">
				<td id="step3"></td>
				<td id="step1">예약확인</td>
				<td id="step2"></td>
			</tr>
		</table>
		
	<form>
		<table width="80%" align="center" class="reserveOption">
			<tr height="15%">
				<th colspan="4" align="center"><font size="5">예약정보</font></th>
			</tr>
			<tr id="line">
				<td align="center" id="line"></td>
				<td colspan="3" id="line">
					<table width="100%">
						<tr align="left">	
							<td>
								예약 객실 : <b>${param.roomtype}</b>
								<input type="hidden" name="type" value="${param.roomtype}" />
							</td>
							<td>
								체크인날짜 : <b>${param.checkin }</b>
								<input type="hidden" name="checkin" value="${param.checkin}" />
							</td>
						</tr>
						<tr align="left">
							<td>체크아웃 날짜 : <b>${param.checkout }</b>
								<input type="hidden" name="checkout" value="${param.checkout }"/>
							</td>
							<td>
								성인 투숙객 수 : <b>${param.adults}</b>명
								<input type="hidden" name="adults"  value="${param.adults }"/>
							</td>
						</tr>
						<tr align="left">
							<td>아동 투숙객 수 : <b>${param.kids }</b>명
								<input type="hidden" name="kids" value="${param.kids }"/>
							</td>
							<td> 

							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center" style="font-weight:bold;" height="15%"><font size="5">옵션선택</font></td>
			</tr>
			<tr id="line">
				<td colspan="4" align="center" id="line">
					조식 인원 수 (1인당 20,000원) : <b>${param.option }</b>명
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="reset" id="btn" class="btn btn-outline-primary" value="홈으로" onclick="location.href='/'" />
				</td>
			</tr>
		</table>


	</form>
</body>
</html>