<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<link rel="stylesheet" href="${contextpath}/resources/css/roomInfoCSS.css" />

<!-- 컨트롤러에서 받을 링크 이름 -->
<div class="container" style="text-align: center">
	<form action="realupdate" method="post" enctype="multipart/form-data">
		<div style="text-align: left; width:50%; display: inline-block;">
			<div class="titleUpdate">방 정보 수정</div>
			<br>
			<input type="hidden" name="id" value="${roomInfoDetail.id }">
			<div class="midNameUpdate">
				객실 이름&nbsp; :&nbsp;
				<input type="text" name="room_name" value="${roomInfoDetail.room_name }">
			</div>
			<div class="midNameUpdate">
				최대 인원&nbsp; :&nbsp;
				<input type="text" name="max_count" value="${roomInfoDetail.max_count }">
			</div>
			<div class="midNameUpdate">
				시설 정보&nbsp; :&nbsp;
				<textarea class="form-control" name="info" id="contents" required>${roomInfoDetail.info }</textarea>
			</div>
			<div class="midNameUpdate">
				객실 옵션&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;
				<input type="text" name="options" value="${roomInfoDetail.options }">
			</div>
			<div class="midNameUpdate">
				사진 선택&nbsp; :&nbsp;
				<input type="file" name="upload_file" accept=".jpg, .jpeg, .png" onchange="checkSize(this)">
			</div>
			<div class="midNameUpdate">
				숙박 가격&nbsp; :&nbsp;
				<input type="text" name="price" value="${roomInfoDetail.price }">
			</div>
			<div style="text-align : center;">
				<button class="btn btn-secondary" type="submit">방 수정</button>
				<button onclick="location.href='/admin/room/detail/${roomInfoDetail.id }'" class="btn btn-secondary" type="button">돌아가기</button>
			</div>
		</div>
	</form>
</div>