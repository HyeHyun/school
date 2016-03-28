<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">성적 목록</h2>
	</div> 
	<center>
		<table border="1" style="width: 90%; text-align: center">
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>자바</td>
				<td>SQL</td>
				<td>JSP</td>
				<td>스프링</td>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.id}</td>
					<td>${list.name}</td>
					<td>${list.java}</td>
					<td>${list.sql}</td>
					<td>${list.jsp}</td>
					<td>${list.spring}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</div>