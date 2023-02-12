<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<link rel="stylesheet" href="${contextpath}/resources/css/roomInfoCSS.css" />

<div class="container">
	<div class="titleUpdate">객실 관리 리스트</div>
	<div style="width: 75%;" align="right">
		<button onclick="location.href='/admin/room/insert'">객실추가</button>
	</div>
	<div>
		<div style="text-align: center">
			<c:forEach var="dto" items="${roomInfoList}">
			<div>
				<div style="text-align: right; width:50%; height:1px; display: inline-block;">${dto.images }</div>
				<div style="text-align: left; width:50%; display: inline-block;">
					<%-- ${dto.id } --%>
					<div>
						<div class="midName">객&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;실 : 
						&nbsp;&nbsp;<a href="detail/${dto.id }">${dto.room_name }호</a>
						</div>
					</div>
					<br/>
					<div>
						<div class="midName">최대 &nbsp;&nbsp;&nbsp;인원 : &nbsp;&nbsp;${dto.max_count }&nbsp;명</div>
					</div>
					<br>
					<div>
						<div class="midName">시설 &nbsp;&nbsp;&nbsp;정보 : &nbsp;&nbsp;${dto.info }</div>
					</div>
					<br>
					<div>
						<div class="midName">방 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;옵션 : &nbsp;&nbsp;${dto.options }</div>
					</div>
					<br>
					<div>
						<div class="midName">1박 &nbsp;&nbsp;&nbsp; 가격 : &nbsp;&nbsp;${dto.price }</div>
					</div>
					<%-- ${dto.delete_flag } --%>
					<br> <br>
					<div>
						<div style="width: 75%;" algin="right">
							<button onclick="location.href='/admin/book/list/${dto.id }'">예약관리</button>
							<button onclick="location.href='/admin/room/update/${dto.id }'">객실수정</button>
							<button onclick="location.href='/admin/room/delete/${dto.id }'">객실삭제</button>
						</div>
					</div>
					<br> <br>
				</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
