<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<c:set var="contextpath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link rel="stylesheet"
	href="${contextpath}/resources/lib/bootstrap-5.0.2-dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="${contextpath}/resources/css/common.css" />
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700"
	rel="stylesheet">
<script
	src="${contextpath}/resources/lib/bootstrap-5.0.2-dist/js/bootstrap.bundle.min.js"></script>
<!-- header Css -->
<link rel="stylesheet"
	href="${contextpath}/resources/lib/header/fonts/icomoon/style.css">
<link rel="stylesheet"
	href="${contextpath}/resources/lib/header/css/style.css">
	<script src="/resources/lib/jquery-3.6.1.min.js"></script>
</head>
<body style=" height:100%; max-height: 2500px; min-height: 2000px;">
	<div class="hero"
		style="background-image: url('/resources/lib/header/images/hero_1.jpg'); height:100%; max-height: 2500px; min-height: 2000px;">
		<tiles:insertAttribute name="header" />
		<div
			style="position: relative; top: 4rem; padding: 2%; background-color: white;">
			<tiles:insertAttribute name="body" />
		</div> 
		<tiles:insertAttribute name="footer" />
	</div>

	<!-- header Js -->
	<script src="/resources/lib/jquery-3.6.1.min.js"></script>
	<script src="/resources/lib/header/js/bootstrap.min.js"></script>
	<script src="/resources/lib/header/js/jquery.sticky.js"></script>
	<script src="/resources/lib/header/js/main.js"></script>
</body>
</html>