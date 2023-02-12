<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${contextpath}/resources/js/member/memberInput.js"></script>
<link rel="stylesheet" href="${contextpath}/resources/css/member/signUp.css" />
  <div class="card text-center">
  <div class="card-header">
    <ul class="nav nav-pills card-header-pills justify-content-center py-3">
      <li class="nav-item px-4">
        <a class="nav-link active" href="/signup">회원으로 가입하기</a>
      </li>
      <li class="nav-item px-4">
        <a class="nav-link" href="/nonUserSignup">비회원으로 가입하기</a>
      </li>
    </ul>
	<div>	
			<h1 class="panel-title">회원으로 가입</h1>
				<div class="panel-body">
					<form:form action="/insertMember" method="post" modelAttribute="userInfo" autocomplete="off">
							<div class="form-group w-70 align-items-center">
								<form:label class="w-70" path="email">이메일(최소 8자 최대 30자)</form:label>
								<form:input type="email" path="email" id="email" class="form-control text-center row w-50" name="email" required="required" maxlength="30" oninput="emailCheck();"
								placeholder="이메일을 입력해주세요 "/>
								<span id="olmessage"></span>
								<span id="email-warning-message"></span>
								<p id="email-overlapse-message"></p>
 							</div>
							<div class="form-group w-70 align-items-center">
								<form:label path="password">비밀번호(최소8자 최대16자)</form:label>
								<form:password path="password" class="form-control text-center row w-50" required="required" maxlength="16"
								placeholder="비밀번호를 입력해주세요 "/>
							<p id="password-warning-message"></p>
							</div>
							<div class="form-group w-70 align-items-center">
								<form:label path="confirmPassword">비밀번호 확인</form:label>
								<form:password path="confirmPassword" class="form-control text-center row w-50" required="required" maxlength="16"
								placeholder="비밀번호를 다시 입력해주세요 "/>
							<p id="confirm-password-warning-message"></p>
							</div>
							<div class="form-group w-70 align-items-center">
								<form:label path="name">이름(최소2자 최대20자)</form:label>
								<form:input type="text" path="name" class="form-control text-center row w-50" required="required" maxlength="20"
								placeholder="이름을 입력해주세요 "/>
							<p id="name-warning-message"></p>
							</div>
							<div class="form-group w-70 align-items-center">
								<form:label path="phone">전화번호('-'없이 최대11자)</form:label>
								<form:input type="text" onkeypress='return event.charCode >= 48 && event.charCode <= 57' path="phone" class="form-control text-center row w-50" required="required" maxlength="11" oninput="phoneCheck();"
								placeholder="전화번호를 입력해주세요 "/>
								<span id="phmessage"></span>
							<p id="phone-warning-message"></p>
							<p id="phone-overlapse-message"></p>
							</div>
								<form
									action="/insertMember"
									method="post"
									class="form-horizontal"
								>
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