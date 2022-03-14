<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="resources/form.css" rel="stylesheet">
<link href="resources/anchor.css" rel="stylesheet" >
<link href="resources/table.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<form action="createQuiz">
<label for="quizt">enter the quiz title</label>
<input type="text" name="quizTitle" id="quizt">
<br>
<label for="quizc">enter the quiz code</label>
<input type="number" name="quizCode" id="quizc">
<br>
<label for="questiont">enter the tag of question to filter</label>
<input type="text" name="questionTag" id="questiont">
<br>
<input type="submit">
</form>


</body>
</html>