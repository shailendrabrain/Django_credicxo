<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="resources/anchor.css" rel="stylesheet" >
<!-- <link href="resources/form.css" rel="stylesheet"> -->
<link href="resources/table.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<tr>

<th>NAME</th>
<th>EMAIL</th>
</tr>
<tr>

<td> ${user.name }</td>
<td> ${user.email }</td>

</tr>




</table>

<a href="userWelcome.jsp">click to go home</a>
</body>
</html>