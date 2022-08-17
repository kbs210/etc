<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>반복문 - for</h3>
	<c:forEach var="i" begin="1" end="10" step="2">
		<h3>${i}</h3>
	</c:forEach>

	<c:forEach var="i" begin="1" end="100">
		<c:set var="tot" value="${tot+i}"></c:set>
	</c:forEach>
	<h3>1~100까지의 합은 : ${tot}</h3>

	<%
	//스플릿: JSP파일 내에서 자바 명령어 가능
	int su=77;
	java.util.ArrayList<String> arrayList = new java.util.ArrayList<String>(); 
	arrayList.add("사과");
	arrayList.add("바나나");
	arrayList.add("오렌지");
	%>

	<%=su%>
	<br>
	<c:set var = "arrayList" value="<%=arrayList%>"></c:set>
	<c:forEach var="fruit" items="${arrayList}">
		<c:out value="${fruit}"></c:out>
	</c:forEach>
	
	<br>
	<br>
	
	<c:set var="city" value="서울, 인천, 대구, 부산, 광주, 대전, 울산"></c:set>
	<c:forTokens var="data" items="${city}" delims=",">
		<c:out value="${data}"></c:out>
		<br>
	</c:forTokens>
	
	<form action="core04.jsp" method="get">
		<label>수 : </label>
		<input type="text" name="su">
		<input type="submit">
	</form>
	
</body>
</html>
























