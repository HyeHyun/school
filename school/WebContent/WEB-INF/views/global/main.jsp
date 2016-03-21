<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="<%=request.getContextPath() %>"></c:set>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h2>메인화면</h2>
	
	<a href="${context}/member/login_form.do"> 로그인 화면 이동 </a>
</body>
</html>