<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link href="resources/anchor.css" rel="stylesheet" > -->
<link href="resources/form.css" rel="stylesheet">
<!-- <link href="resources/table.css" rel="stylesheet"> -->


<title>Insert title here</title>
</head>
<body>
you are in update question


<form action="/updateNewQuestion" method="post">
         <br>
         <input type="hidden" name=id value="${question.id}" >
         <br>
		update the question tag: <input type="text" name="questionTag" placeholder="${question.questionTag}" value="${question.questionTag}">
		<br> update the question <input type="text" name="question" placeholder="${question.question}" value="${question.question}">
		<br> update the option 1: <input type="text" name="option" placeholder="${question.optionList.get(0) }" value="${question.optionList.get(0) }">
		<br> update the option 2: <input type="text" name="option" placeholder="${question.optionList.get(1) }" value="${question.optionList.get(1) }">
		<br> update the option 3: <input type="text" name="option" placeholder="${question.optionList.get(2) }" value="${question.optionList.get(2) }">
		<br> update the option 4: <input type="text" name="option" placeholder="${question.optionList.get(3) }" value="${question.optionList.get(3) }">
		<br> update the difficulty    <input type="radio" id="easy" name="difficulty" value="easy" checked="checked">
		<label for="easy">EASY</label>
		  <input type="radio" name="difficulty"value="medium" id="medium">
		  <label for="medium">MEDIUM</label>
		 <input type="radio" name="difficulty"value="hard" id="hard">
		 <label for="hard">HARD</label>
			 <br> 
			 update the right option
			  <input type="number" name="rightoption" placeholder="${question.rightoption }" value="${question.rightoption }" min="1" max="4">
			 
			   <input type="submit">

	</form>


</body>
</html>