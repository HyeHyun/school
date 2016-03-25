<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">내 성적보기</h2>
	</div>
	<div class="joinCenter row">
		<form class="form-horizontal">
			<fieldset class="joinField">
				<div class="form-group">
				 	<label for="input_id" class="col-sm-4 control-label">자바</label>
				 	<div class="col-sm-4">
				 		<input type="text" class="form-control" id="java" name="java" value="${score.java}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw" class="col-sm-4 control-label">SQL</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="sql" name="sql" value="${score.sql}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">JSP</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="jsp" name="jsp" value="${score.jsp}" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">스프링</label>
				 	<div class="col-sm-4">
						<input type="text" class="form-control" id="spring" name="spring" value="${score.spring}" readonly="readonly"/>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>
