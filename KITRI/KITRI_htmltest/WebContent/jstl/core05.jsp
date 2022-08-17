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
	내부 자원 가져오기 <c:import url="core01.jsp"></c:import>
	
	외부 자원 가져오기 <c:import url="http://www.google.co.kr"></c:import>
</body>
</html>