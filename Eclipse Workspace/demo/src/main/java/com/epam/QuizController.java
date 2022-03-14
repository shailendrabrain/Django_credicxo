package com.epam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Question;
import model.Quiz;
import service.QuestionService;
import service.QuizService;

@Controller
public class QuizController {

	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;
	
@RequestMapping("createQuiz")
public String makeQuiz(Quiz quiz, String questionTag)
{
	
	List<Question> questionList=questionService.getQuestionByTag(questionTag);
	quiz.setQuestionList(questionList);
	quizService.createQuiz(quiz);
	return "quiz";
}

@RequestMapping("getQuiz")
public ModelAndView getQuiz()
{
	ModelAndView mv=new ModelAndView();
	List<Quiz> quizList=quizService.getQuizList();
	
	mv.addObject("quizList", quizList);
	mv.setViewName("viewQuiz");
	
	return mv;
}

@RequestMapping("showQuizQuestion")
public ModelAndView showQuizQuestion(@PathVariable String questionTag)
{
	
	System.out.println("in show question "+questionTag);
	List<Question> ql=questionService.getQuestionByTag(questionTag);
	ModelAndView mv=new ModelAndView();
	mv.setViewName("showQuizQuestion");
 mv.addObject("questionList", ql);
 
 return mv;

}

@RequestMapping("deleteQuiz/{id}")
public String deleteQuiz(@PathVariable int id)
{
	quizService.deleteQuizById(id);
  return "redirect:/getQuiz";
}


}
