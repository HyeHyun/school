<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">성적 목록</h2>
	</div> 
		<table id="grade_list" style="width: 90%">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>자바</th>
				<th>SQL</th>
				<th>JSP</th>
				<th>스프링</th>
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
</div>
<script>
	$(function() {
		$('#grade_list tr').css('border', '1px solid black');
		$('#grade_list tr th').css('border', '1px solid black').css('text-align', 'center').css('background-color', 'yellow');
		$('#grade_list tr td').css('border', '1px solid black').css('text-align', 'center');
	});
</script>