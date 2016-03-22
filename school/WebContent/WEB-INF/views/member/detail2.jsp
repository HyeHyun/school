<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"></jsp:include>
<div class="mg_auto" style="width:1000px;">
	<form action="${context}/global/main.do">
		<input type="submit" value="로그아웃"/>
	</form>
	<table>
		<tr>
			<td rowspan="4"></td>
			<td>아이디</td>
			<td><input type="text" value="${member.id}"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" value="${member.name}"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" value="${member.password}"/></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" value="${member.addr}"/></td>
		</tr>
		<tr>
			<td><input type="file" /></td>
			<td>생년월일</td>
			<td><input type="text" value="${member.birth}"/></td>
		</tr>
	</table>
	<div>
		<form action="${context}/grade/my_grade.do">
			<input type="hidden" name="id" value="${member.id}" />
			<input type="submit" value="내 성적 보기" />
		</form>
	</div>
	<jsp:include page="../global/footer.jsp" />
</div>