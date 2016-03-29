<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="join">
	<div class="joinTop">
		<h2 class="text-center">회원가입</h2>
	</div>
	<div class="joinCenter row">
		<form class="form-horizontal">
			<fieldset class="joinField">
				<div class="form-group">
				 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력하세요"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
				 	<div class="col-sm-4">
						<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw_check" class="col-sm-4 control-label">비밀번호 확인</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" name="passwordCheck" id="passwordCheck" placeholder="비밀번호를 확인하세요"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">이름</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">주소</label>
				 	<div class="col-sm-4">
						<input type="radio" name="addr" id="addr" value="서울" checked />서울
						<input type="radio" name="addr" id="addr" value="인천" />인천
						<input type="radio" name="addr" id="addr" value="경기" />경기
						<input type="radio" name="addr" id="addr" value="부산" />부산
						<input type="radio" name="addr" id="addr" value="대전" />대전
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">생년월일</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="birth" name="birth" placeholder="생년월일을 입력하세요"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">수강과목</label>
				 	<div class="col-sm-4">
						<input type="checkbox" class="form-control" id="subject" name="subject" value="java"/>Java
						<input type="checkbox" class="form-control" id="subject" name="subject" value="jsp"/>JSP
						<input type="checkbox" class="form-control" id="subject" name="subject" value="sql"/>SQL
						<input type="checkbox" class="form-control" id="subject" name="subject" value="spring"/>Spring
						<input type="checkbox" class="form-control" id="subject" name="subject" value="python"/>파이썬
						<input type="checkbox" class="form-control" id="subject" name="subject" value="nodejs"/>노드JS
						<input type="checkbox" class="form-control" id="subject" name="subject" value="android"/>안드로이드
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">전공</label>
					<select name="major" id="major">
						<option value="computer" selected="selected">컴퓨터공학</option>
						<option value="info">정보통신</option>
						<option value="security">정보보안</option>
					</select>
				</div>
				<div class="input_button text-center">
					<button id="joinButton" class="btn btn-primary">가입</button>
					<button id="cancelButton" class="btn btn-primary">취소</button>
				</div>
			</fieldset>
		</form>
	</div>
</div>
<script>
	$(function() {
		$form = $('form');
		$('#joinButton').click(function() {
			$form.attr('action', '${context}/member/join.do').attr('method', 'post').submit();
		});
		$('#cancelButton').click(function() {
			$form.reset();
		});
	});
</script>

<!-- 
	var id = $('input:text[name=id]').val();
	var password = $('input:text[name=password]').val();
	var name = $('input:text[name=name]').val();
	var birth = $('input:text[name=birth]').val();
	var addr = $('input:radio[name=addr]').val();
	var major = $('select[name=major] option:selected').val();
	var subjects = formTag.checkbox($('input:checkbox[name=subject]:checked'));
	alert('아이디 : ' + id + ', 비밀번호 : ' + password + ', 이름 : ' + name + ', 생일 : ' + birth + ', 주소 : ' + addr + ', 전공 : ' + major + ', 과목 : ' + subjects)
 
 
 		
	var formTag = {};
	formTag.checkbox = function(subjects) {
		var arr = [];
		subjects.each(function() {
			arr.push($(this).val());
		});
		
		return arr;
	}
 -->