<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
<div id="detail">
	<div class="joinTop">
		<h2 class="text-center">내 성적보기</h2>
	</div>
	<div class="joinCenter row">
		<form action="${context}/member/detail.do" name="updateForm" class="form-horizontal">
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
				<div class="input_button text-center">
					<input type="submit" id="mygradeButton" class="btn btn-primary" value ="내 정보보기"/>
					<input type="hidden" id="id" name="id" class="btn btn-primary" value ="${score.id}"/>
				</div>
			</fieldset>
		</form>
	</div>
</div>