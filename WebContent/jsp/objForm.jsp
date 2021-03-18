<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<!-- EL 내장객체 - HTTP요청 파라미터(param) -->
	<h3>이름 : ${param.name}</h3>
	<h3>아이디 : ${param.id}</h3>
	<h3>패스워드 : ${param.pwd}</h3>
	<br><br>
	
	<!-- EL 내장객체 - JSP 저장객체(Scope) 읽기 -->
	<ul>
		<li>${pageScope.pName}</li>
		<li>${requestScope.rName}</li>
		<li>${sessionScope.gName}</li>
		<li>${applicationScope.kitri}</li>
	</ul>
	
</body>
</html>