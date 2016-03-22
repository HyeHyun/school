<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"></jsp:include>
<div class="mg_auto" style="width:1000px;">
	<h2>내 성적보기</h2>
	<table border="1" style="width:60%">
		<tr>
			<td>과목</td>
			<td>점수</td>
		</tr>
		<tr>
			<td>자바</td>
			<td>${score.java}</td>
		</tr>
		<tr>
			<td>SQL</td>
			<td>${score.sql}</td>
		</tr>
		<tr>
			<td>JSP</td>
			<td>${score.jsp}</td>
		</tr>
		<tr>
			<td>스프링</td>
			<td>${score.spring}</td>
		</tr>
	</table>
	<jsp:include page="../global/footer.jsp" />
</div>