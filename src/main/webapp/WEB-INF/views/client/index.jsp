<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<h1>Index Page</h1>
	<c:if test="${not empty sessionScope.loginUserInfo.name}">
	<li><span>${loginUserInfo.name}님 반갑습니다.</span></li>
	</c:if>
</div>


	