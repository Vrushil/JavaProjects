<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="addAlien">
Aid:<input type="text" name="aid"><br>
AName <input type="text" name="aname"><br>
tECH<input type="text" name="tech"><br>
<!-- Major <input type="text" name="major"><br>
GPA <input type="text" name="gpa"><br>
 --><input type="submit" value="SUMBIT" >
</form>

<br>
<br>
<form action="getAlien">
Aid:<input type="text" name="aid"><br>
<input type="submit" value="SUMBIT" >
</form>
<%-- Hello to home page

Welcome ${emailid}
 --%>
<%-- User 's name is ${name} 
 --%> </body>
</html>