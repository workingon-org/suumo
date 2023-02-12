<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="/resources/js/adminUserInfo.js"></script>
<title>회원정보 검색</title>
<div class="d-flex justify-content-center w-100">
	<div class="d-inline-block w-95">
		<div class="d-flex justify-content-center w-80">
			<input value="${message }" id="message" type="hidden" />
			<form id="userSearch" name="userSearch" action="search"
				class="form-inline">
				<H1 style="text-align: center;">회 원 정 보 관 리</H1>
				<div
					style="min-height: 400px; min-width: 600px; background-color: lightgray">
					<table class="table text-center table-dark table-hover">
						<thead>
							<tr>
								<td>No</td>
								<td>이름</td>
								<td>연락처</td>
								<td>메일주소</td>
								<td>비밀번호재설정</td>
								<td>삭제</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="userInfo" items="${userInfoList }">
								<tr>
									<td>${userInfo.id}</td>
									<td>${userInfo.name}</td>
									<td>${userInfo.phoneForView}</td>
									<td>${userInfo.emailForView}</td>
									<td><input value="비밀번호재설정" type="button"
										onclick="passwordReset('${userInfo.email}', '${userInfo.id }')" /></td>
									<td><input value="삭제" type="button"
										onclick="deleteUser(${userInfo.id})" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col text-center">
					<div class="btn-group btn-group-sm "
						style="margin: auto; width: 80%; margin-bottom: 20px;">
						<select name="searchType" id="searchType" size="1"
							class="form-control mr-2 btn btn-outline-secondary"
							style="float: left; width: 10%; display: inline-block;">
							<option value="">::검색 유형::</option>
							<option value="name" ${page.name}>회원이름</option>
							<option value="phone" ${page.phone}>연락처</option>
							<option value="email" ${page.email}>이메일</option>
						</select> <input type="text" name="searchKeyword" id="searchKeyword"
							onchange="selectBoxChange(this.value);" placeholder="검색어를 입력하세요"
							class="form-control mr-2"
							style="width: 70%; display: inline-block;"
							value="${page.searchKeyword}">
						<button class="btn btn-secondary" style="float: right">검색</button>
					</div>
				</div>
				<input id="currentPage" type="hidden"
					class="btn btn-secondary w-10 p-1" name="currentPage"
					value="${page.currentPage }" />
			</form>
		</div>
		<div class="container w-50" style="width: 30%">
			<div class="row">
				<div class="btn-group me-2 col text-center" role="group"
					aria-label="Second group">
					<c:if test="${page.currentPage > 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(1)">◁◁</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page.currentPage-5})">◁</button>
					</c:if>
					<c:forEach begin="${page.startPage }" end="${page.endPage}"
						var="page">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page })">${page }</button>
					</c:forEach>
					<c:if test="${page.total > page.startPage + 3}">
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page.currentPage+5})">▷</button>
						<button type="button" class="btn btn-secondary w-10 p-1"
							onclick="paging(${page.total})">▷▷</button>
					</c:if>

				</div>
			</div>
		</div>
	</div>
</div>
