<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>
ID:
</th>
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
<c:forEach var="question" items="${questionList}">

<tr>
<td>
${question.id}
</td>
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

<a href="viewQuiz.jsp">click to go back</a>
</body>
</html>