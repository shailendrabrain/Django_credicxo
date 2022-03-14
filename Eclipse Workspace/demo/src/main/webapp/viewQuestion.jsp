<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="resources/anchor.css" rel="stylesheet" >
<!-- <link href="resources/form.css" rel="stylesheet"> -->
<link href="resources/table.css" rel="stylesheet">
<!-- <link href="resources/table.css" rel="stylesheet"> -->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
you are in view question

<table border="1">
<tr>

<th>
Tag:
</th>
<th>
QUESTION:
</th>

<th>
DIFFICULTY
</th>
<th>
ACTION
</th>
<th>
ACTION
</th>
</tr>
<c:forEach var="question" items="${questions}">

<tr>

<td>
${question.questionTag}
</td>
<td>
${question.question}
</td>
<td>
${question.difficulty }
</td>
<td>
<a href="deleteQuestion/${question.id}/"> delete</a>
</td>
<td>
<a href="updateQuestion/${question.id}/">update</a>
</td>
</tr>




</c:forEach>

</table>

<a href="question.jsp">Question Menu</a>

</body>
</html>