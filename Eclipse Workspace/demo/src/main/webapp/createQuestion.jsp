<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="resources/form.css" rel="stylesheet">
<link rel="stylesheet" href="resources/anchor.css">
<link href="resources/table.css" rel="stylesheet">
</head>
<body>
	<form action="createQuestion" method="post">
		enter the question tag:<input type="text" name="questionTag"
			placeholder="enter question tag"> <br> 
			enter the		question <input type="text" name="question"
			placeholder="enter question"> <br> 
			enter the option 1: <input type="text" name="optionList" placeholder="enter option 1"> <br>
		enter the option 2: <input type="text" name="optionList"placeholder="enter option"> <br>
		 enter the option 3: <input		type="text" name="optionList" placeholder="enter option 3"> <br>
		enter the option 4:
		 <input type="text" name="optionList"	placeholder="enter option"> <br> enter the difficulty <input
			type="radio" id="easy" name="difficulty" value="easy"> <label
			for="easy">EASY</label> <input type="radio" name="difficulty"
			value="medium" id="medium"> <label for="medium">MEDIUM</label>
		<input type="radio" name="difficulty" value="hard" id="hard">
		<label for="hard">HARD</label> <br> enter the right option <input
			type="number" name="rightoption" min="1" max="4"
			placeholder="enter right option"> <input type="submit">


	</form>



</body>
</html>