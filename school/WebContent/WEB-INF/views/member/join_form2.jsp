<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"></jsp:include>
<div class="mg_auto" style="width:1000px;">
	<h2> 회원가입 </h2>
	<form action="${context}/member/join.do">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" autofocus="autofocus" required="required" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" required="required" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" required="required" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" /></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" /></td>
			</tr>
		</table>
		<div><input type="submit" value="회원가입" /><input type="reset" value="취소" /></div>
	</form>
	<form action="${context}/global/main.do">
		<input type="submit" value="홈" />
	</form>
	<jsp:include page="../global/footer.jsp" />
</div>