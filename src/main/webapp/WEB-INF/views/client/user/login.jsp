<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<script src="${contextpath}/resources/js/member/login.js"></script>
<link rel="stylesheet" href="${contextpath}/resources/css/member/commonMember.css" />
</head>
<div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills justify-content-center py-3">
      <li class="nav-item px-4">
        <a class="nav-link active" href="/login">회원으로 로그인</a>
      </li>
      <li class="nav-item px-4">
        <a class="nav-link" href="/nonUserLogin">비회원으로 로그인</a>
      </li>
    </ul>
	<div>
	<h1 class="login-title">회원 로그인</h1>
	<c:if test="${loginUserInfo == null}">
	<div class="panel-body">
	<form:form action="/login" method="post" modelAttribute="loginUser" autocomplete="off" class="">
		<div class="form-group w-70 align-items-center">
			<label for="email">이메일(아이디)</label>
			<form:input path="email" type="text" class="form-control row w-50" id="email"
				placeholder="이메일을 입력해주세요 " />
				 <form:errors path="email"/>
		</div>
		<div class="form-group w-70 align-items-center">
			<label for="password">비밀번호 </label>
			<form:input path="password" type="password" class="form-control row w-50" id="password"
				placeholder="비밀번호를 입력해주세요 " />
				 <form:errors path="password"/>
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
	</c:if>
	</div>
</div>
</div>