<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="hospital.pojo.Doctor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DoctorServlet" method="post">
<div style="color:red;font-size:20px">
${failure}
</div>
<input type="hidden" name="operation" value="updatedoc"/>  
<%
Doctor d=(Doctor) session.getAttribute("doctorobj");
%>
<table align="center" > 
<caption> Update Doctor</caption>
<tr> <td> Doctor Id </td> <td> <input type="text" name="docid" value=<%=d.getDoc_id()%> readonly="readonly"></td></tr>
<tr> <td> Name : </td> <td><input type="text" name="docname" value=<%=d.getDoc_name()%>></td></tr>
<tr> <td> Specialization : </td> <td> <input type="text" name="docspl" value=<%=d.getDoc_spl()%>></td></tr>
<tr> <td> Qualification : </td> <td> <input type="text" name="docqual" value=<%=d.getDoc_qual()%>></td></tr>
<tr> <td> <input type="submit" value="Update"> </td><td> <input type="reset" value="Cancel"></td></tr>
</table>
</form>
</body>
</html>