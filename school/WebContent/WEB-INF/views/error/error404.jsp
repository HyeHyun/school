<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<!-- 
	
		HTTP 프로토콜은 응답상태 코드를 이용하여
		서버의 처리 결과를 알려주며,
		주요 응답상태 코드로는 다음과 같은 것들이 존재한다.
		200 - OK
		400 - 문법에러
		401 - 접근불가 (관리자만 접근 가능)
		404 - URL 에 따른 페이지가 존재하지 않음
		405 - 요청한 메소드는 허용 불가 (GET/POST 방식일때)
		500 - 서버 내부 에러... JSP 에서 Exception 발생
		503 - 서버 부하   예) 디도스
		
		JSP 가 정상적으로 실행되는 응답코드로는 200 이 전송

	 -->
	
	<div>
		<img src="${context}/img/error/error404.jpg" alt="404에러 발생" />
	</div>
</body>
</html>