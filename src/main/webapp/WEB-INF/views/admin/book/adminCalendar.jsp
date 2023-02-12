<%@page import="org.springframework.util.StringUtils"%>
<%@page
	import="org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Strings"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.sinnotech.hotel.dto.BookingsDTO"%>
<%@page import="java.util.ArrayList"%>
<link href='${contextpath}/resources/lib/fullcalendar/fullcalendar.css'
	rel='stylesheet' />
<script src='${contextpath}/resources/lib/fullcalendar/fullcalendar.js'></script>
<title>Calendar</title>
<style>
.adminCalendar {
	display: flex;
	justify-content: center;
	background-color: inherit;
	width: 100%;
	background-color: inherit;
}

.screen {
	display: flex;
	justify-content: center;
	align-items: center;
	position: absolute;
	width: 100%;
	height: 100%;
	z-index: 100;
}

.screen:before {
	position: absolute;
	z-index: 99;
	top:-6%;
	left: 0;
	height: 103%;
	width: 100%;
	content: "";
	opacity: 0.5;
	background-color: gray;
}
.screenBox {
	position: relative;
	z-index: 101;
	height: 50%;
	width: 50%;
}
.screenBox:before {
	position: absolute;
	z-index: 0;
	top: 0;
	left: 0;
	z-index: 100;
	height: 100%;
	content: "";
	background-color: white;
	width: 100%;
	height: 100%;
}

.screenTextBox {
	position: absolute;
	display: flex;
	justify-content: flex-start;
	flex-direction: column;
	align-items: flex-end;
	z-index: 102;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	font-size: 20px;
	border: 1rem solid gray;
	z-index: 102;
}

.screenImgBox {
	height: 100%;
	display: inline-block;
	position: absolute;
	width: 100%;
	z-index: 102;
}

.screenImgBox .img img {
	position: absolute;
	top: 6%;
	left: 5%;
	max-height: 40%;
	max-width: 50%
}

.screenImgBox .roomInfo {
	position: absolute;
	bottom: 15%;
	left: 5%;
	overflow: hidden;
	width: 50%;
	height: 30%;
}

.screenButtonBox {
	z-index: 102;
	position: absolute;
	display: flex !important;
	flex-direction: row;
	justify-content: flex-end;
	top: 80%;
	right: 5%;
	width: 100%;
}

@media all and (max-width: 2000px) {
	.screenButtonBox {
		z-index: 102;
		position: absolute;
		display: flex !important;
		flex-direction: column;
		justify-content: flex-start;
		align-items:flex-end;
		top: 70%;
		right: 5%;
		width: 100%;
	}
	.screenButtonBox input {
		right:0;
		width: 150px;
	}
}

.conMain {
	display: none;
	position: fixed;
	z-index: 999;
}

.con {
	top: 0;
	left: 50px;
	position: absolute;
	z-index: 999 !important;
}

.conInner {
	z-index: 999 !important;
	position: absolute;
	min-height: 150px;
	min-width: 200px;
	opacity: 1;
	content: "";
	border: 1rem solid gray;
	padding: 5px;
	left: 0;
	background-color: white;
}

#calendar {
	align-self: center;
	width: 80%;
	max-height: 800px;
	min-height: 800px;
}
</style>
<c:if test="${bookingDates != null }">
	<%
	ArrayList<BookingsDTO> bookList = (ArrayList<BookingsDTO>) request.getAttribute("bookingDates");
	%>
	<script type="text/javascript">
var images = null;
var roomInfo	 = null;
var id = null;
var room_info = null;
var userName = null;
var roomName = null;
var price = null;
var payFlag = null;
var startDate = null;
var endDate = null;

