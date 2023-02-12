<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${contextpath}/resources/js/member/memberInput.js"></script>
<link rel="stylesheet" href="${contextpath}/resources/css/member/signUp.css" />
  <div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills justify-content-center py-3">
      <li class="nav-item px-4">
        <a class="nav-link" href="/signup">회원으로 가입하기</a>
      </li>
      <li class="nav-item px-4">
        <a class="nav-link active" href="/nonUserSignup">비회원으로 가입하기</a>
      </li>
    </ul>
		<div>
		<h1 class="panel-title">비회원으로 가입 </h1>
			<div class="panel-body">
				<form:form action="/insertNonMember" method="post" modelAttribute="nonUserInfo" autocomplete="off">
				<div class="form-group w-70 align-items-center">
					<form:label path="email">이메일(최소 8자 최대 30자)</form:label>
					<form:input path="email" type="email" id="email" class="form-control text-center row w-50" name="email" required="required" maxlength="30" oninput="emailCheck();"
					placeholder="이메일을 입력해주세요 "/>
					<span id="olmessage"></span>
					<span id="email-warning-message"></span>
					<p id="email-overlapse-message"></p>
				</div>
				<div class="form-group w-70 align-items-center">
					<form:label path="name">이름(최소2자 최대20자)</form:label>
					<form:input type="text" path="name" id="name" class="form-control text-center row w-50" name="name" required="required" maxlength="20"
					placeholder="이름을 입력해주세요 "/>
					<p id="name-warning-message"></p>
				</div>
				<div class="form-group w-70 align-items-center">
					<form:label path="phone">전화번호('-'없이 입력 최대11자)</form:label>
					<form:input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' path="phone" id="phone" class="form-control text-center row w-50" name="phone" required="required" maxlength="11" oninput="phoneCheck();"
					placeholder="전화번호를 입력해주세요 "/>
					<span id="phmessage"></span>
					<p id="phone-warning-message"></p>
					<p id="phone-overlapse-message"></p>
				</div>
				<form action="/insertNonMember" method="post" class="form-horizontal">
					<div class="btn-group">
						<div>
							<input type="submit" value="회원가입" id="submit" class="btn btn-primary"/>
						</div>
						<div>
							<a href="/"><button id="btnHome" class="btn btn-primary" type="button">홈으로</button></a>
						</div>
					</div>
				</form>
				</form:form>
			</div>
		</div>
	</div>
</div>