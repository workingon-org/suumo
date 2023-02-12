<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<link rel="stylesheet" href="${contextpath}/resources/css/roomInfoCSS.css" />

<div class="container">
	<div>
		<div>
			<div style="width: 75%;" align="right"><button onclick="history.back()">돌아가기</button></div>
		</div>
	</div>
	<div>
		<div>
			<div class="titleDetail">
				${roomInfoDetail.room_name }호 상세 정보
			</div>
			<br>
			<div colspan="7">
				${roomInfoDetail.images }
			</div>
			<br>
				<%-- ${roomInfoDetail.id } --%>
			<div>
				<div class="midNameDetail">객&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;실 :&nbsp;&nbsp;${roomInfoDetail.room_name }호</div>
			</div>
			<br/>
			<div>
				<div class="midNameDetail">최대 &nbsp;&nbsp;&nbsp;인원 : &nbsp;&nbsp;${roomInfoDetail.max_count }&nbsp;명</div>
			</div>
			<br>
			<div>
				<div class="midNameDetail">시설 &nbsp;&nbsp;&nbsp;정보 : &nbsp;&nbsp;${roomInfoDetail.info }</div>
			</div>
			<br>
			<div>
				<div class="midNameDetail">방 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;옵션 : &nbsp;&nbsp;${roomInfoDetail.options }</div>
			</div>
			<br>
			<div>
				<div class="midNameDetail">1박 &nbsp;&nbsp;&nbsp; 가격 : &nbsp;&nbsp;${roomInfoDetail.price }</div>
			</div>
				<%-- ${roomInfoDetail.delete_flag } --%>
			<br>
			<div class="midNameDetail">
				생성 &nbsp;&nbsp;&nbsp;일자 : &nbsp;&nbsp;<fmt:formatDate value="${roomInfoDetail.created_at}" type="both"/>
			</div>
			<br>
			<div class="midNameDetail">
				수정 &nbsp;&nbsp;&nbsp;일자 : &nbsp;&nbsp;<fmt:formatDate value="${roomInfoDetail.updated_at}" type="both"/>
			</div>
			<br><br>
			<div>
				<div style="width: 75%; text-align: right;">
				<button onclick="location.href='/admin/book/detail/${roomInfoDetail.id }'">예약관리</button>
				<button onclick="location.href='/admin/room/update/${roomInfoDetail.id }'">객실수정</button>
				<button onclick="location.href='/admin/room/delete/${roomInfoDetail.id }'">객실삭제</button>
				</div>
			</div>
			<br><br>
		</div>
	</div>
</div>