document.addEventListener('DOMContentLoaded', function() {
	var innerThis;
	var outerThis;
	
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl,
		{
			initialView : 'dayGridMonth',
			locale: 'ja',
			selectable: true,
			headerToolbar : {
			center : 'addEventButton'
			}, events : [
				<%for (BookingsDTO bookInfo : bookList) {
	String color = "blue", textColor = "black", title = "";
	title = Integer.toString(bookInfo.getId());
	title = title + ", " + bookInfo.getUserName();
	if (bookInfo.isDeleteFlag()) {
		title = title + "-Deleted";
		color = "red";
		textColor = "gray";
	} else if (bookInfo.isCancelFlag()) {
		title = title + "-Cancelled";
		color = "orange";
		textColor = "black";
	} else if (bookInfo.isPayFlag()) {
		title = title + "-Payed";
		color = "yellow";
		textColor = "orange";
	}

	if (!bookList.isEmpty()) {%>
		{
			title : '<%=title%>',
			start : '<%=bookInfo.getStartDate()%>',
			end : '<%=bookInfo.getEndDate()%>',
			color : '<%=color%>', 
			textColor : '<%=textColor%>' 
		},
		<%} else {%>
		{
			title : '<%=title%>',
			start : '<%=bookInfo.getStartDate()%>',
			end : '<%=bookInfo.getEndDate()%>',
			color : '<%=color%>',
			textColor : '<%=textColor%>' 
		},
		<%}
}%>  
		]
	});
	calendar.render();
	calendarInit();
	
	function calendarInit(){
		$('#calendar').find('.fc-daygrid-day').each(function(index, element) {
			$(this).css("position", "relative");
		})
		$('#calendar').find('.fc-event-main').each( function( index, element ) {
			outerThis = $(this);
			eachOuter(outerThis);
		})
	}

	$(".fc-next-button").click(function() {
		calendarInit();
	});
	
  	$(".fc-prev-button").click(function() {
  		calendarInit();
   	});
	
	function eachOuter(outerThis){
		$(".fc-daygrid-day-frame").css("z-index",0);
		outerThis.find(".fc-event-main-frame").append($(".conMain").html());
		outerThis.hover(()=>{
			outerThis.parents('.fc-daygrid-day').css('z-index','999')
			aJaxMethod(outerThis);
			outerThis.click(function () {
				outerThisClick();
			})
		}, 
			()=> {
				outerThis.parents('.fc-daygrid-day').css('z-index','0')
				outerThis.parent().parent().css('z-index','0');
				outerThis.find(".con").css("visibility", "hidden");
		})
	};
	
	function aJaxMethod(innerThis){
		var bookID = innerThis.find(".fc-event-title").text().split(",")[0];
		var date = innerThis.closest(".fc-daygrid-day").attr("data-date");
		innerThis.parent().parent().css('z-index','999');
		$.ajax({
			type:'GET',
			url:'calendarSelect',
			data : {id : bookID},
			dataType:'json',
			async:false
		})
		.done(function(data){
			images = data.images;
			roomInfo = data.roomInfo;
			id = data.id;
			userName = data.userName;
			roomName = data.roomName;
			price = data.priceForView;
			payFlag = data.payFlag;
			startDate = data.startDate;
			endDate = data.endDate;
			innerThis.find("img").attr( "src" , "/resources/img/"+images);
			innerThis.find(".con .id").text("No. : " + id);
			innerThis.find(".con .userName").text("고객 : " + userName);
			innerThis.find(".con .roomName").text("방이름 : " + roomName);
			innerThis.find(".con .price").text("가격 : " + price);
			var payStatus = "";
			if(data.payFlag == true){
				payFlag = "지불";
			} else {
				payFlag = "미지불";
			}
			innerThis.find(".con .payFlag").text("결제여부 : " + payFlag);
			innerThis.find(".con .startDate").text("체크인 : " + startDate);
			innerThis.find(".con .endDate").text("체크아웃 : " + endDate);
		   	innerThis.find(".con").css("visibility", "visible");
		})
		.fail(function(error){
		})
	}
	
});
function outerThisClick(){
	$(".screen .screenBox .screenImgBox .img img").attr( "src" , "/resources/img/"+images);
	$(".screen .screenBox .screenImgBox .roomInfo").text(roomInfo);
	$(".screen .screenBox .screenTextBox .id").text("No. : " + id);
	$(".screen .screenBox .screenTextBox .userName").text("고객 : " + userName);
	$(".screen .screenBox .screenTextBox .roomName").text("방이름 : " + roomName);
	$(".screen .screenBox .screenTextBox .price").text("가격 : " + price);
	$(".screen .screenBox .screenTextBox .payFlag").text("결제여부 : " + payFlag);
	$(".screen .screenBox .screenTextBox .startDate").text("체크인 : " + startDate);
	$(".screen .screenBox .screenTextBox .endDate").text("체크아웃 : " + endDate);
	$(".screen .screenBox .screenButtonBox .detail").attr('onclick', "location.href='/admin/book/detail/"+ id +"'"); 
	$(".screen").css("visibility", "visible");
};
function removeScreeen(){
	 $(".screen").css("visibility", "hidden");
}
</script>
</c:if>

<div class="adminCalendar">
	<div class="screen" style="visibility: hidden;">
		<div class="screenBox">
			<div class="screenImgBox">
				<div class="img">
					<img />
				</div>
				<div class="roomInfo fw-bold fs-6"></div>
			</div>
			<div class="screenTextBox">
				<div class="id fw-bold"></div>
				<div class="userName"></div>
				<div class="roomName"></div>
				<div class="price"></div>
				<div class="payFlag"></div>
				<div class="startDate"></div>
				<div class="endDate"></div>
			</div>
			<div class="screenButtonBox d-grid gap-3">
				<input class="detail btn btn-primary" type="button" value="상세정보"><input
					type="button" class="btn btn-secondary" value="뒤로가기" onclick="removeScreeen()">
			</div>
		</div>
	</div>
	<div class="conMain" style="display: none;">
		<div class="con" style="visibility: hidden;">
			<div class="conInner">
				<div class="img">
					<img style="max-height: 50px; max-width: 100px;" />
				</div>
				<div class="id fw-bold"></div>
				<div class="userName"></div>
				<div class="roomName"></div>
				<div class="price"></div>
				<div class="payFlag"></div>
				<div class="startDate"></div>
				<div class="endDate"></div>
			</div>
		</div>
	</div>
	<div id='calendar'></div>
</div>