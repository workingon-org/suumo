<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 컨트롤러에서 받을 링크 이름 -->
<div class="container" style="text-align: center">
	<form action="realinsert" method="post" enctype="multipart/form-data">
		<div style="text-align: left; width:50%; display: inline-block;">
			<input type="hidden" name="id" value="${roomInfoDetail.id }">
			<br>
			<div class="midNameUpdate">
				객실 이름&nbsp; :&nbsp;
				<input type="text" id="room_name" name="room_name" value="객실 이름 입력">
			</div>
			<br>
			<div class="midNameUpdate">
				최대 인원&nbsp; :&nbsp;
				<input type="text" name="max_count" value="최대 인원 4명까지 입력">
			</div>
			<br>
			<div class="midNameUpdate">
				시설 정보&nbsp; :&nbsp;
				<textarea class="form-control" name="info" id="contents" required>시설 정보 입력</textarea>
			</div>
			<br>
			<div class="midNameUpdate">
				객실 옵션&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;
				<input type="text" name="options" value="객실 옵션">
			</div>
			<br>
			<div class="midNameUpdate">
				객실 사진(jpg,jpeg,png파일만 가능)
				<br>
				<input type="file" name="upload_file" accept=".jpg, .jpeg, .png" onchange="checkSize(this)">
			</div>
			<br>
			<div class="midNameUpdate">
				숙박 가격&nbsp; :&nbsp;
				<input type="text" name="price" value="숙박 가격(숫자만 입력)">
			</div>
			<div style="text-align: center;">
			<br><br>
				<button class="btn btn-secondary" type="submit">객실 등록</button>
				<button onclick="location.href='/admin/room/roominfolist'" class="btn btn-secondary" type="button">돌아가기</button>
			</div>
		</div>
	</form>
</div>