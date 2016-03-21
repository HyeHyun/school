<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="context" value="<%=request.getContextPath() %>"></c:set>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="UTF-8" />
	<title>로그인 폼</title>
</head>
<body>
	<div>
		<h2> 회원가입 </h2>
		<form action="${context}/member/join.do">
			<table>
				<tr>
					<td><h3>아이디</h3></td>
					<td><input type="text" name="id" autofocus="autofocus" required="required" /></td>
				</tr>
				<tr>
					<td><h3>비밀번호</h3></td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
				<tr>
					<td><h3>비밀번호 확인</h3></td>
					<td><input type="password" required="required" /></td>
				</tr>
				<tr>
					<td><h3>이름</h3></td>
					<td><input type="text" name="name" required="required" /></td>
				</tr>
				<tr>
					<td><h3>주소</h3></td>
					<td><input type="text" name="addr" /></td>
				</tr>
				<tr>
					<td><h3>생년월일</h3></td>
					<td><input type="date" name="birth" /></td>
				</tr>
			</table>
			<div><input type="submit" value="회원가입" /><input type="reset" value="취소" /></div>
		</form>
	</div>
</body>
</html>