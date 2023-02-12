<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${contextpath}/resources/js/member/login.js"></script>
<link rel="stylesheet" href="${contextpath}/resources/css/member/commonMember.css" />
<div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills justify-content-center py-3">
      <li class="nav-item px-4">
        <a class="nav-link" href="/login">회원으로 로그인</a>
      </li>
      <li class="nav-item px-4">
        <a class="nav-link active" href="/nonUserLogin">비회원으로 로그인</a>
      </li>
    </ul>
<div>
	<h1 class="login-title">비회원 로그인</h1>
	<div class="panel-body">
	<form:form action="/nonUserLogin" method="post" modelAttribute="loginUser" autocomplete="off">
		<div class="form-group w-70 align-items-center">
			<label for="email">이메일(아이디)</label>
			<form:input path="email" type="text" class="form-control row w-50" id="email"
				placeholder="이메일을 입력해주세요." />
		</div>
		<div class="form-group w-70 align-items-center">
			<label for="phone">전화번호</label>
			<form:input path="phone" type="text" class="form-control row w-50" id="phone"
				placeholder="전화번호를 입력해주세요." />
		</div>
		<h6 class="text-danger">${msg}</h6>
		<div class="btn-group">
			<div>
				<button type="submit" class="btn btn-primary">로그인</button>
			</div>
			<div>
			  <a href="/signup" class="btn btn-primary">회원가입 </a>
			</div>
		</div>
	</form:form>
	</div>
	</div>
</div>
</div>