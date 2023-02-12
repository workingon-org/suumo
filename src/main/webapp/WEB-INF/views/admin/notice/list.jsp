<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${contextpath}/resources/css/adminNotice.css" />
<script src="/resources/js/adminNotice.js"></script>

<h4 style="text-align: center" class="notice_title">공지사항 글쓰기</h4>
<div class="container">
	<div style="width: 60%; margin: auto;">
		<table style="text-align: center; width: 100%">
			<caption></caption>
			<thead>
				<tr style="border-bottom: 2px solid #353535; background-color: #EAEAEA; font-size: 13px; height: 30px;">
					<th class="th_style" style="width: 5%;">No</th>
					<th class="th_style" style="width: 80%;">TITLE</th>
					<th class="th_style" style="width: 15%;">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${noticeList }">
					<tr class="title_tr">
						<td class="td_style">${notice.id }</td>
						<td class="td_style"><a href="/admin/notice/detail/${notice.id }" style="font: #353535;">${notice.title }</a></td>
						<td class="td_style"><fmt:formatDate pattern="yyyy-MM-dd" value="${notice.createdAt }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="height: 40px; margin-top: 20px; width: 100%">

			<button type="button" class="btn_style" id="writeBtn" onclick="location.href='./write'">공지작성</button>
		</div>
		<div class="container w-50">
			<div class="row">
				<div class="btn-group me-2 col text-center" role="group" aria-label="Second group">
					<c:if test="${paging.currentPage > 3}">
						<button type="button" class="paging_btn_style" onclick="noticePaging(1)">◁◁</button>
						<button type="button" class="paging_btn_style" onclick="noticePaging(${paging.currentPage-5})">◁</button>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage}" var="page">
						<button type="button" class="paging_btn_style" onclick="noticePaging(${page})">${page }</button>
					</c:forEach>
					<c:if test="${paging.totalPage > paging.startPage + 1}">
						<button type="button" class="paging_btn_style" onclick="noticePaging(${paging.currentPage+5})">▷</button>
						<button type="button" class="paging_btn_style" onclick="noticePaging(${paging.totalPage})">▷▷</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

function noticePaging(val){
	location.href="/admin/notice/list?currentPage=" +val;
	
}
</script>
