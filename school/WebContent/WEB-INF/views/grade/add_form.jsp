<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">${member.name} 성적 입력</h2>
	</div>
		<div class="joinCenter row">
		<form>
			<fieldset class="joinField">
				<div class="form-group">
				 	<label for="input_id" class="col-sm-4 control-label">Java</label>
				 	<div class="col-sm-4">
				 		<input type="text" class="form-control" id="java" name="java" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw" class="col-sm-4 control-label">JSP</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="jsp" name="jsp" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">SQL</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="sql" name="sql" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">Spring</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="spring" name="spring" />
					</div>
				</div>
				<input type="hidden" value="${member.id}" name="id" id="id"/>
			</fieldset>
		</form>
		<div class="input_button text-center">
			<button id="grade_input">입력</button>
			<button id="grade_cancel">취소</button>
		</div>
	</div>
</div>
<script>
	$(function() {
		$('form').addClass('form-horizontal');
		$('#grade_input').click(function() {
			$('form').attr('action', '${context}/grade/grade_add.do').attr('method', 'post').submit();
		});
	});
</script>