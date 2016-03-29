<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">학생 목록</h2>
	</div> 
	<table id="member_list" style="width: 90%">
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
				<td><a href="${context}/grade/add_form.do?id=${member.id}">${member.name}</a></td>
				<td>${member.major}</td>
				<td>${member.subject}</td>
				<td>${member.addr}</td>
				<td>${member.birth}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script>
	$(function() {
		$('#member_list tr').css('border', '1px solid black');
		$('#member_list tr th').css('border', '1px solid black').css('text-align', 'center').css('background-color', 'yellow');
		$('#member_list tr td').css('border', '1px solid black').css('text-align', 'center');
	});
</script>