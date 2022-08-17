<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var = "root" value = "${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>파일보드 목록 페이지</title>
</head>
<body>
	<div align="right">
		<table>
			<tr>
				<td>
					<a href="${root}/fileBoard/write.do">글쓰기</a>
				</td>
			</tr>
		</table>
	</div>
	
	<c:if test="${count==0||boardList.size()==0}">
		<div align="center">
			게시판에 저장된 글이 없습니다.
		</div>
	</c:if>
	
	<c:if test="${count>0}">
		<div align="center">
			<table border="1">
				<tr>
					<td align="center" width="50"><strong>번호</strong></td>
					<td align="center" width="250"><strong>제목</strong></td>
					<td align="center" width="70"><strong>작성자</strong></td>
					<td align="center" width="150"><strong>작성일</strong></td>
					<td align="center" width="50"><strong>조회수</strong></td>
				</tr>
				
				 <c:forEach var="boardDto" items="${boardList}">
					 <tr>
					 	<!-- 글번호 -->
					 	<td align="center" width="50">${boardDto.boardNumber}</td>
						
						<td align="center" width="250">
							<!-- 답글 -->
							<c:if test="${boardDto.sequenceLevel > 0}">
								<c:forEach begin="0" end="${boardDto.sequenceLevel}">
									&nbsp;&nbsp;
								</c:forEach>
								[답글]
							</c:if>
							
							<!-- 제목 -->
							<a href="${root}/fileBoard/read.do?boardNumber=${boardDto.boardNumber}&pageNumber=${currentPage}">${boardDto.subject}</a>
						</td>
						<!-- 작성자 -->
						<td align="center" width="70">${boardDto.writer}</td>
						
						<!-- 작성일 -->
						<td align="center" width="150">
							<fmt:formatDate value="${boardDto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						
						<!-- 조회수 -->
						<td align="center" width="50">${boardDto.readCount}</td>
					 </tr>
				 </c:forEach>
			</table>
		</div>
	</c:if>
	
	<div align="center">
		<%-- 
			1. 한 페이지당 게시물 수 : 10 
			2. 총 페이지 수: 10page = 전체레코드 수 100/ 한 페이지당 게시물 수 10 
						 11page = 전체레코드 수 101/ 한 페이지당 게시물 수 10
						 
			3. 페이지번호 블럭 : 10 
							[1][2][3][4][5]...[10]
							요청페이지번호 5이면 시작번호 1, 글번호 10
							
							pageBlock, currentPage : 시작번호, 끝번호
							
							int startPage=(int)((currentPage-1)/pageBlock)*pageBlock + 1
												(3-1)/10 = 0*10 + 1 = 1 
												(33-1)/10= 3*10 + 1 = 31
							int endPage=startPage+pageBlock-1
											1+10-1 = 10
											31+10-1 = 40
											
			4. boardSize, currentPage, count: Command Data
		--%>
		<fmt:parseNumber var="pageCount" value="${count/boardSize+(count%boardSize==0? 0:1)}" integerOnly="true"/>
		<c:set var="pageBlock" value="${2}"/>
		
		<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true"/>
		<c:set var="startPage" value="${result*pageBlock+1}"/>
		<c:set var="endPage" value="${startPage+pageBlock-1}"/>
		
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}"/>
		</c:if>
		<%-- ${startPage}, ${endPage}--%>
		
		<c:if test="${startPage > pageBlock}">
			<a href="${root}/fileBoard/list.do?pageNumber=${startPage-pageBlock}">[이전]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="${root}/fileBoard/list.do?pageNumber=${i}">[${i}]</a>
		</c:forEach>
		
		<c:if test="${endPage < pageCount }">
			<a href="${root}/fileBoard/list.do?pageNumber=${startPage+pageBlock}">[다음]</a>
		</c:if>
	</div>
</body>
</html>