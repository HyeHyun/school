<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">학생 목록</h2>
	</div> 
	<center>
<%-- 		<table border="1" style="width: 90%; text-align: center">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전공</th>
				<th>수강과목</th>
				<th>주소</th>
				<th>생년월일</th>
			</tr>
			<c:forEach var="member" items="${list}">
				<tr>
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.major}</td>
					<td>${member.subjects}</td>
					<td>${member.addr}</td>
					<td>${member.birth}</td>
				</tr>
			</c:forEach>
		</table> --%>
		<table border="1" style="width: 90%; text-align: center">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>주소</th>
				<th>생년월일</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.password}</td>
					<td>${list.addr}</td>
					<td>${list.birth}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</div>