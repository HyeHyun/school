<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">회원리스트</h2>
	</div> 
	<center>
		<table border="1" style="width: 90%; text-align: center">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>비밀번호</td>
				<td>주소</td>
				<td>생년월일</td>
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