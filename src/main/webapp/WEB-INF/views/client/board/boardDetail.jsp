<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" href="${contextpath}/resources/css/board.css" />
<script src="/resources/js/board.js"></script>
<div>
	<br /> <br /> &nbsp;&nbsp;&nbsp;
	<h1 style="text-align: center">
		<font size="20">문의 게시판<br /></font>
	</h1>
	<form action="update/${board.id}">
		<table align="center" class="inquiryDetail">
			<tr>
				<td id="detail">제목</td>
				<td width="25%">${board.title}<input type="hidden" name="title"
					value="${board.title}" />
				</td>
				<td id="detail">No</td>
				<td width="25%">${board.id}<input type="hidden" name="id"
					value="${board.id}" />
				</td>
			</tr>
			<tr>
				<td id="detail">작성자</td>
				<td width="25%">${board.name}<input type="hidden" name="name"
					value="${board.name}" />
				</td>
				<td id="detail">작성일</td>
				<td width="25%">${board.createdAt}<input type="hidden"
					name="created_at" value="${board.createdAt}" />
				</td>
			</tr>
			<tr>
				<td id="detailcontent">내용</td>
				<td colspan="3"><textarea rows="5" cols="40"
						style="min-height: 500px;" id="detailtextarea" readonly="readonly"
						name="content">${board.content}</textarea></td>
			</tr>
			<tr align="center">
				<td colspan="4"><input type="submit" id="btn"
					class="btn btn-outline-primary" value="수정" /> <input type="button"
					id="btn" class="btn btn-outline-primary" value="삭제"
					onclick="location.href='delete/${board.id}'" /> <input
					type="button" id="btn" class="btn btn-outline-primary" value="목록"
					onclick="location.href='/board'" /></td>
			</tr>
		</table>
	</form>
	<table align="center" class="inquiryDetail">
		<!-- 작성된 댓글들 보여주기 -->
		<c:choose>
			<c:when test="${sessionScope.loginUserInfo.name eq board.name}">
				<c:forEach items="${comments}" var="comment">
					<tr>
						<td colspan="4" id="comment">
							<div id="showContent${comment.id}">
								<div>${comment.name}
									|
									<fmt:formatDate pattern="yyyy-MM-dd"
										value="${comment.createdAt}" />
								</div>
								<div>${comment.content}</div>
								<br />
							</div>
							<div id="hideContent${comment.id}" style="display: none;">
								<form action="commentUpdate" method="post">
									<div>${comment.name}</div>
									<input type="hidden" name="name" value="${comment.name}" />
									<textarea style="min-height: 100px;" cols="50" name="content"
										required="required">${comment.content}</textarea>
									<input type="hidden" name="id" value="${comment.id}" /> <input
										type="hidden" name="boardId" value="${comment.boardId}" /> <input
										type="submit" value="수정 완료" id="commentBtn"
										style="margin-right: 3px;" /> <input type="button" value="취소"
										onclick="showDesc(${comment.id})" id="commentBtn" />
								</form>
							</div>
							<div id="showContent${comment.id}">
								<input type="button" value="수정" id="commentBtn"
									onclick="showDesc(${comment.id})" /> <input type="button"
									value="삭제" id="commentBtn"
									onclick="location.href='commentDelete?id=${comment.id}&boardId=${comment.boardId}'" />
							</div>
						</td>
					</tr>
				</c:forEach>
				<!-- 글주인일 경우만 댓글 작성 가능 -->
				<tr>
					<td colspan="4" id="commentWrite">
						<form action="/board/commentWrite" method="post">
							<textarea cols="50" name="content" required="required"
								style="min-height: 100px;" placeholder="소중한 댓글을 작성해주시길 바랍니다."></textarea>
							<input type="hidden" name="boardId" value="${board.id}">
							<input type="hidden" name="name" value="${board.name}"> <input
								type="submit" value="댓글 작성" id="commentWriteBtn" />
						</form>
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4" id="commentWriteNotLogin" style="gap:3px;">댓글은 로그인한 유저만 가능합니다. &nbsp;&nbsp;&nbsp;&nbsp; <a href="/login">로그인</a> &nbsp;&nbsp;&nbsp; <a href="/signup">회원가입</a></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>

</div>