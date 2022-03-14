<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link href="resources/anchor.css" rel="stylesheet" >
<!-- <link href="resources/form.css" rel="stylesheet"> -->
<link href="resources/table.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

you are in view quiz

<table border="1">
<tr>
<th>ID:</th>
<th>Title:</th>
<th>Quizcode:</th>
<th>delete</th>

</tr>

<c:forEach var="quiz" items="${quizList}">

<tr>
<td>
${quiz.id}
</td>
<td>
${quiz.quizTitle}
</td>
<td>
${quiz.quizCode}
</td>
<td>
<a href="deleteQuiz/${quiz.id}">delete</a>
</td>
</tr>
</c:forEach>
</table>

<a href="quiz.jsp">click to go quiz</a>

</body>
</html>