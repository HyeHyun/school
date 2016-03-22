<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"></jsp:include>
<div class="mg_auto" style="width:1000px;">
	<div>
		<h2> 로그인 화면 </h2>
		<form action="${context}/member/login.do" name="frm" method="get">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" autofocus="autofocus" required="required" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" required="required" /></td>
				</tr>
			</table>
			<div><input type="submit" value="로그인"/></div>
		</form>
	</div>
	<div>
		<h4>아이디가 없으면, 계정을 생성하세요</h4>
		<a href="${context}/member/join_form.do">회원가입</a>
	</div>
	<jsp:include page="../global/footer.jsp" />
</div>