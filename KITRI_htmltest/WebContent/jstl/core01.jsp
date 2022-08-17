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
	<%-- JSTL은 Java를 태그로 미리 만들어 놓은 것 --%>
	<%-- 변수를 생성하고 값을 넣는 것을 c:set(jstl)을 사용하고 뽑아내는 것을 el로 이용한다 --%>
	
	<h3>변수 선언</h3>
	<c:set var="su" value="10"/>
	<c:set var="imsi" value="${20}"></c:set>
	
	<h3>${su} / ${imsi}</h3>
	
	<c:set var="msg" value="${'Hi'}" scope="page"></c:set> <!-- page(default), request, session, application -->
	<c:set var="age" value="31"></c:set>
	
	<div>
		메세지 : ${msg}
		<br>
		나이 : ${age}
	</div>
	
	<jsp:useBean id="member" class="com.java.el.Memberinfo"></jsp:useBean>
	<c:set target="${member}" property="name" value="하라마"></c:set>
	<c:set target="${member}" property="id" value="1441"></c:set>
	<c:set target="${member}" property="pwd" value="okfasd"></c:set>
	
	<h3>${member.name}</h3>
	<h3>${member.id}</h3>
	<h3>${member.pwd}</h3>
	
	<c:set var="id" value="${member.id}" scope="session"></c:set> <%-- session.setAttribute --%>
	<h3>${sessionScope.id}, ${id}</h3>
	<br>
	<h3>${age}, ${id} : 변수 제거</h3>
	<c:remove var="age"/>
	<c:remove var="id"/>
	<h3>${age}, ${id} : 변수 확인</h3>
		
	
</body>
</html>