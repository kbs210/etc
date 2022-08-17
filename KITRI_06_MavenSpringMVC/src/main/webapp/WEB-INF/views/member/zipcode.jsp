<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var = "root" value = "${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${root}/javascript/member/register.js"></script>
</head>
<body>
	<form action="${root}/member/zipcode.do" method="post">
		<div align="center">
			<table>
				<tr>
					<td>우편번호를 검색하세요.</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="dong"/>
						<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
	
	<div align="center">
		<c:choose>
			<c:when test="${zipcodeList.size()==0}">
				<tr>
					<td>검색된 결과가 없습니다.</td>
				</tr>
			</c:when>
			<c:when test="${zipcodeList.size()>0}">
				<tr>
					<td>아래 우편 번호를 클릭하세요.</td>
				</tr>
				<br />
				<c:forEach var="zipcodeDto" items="${zipcodeList}">
					<tr>
						<td>
							<a href="javascript:sendAddress('${zipcodeDto.zipcode}','${zipcodeDto.sido}','${zipcodeDto.gugun}','${zipcodeDto.dong}','${zipcodeDto.ri}','${zipcodeDto.bunji}')">
							${zipcodeDto.zipcode}
							${zipcodeDto.sido}
							${zipcodeDto.gugun}
							${zipcodeDto.dong}
							${zipcodeDto.ri}
							${zipcodeDto.bunji}
							</a>
						</td>
					</tr>
					<br />
				</c:forEach>
			</c:when>
		</c:choose>
	</div>
</body>
</html>