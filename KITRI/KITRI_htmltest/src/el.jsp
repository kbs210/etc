<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>Java 명령어를 사용하기위해 JSTL, EL을 사용한다</div>
	<!-- html주석 -->
	<%-- JSP 주석 --%>
	
	<%-- 1. 데이터, 연산자 --%>
	
	<h3>1. 데이터출력, 연산자가능(직접 데이터 사용가능)</h3>
	<ol>
		<li>수 출력 			 : ${10}, ${99.999}</li>
		<li>문자열 출력 		 : ${"사과"}, ${"바나나"}</li>
		<li>연산				 : ${10+50}, ${10-50}, ${10*50}, ${10/50}, ${10%50}</li>
		<li>작다				 : ${10<50}, ${10 lt 50}</li>
		<li>크다 			 : ${10>50}, ${10 gt 50}</li>
		<li>작거나 같다		 : ${10<=50}, ${10 le 50}</li>
		<li>크거나 같다		 : ${10>=50}, ${10 ge 50}</li>
		<li>논리연산자			 : ${"&&, and, ||, or, !, not"}</li>
		<li>빈문자열(null)	 : ${null}</li>
	</ol>
	
</body>
</html>