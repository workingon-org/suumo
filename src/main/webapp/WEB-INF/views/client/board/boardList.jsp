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
	<br />
	<form id="boardList" name="listForm" method="GET" action="/board">
		<div class="input-group" style="width:100%; display: flex; justify-content: center; margin:10px; " >
			<select name="title" class="form-control" style="width:100px;flex:none;">
				<option value="">::검색::
				<option value="name" ${paging.selectName}>작성자
				<option value="title" ${paging.selectTitle}>제목
			</select> <input type="search" class="form-control rounded"
				placeholder="Search" aria-label="Search" name="content" value=""
				aria-describedby="search-addon" style="width: 40%; flex: none;" value="${paging.content }" />
			<button type="submit" class="btn btn-outline-primary" style="width:70px;">검색</button>
			&nbsp;&nbsp;&nbsp;<input type="button" id="btn" class="btn btn-outline-primary"
			value="게시글작성" onclick="location.href='board/insert'" style="justify-content: flex-end;" /> 
		</div>
		<input value="${paging.currentPage }" name="currentPage"
			id="currentPage" type="hidden">
		<table align="center" width="70%" class="boardInfo">
			<tr align="center" id="list">
				<td align="center" width="10%">No</td>
				<td align="center" width="20%">작성자</td>
				<td align="center" width="50%">제목</td>
				<td align="center" width="20%">작성일</td>
			</tr>
			<c:choose>
				<c:when test="${boardList.size() >0 }">
					<c:forEach var="board" items="${boardList}">
						<tr>
							<td align="center">${board.id}</td>
							<td align="center">${board.name}</td>
							<td align="left"><a href="/board/${board.id}">${board.title}</a></td>
							<td align="center">${board.createdAt}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4" align="center">작성된 글이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<c:if test="${not empty paging }">
			<nav aria-label="Page navigation example" style="height:100px; display:flex; justify-content: center; align-items: center;">
				<ul class="pagination">
					<c:if test="${paging.currentPage > 3}">
						<li class="page-item"><a class="page-link"
							onclick="boardListPaging(1)" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li class="page-item"><a class="page-link"
							onclick="boardListPaging(${paging.currentPage-5})">‹</a></li>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage}"
						var="page">
						<li class="page-item"><a class="page-link"
							onclick="boardListPaging(${page})" href="#">${page }</a></li>
					</c:forEach>
					<c:if test="${paging.totalPage > paging.startPage + 3}">
						<li class="page-item"><a class="page-link"
							onclick="boardListPaging(${paging.currentPage+5})" href="#">›</a></li>

						<li class="page-item"><a class="page-link"
							onclick="boardListPaging(${paging.totalPage})" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</c:if>
		<br /> <br />
	</form>
</div>