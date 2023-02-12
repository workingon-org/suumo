<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${contextpath}/resources/css/adminNotice.css" />
<script src="/resources/js/adminNotice.js"></script>

<h4 style="text-align: center" class="notice_title">${notice.title }</h4>
<div class="container" style="margin-bottom: 50px;">
	<div style="width: 60%; margin: auto;">
		<form style="border-top: 2px solid black;" id="form" role="form" method="get" action="/admin/notice/update/${notice.id }">
			<div style="width: 100%; border-bottom: solid 1px gray">
				<div style="line-height: 30px; width: 20%; float: left; height: 36px; font-weight: bold; background-color: #eeeeee; text-align: center; padding-top: 5px;">TITLE</div>

				<div style="margin-left: 20%; height: 36px; width: 100%;">

					<input type="text" style="width: 80%; height: 36px; border: none; margin-left: 1px;" name="title" class="readonly_input" value="${notice.title }" readonly>

				</div>
			</div>
			<div style="width: 100%;">
				<div style="line-height: 39px; width: 20%; float: left; height: 35px; font-weight: bold; background-color: #eeeeee; text-align: center;">작성일</div>
				<div style="line-height: 39px; width: 27%; float: left; margin-right: 0px; height: 35px; font-size: 14px; background-color: white; padding-left: 20px; text-align: left;" class="readonly_input">
					<fmt:formatDate pattern="yyyy-MM-dd" value="${notice.createdAt }" />
				</div>
				<div style="line-height: 39px; width: 20%; float: left; height: 35px; font-weight: bold; background-color: #eeeeee; text-align: center;">게시기간</div>
				<div style="line-height: 39px; width: 27%; float: left; height: 35px; font-size: 14px; background-color: white; padding-left: 20px;">
					<input type="text" style="width: 80%; height: 86%; border: none; margin-top: 2px;" name="title" value="${notice.endDate }" readonly>

				</div>

			</div>
			<div>
				<textarea class="readonly_input" style="width: 100%; height: 400px; padding-top: 30px; border: none; border-top: 1px solid gray; border-bottom: 2px solid black" rows="5" name="content" readonly>${notice.content }</textarea>
			</div>
			<div style="height: 40px; margin-top: 20px;">
				<button type="button" class="btn_style" id="btnList" onclick="location.href='/admin/notice/list'">취소</button>
				<button type="button" class="btn_style" id="btnDelete" onclick="location.href='/admin/notice/delete/${notice.id}'" id="delete" name="delete">삭제</button>
				<button type="submit" class="btn_style" id="btnSave">수정</button>
			</div>
		</form>
	</div>
</div>