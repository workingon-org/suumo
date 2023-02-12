<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${contextpath}/resources/css/adminBook.css" />
<script src="/resources/js/adminBook.js"></script>
<meta charset="UTF-8">
<title>예약관리 리스트</title>
<input value="${message }" id="message" type="hidden" />
<div class="d-flex justify-content-center w-100">
	<div class="d-inline-block w-95">
		<div class="d-flex justify-content-center w-80">
			<form id="adminBookListForm" action="/admin/book/list" method="POST">
				<div class="input-group mb-3 w-100">
					<select name="title" id="title" class="form-select form-select-sm"
						aria-label=".form-select-sm example"
						onchange="searchForDate(this.selectedIndex)">
						<option value="no" ${paging.selectNo}>예약번호</option>
						<option value="room" ${paging.selectRoom}>방이름</option>
						<option value="user" ${paging.selectUser}>고객</option>
					</select> <input type="text" name="content" id="content" class="form-control"
						value="${paging.content}"> <label for="startDate"
						class="form-control wx-10 d-inline-block mx-10 p-10">예약일</label> <input
						type="date" id="startDate" class="form-control" name="startDate"
						value="${paging.startDate }" /> <input type="date"
						id="endDate" class="form-control" name="endDate"
						value="${paging.endDate }" /> <input type="submit"
						class="btn btn-outline-primary" value="검색"> <input
						id="currentPage" type="hidden" name="currentPage"
						value="${paging.currentPage }">
					<div class="form-control">
						<input class="form-check-input" type="checkbox" name="deleteFlag"
							${paging.checkDeleteFlag} id="deleteFlag"> <label
							class="form-check-label" for="deleteFlag"> 삭제회원 </label>
					</div>
				</div>
			</form>
		</div>
		<div class="w-90" style="min-height: 400px">
			<table class="table text-center table-dark table-hover">
				<thead>
					<tr>
						<td>예약번호</td>
						<td>방이름</td>
						<td>예약자</td>
						<td>성인예약자수</td>
						<td>아이예약자수</td>
						<td>체크인일</td>
						<td>체크아웃일</td>
						<td>가격</td>
						<td>결재유무</td>
						<td>취소유무</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${bookList }">
						<tr>
							<td><a href="/admin/book/detail/${book.id }">${book.id }</a></td>
							<td><a href="/admin/room/detail/${book.roomId }">${book.roomName}</a></td>
							<td>${book.userName }</td>
							<td>${book.adultCnt}</td>
							<td>${book.childrenCnt}</td>
							<td>${book.startDate}</td>
							<td>${book.endDate}</td>
							<td>${book.priceForView}</td>
							<td><c:choose>
									<c:when test="${book.payFlag eq true}">
									결제완료
								</c:when>
									<c:otherwise>
									미결제
								</c:otherwise>
								</c:choose></td>
							<td><c:choose>
									<c:when test="${book.cancelFlag eq true}">
									취소
								</c:when>
									<c:otherwise>
									미취소
								</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="container w-50">
			<div class="row">
				<div class="btn-group me-2 col text-center" role="group"
					aria-label="Second group">
					<c:if test="${paging.currentPage > 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminBookListPaging(1)">◁◁</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminBookListPaging(${paging.currentPage-5})">◁</button>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage}"
						var="page">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminBookListPaging(${page})">${page }</button>
					</c:forEach>
					<c:if test="${paging.totalPage > paging.startPage + 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminBookListPaging(${paging.currentPage+5})">▷</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="adminBookListPaging(${paging.totalPage})">▷▷</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>