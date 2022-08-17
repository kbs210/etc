<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	<table border = "1">
		<%for(int i=2; i<=9; i++){%>
			<tr align='center'>
			<%for(int j=1; j<=9; j++){%>
				<%if(j%2==0){%>
					<td style='background:pink'>
				<%} else {%>
					<td style='background:skyblue'>
				<%}%>
				<%=i%> * <%=j%> = <%=i*j%>
				</td>
				<%}%>	
			</tr>
		<%}%>
	</table>
-->	

<!--
<div align='center'>
	<h3>구구단1</h3>
	<table border="1" width="800" height="800">
		<%
			String color="";
			for(int i=1; i<10; i++){
				out.print("<tr>");
				for(int j=2; j<10; j++){
					color = j%2 == 0 ? "pink" : "skyblue";
					out.print("<td bgcolor=\"" + color + "\" align=\"center\" >" + j + " * " + i + " = " + i*j + "</td>");
				}
				out.print("</tr>");
			}
		%>	
	</table>
</div>
 -->


<div align='center'>
	<h3>구구단2</h3>
	<table border="1" width="800" height="800">
		<%String color2="";%>
		<%for(int i=1; i<10; i++){%>	
			<tr>
			<%for(int j=2; j<10; j++){
				color2 = j%2 == 0 ? "pink" : "skyblue";%>
				<td bgcolor="<%= color2%>" align="center">
				<%=j + " * " + i + " = " + j*i%>
				</td>
			<%}%>
			</tr>	
		<%}%>
	</table>
</div>

</body>
</html>


















