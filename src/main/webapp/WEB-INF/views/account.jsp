<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이체 전송 이벤트 -->
	<h1>홍길동의 계좌</h1>
	<form action="transfer" method="get">
		이체금액 : <input type="text" name="money">
		이체할 계좌번호 : <input type="text" name="accountNum" value="5678-1234">
		<input type="submit" value="이체">
	</form>	
</body>
</html>