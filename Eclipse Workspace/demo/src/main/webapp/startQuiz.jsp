<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/anchor.css" rel="stylesheet" >
<link href="resources/form.css" rel="stylesheet">
<link href="resources/table.css" rel="stylesheet">
</head>
<body>
	Quiz started
	<br>
	<br>
	<c:forEach var="question" items="${questions }">
    ${question.question}
<br>
		<c:forEach var="option" items="${question.optionList}">


			<input type="radio" name="right${question.id }" value="${option}" id="op">
			<label for="op">${option }</label>
			<br>
		</c:forEach>


  
		
		<br>
		<br>
	</c:forEach>




<a href="calculateScore">submit</a>


</body>
</html>