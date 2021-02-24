<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "java.util.List,hospital.pojo.Doctor" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List <Doctor> list= (List<Doctor>) session.getAttribute("doctorlist");%>
<div style="color:green;font-size:20px">
${success}
</div>
<div style="color:red;font-size:20px">
${failure}
</div>

<table border="1" style="border-collapse: collapse;">
	<tr>
		<th>Name</th>
		<th>Specialization</th>
		<th>Qualification</th>
	</tr>
	<%-- <tr>
		<td>${d.doc_name}</td>
		<td>${d.doc_spl}</td>
		<td>${d.doc_qual}</td>
		</tr> --%>
		
		<%
	for(Doctor d:list){
	%>
	<tr>
		<td><%=d.getDoc_name()%></td>
		<td><%=d.getDoc_spl()%></td>
		<td><%=d.getDoc_qual()%></td>
		<td> <a href="DoctorServlet?operation=delete&docId=<%=d.getDoc_id()%>"> Delete / </a></td> 
		<td> <a href="DoctorServlet?operation=getDoc&docId=<%=d.getDoc_id()%>"> Edit</a></td>
	</tr>
<%} %>
</table>
</body>
</html>