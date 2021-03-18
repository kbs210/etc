<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>El - 2. setter, getter</h3>
	<%-- 객체 선언 Memberinfo member = new Memberinfo --%>
	
	<jsp:useBean id="member" class="com.java.el.Memberinfo">
	
	<%-- setMethod --%>
	${member.setName("가나다")}
	${member.setId("ga")}
	${member.setPwd("123")}
	
	<%-- getMethod --%>
	<h3>${member.getName()}</h3>
	<h3>${member.getId()}</h3>
	<h3>${member.getPwd()}</h3>
	
	<%-- setMethod --%>
	${member.setName("라바사")}
	${member.setId("na")}
	${member.setPwd("456")}
	
	<%-- get 메소드 호출 --%>
	<h3>${member.name}</h3>
	<h3>${member.id}</h3>
	<h3>${member.pwd}</h3>
	
	</jsp:useBean>
</body>
</html>