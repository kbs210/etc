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
	<c:set var="fruit" value="banana"></c:set></body>
	<c:if test="${fruit=='apple'}">
		<h3>${fruit}은 사과이다</h3>
	</c:if>
	
	<c:if test="${fruit!='apple'}">
		<h3>${fruit}은 사과가 아니다</h3>
	</c:if>
	
	<c:if test="${fruit!='apple'}">
		<c:out value="${fruit}"></c:out>
	</c:if>
	
	<br>
	
	<c:out value="안녕하세요"></c:out>
	
	<br>
	
	<c:choose>
		<c:when test="${fruit=='apple'}">
			${fruit}은 사과이다
		</c:when>
		
		<c:when test="${fruit=='banana'}">
			${fruit}은 바나나이다
		</c:when>
		
		<c:when test="${fruit=='orange'}">
			${fruit}은 오렌지이다
		</c:when>
		
		<c:otherwise>
			case문의 default
		</c:otherwise>
	</c:choose>
	
</html>