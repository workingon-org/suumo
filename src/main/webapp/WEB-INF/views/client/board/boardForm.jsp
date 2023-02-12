<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${contextpath}/resources/css/board.css" />
<script src="/resources/js/board.js"></script>
<div>
	<br /> <br /> &nbsp;&nbsp;&nbsp;
	<h1 style="text-align: center">
		<font size="20">문의 게시판<br /></font>
	</h1>
	<form action="${form}" name="regForm" method="post">
		<table align="center" class="inquiryDetail">
			<c:choose>
				<c:when test="${not empty update}">
					<c:choose>
						<c:when test="${not empty board.name}">
							<tr>
								<td id="detail">NAME</td>
								<td><input type="text" name="name" maxlength="30"
									id="writeTitle" value="${board.name}" readonly /></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td id="detail">NAME</td>
								<td><input type="text" name="name" maxlength="30"
									id="writeTitle" value="" placeholder="작성자를 입력해주세요" /></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${not empty sessionScope.loginUserInfo.name}">
							<tr>
								<td id="detail">NAME</td>
								<td><input type="text" name="name" maxlength="30"
									id="writeTitle" value="${sessionScope.loginUserInfo.name}"
									readonly /></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td id="detail">NAME</td>
								<td><input type="text" name="name" maxlength="30"
									id="writeTitle" value="" placeholder="작성자를 입력해주세요" /></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			<tr>
				<td id="detail">TITLE</td>
				<td><input type="text" name="title" maxlength="30"
					id="writeTitle" value="${board.title}" placeholder="제목을 입력해주세요." />
				</td>
			</tr>
			<tr>
				<td id="detail">CONTENT</td>
				<td><textarea name="content" rows="5" cols="40" 
						id="writeContent" placeholder="내용을 입력해주세요.">${board.content}</textarea></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" id="btn"
					class="btn btn-outline-primary" value="등록" /> <input type="reset"
					id="btn" class="btn btn-outline-primary" value="취소"
					onclick="location.href='/board'" /></td>
			</tr>
		</table>
	</form>
</div>