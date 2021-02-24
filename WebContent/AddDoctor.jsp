<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="color: red;font-size: 20px">
${failure}
</div>
<form action="DoctorServlet" method="post">
<input type="hidden" name="operation" value="adddoc">
<table align="center" > 
<caption> Add Doctor</caption>
<tr> <td> Name : </td> <td><input type="text" name="docname" ></td></tr>
<tr> <td> Specialization : </td> <td> <input type="text" name="docspl"></td></tr>
<tr> <td> Qualification : </td> <td> <input type="text" name="docqual"></td></tr>
<tr> <td> <input type="submit" value="Add"> </td><td> <input type="reset" value="Cancel"></td></tr>
</table>
</form>
</body>
</html>