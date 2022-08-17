<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>response.sendRedirect()를 대체하는 함수</h3>
	<c:set var="su" value="${param.su}"></c:set>
	<c:if test="${su==1}">
		<c:redirect url="http://www.naver.com"></c:redirect>
	</c:if>
	
		<c:if test="${su!=1}">
		<c:redirect url="http://www.daum.net"></c:redirect>
	</c:if>
	
	<h3>내부 자원 가저오기</h3>
	<c:import url="core01.jsp"></c:import>
</body>
</html>