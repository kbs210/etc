<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>숫자를 문자열로 변환</h3>
	number : 
		<fmt:formatNumber value="12345.678" type="number"></fmt:formatNumber><br>
	currency:
		<fmt:formatNumber value="12345.678" type="currency"></fmt:formatNumber>
		<fmt:formatNumber value="12345.678" type="currency" currencySymbol="$"></fmt:formatNumber><br>	
	percent :
		<fmt:formatNumber value="12345.678" pattern=".000000"></fmt:formatNumber><br>
	<h3>문자열을 숫자로 변환</h3>
	<c:set var="str" value="${'1000'}"></c:set>
	<fmt:parseNumber var="pNum" value="${str}"></fmt:parseNumber>
	${pNum}
	<br>
	<fmt:parseNumber var="isu" value="55.7" integerOnly="true"></fmt:parseNumber>
	${isu}
	<h3>날짜를 문자열로 변환</h3>
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	<c:set var="today" value="${date}"></c:set>
	현재날짜 : ${today} <br>
	
	변환날짜 : <fmt:formatDate value="${date}" type="date"/><br>
	변환시간 : <fmt:formatDate value="${date}" type="time"/><br>
	날짜시간 둘다: <fmt:formatDate value="${date}" type="both"/><br>
	다른형식1 : <fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short"/><br>
	다른형식2 : <fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long"/><br>
	형식지정 : <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/><br>
	
	<h3>문자열을 날짜 변환</h3>
	<c:set var="nowdate" value="2021-03-15 17:13:30"></c:set>
	<%-- new Date에 생성자에 문자열 변수를 넣는 방법 --%>
	<fmt:parseDate value="${nowdate}" pattern="yyyy-MM-dd HH:mm:ss"> </fmt:parseDate><br>
	
</body>
</html>









