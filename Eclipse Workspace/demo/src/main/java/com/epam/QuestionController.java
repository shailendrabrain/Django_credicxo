package com.epam;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import model.Question;
import service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;

//	@RequestMapping("/createQuestion")
//	public ModelAndView insertQuestion(Question question, String option1, String option2, String option3, String option4) {
//		List<String> options = new ArrayList<String>();
//		options.add(option1);
//		options.add(option2);
//		options.add(option3);
//		options.add(option4);
//		question.setOptionList(options);
//
//		ModelAndView mv = new ModelAndView();
//		questionService.createQuestion(question);
//		mv.addObject("message", "question added successfully");
//
//		mv.setViewName("question");
//		return mv;
//	}

	
	@RequestMapping("/createQuestion")
	public ModelAndView insertQuestion(Question question ) {
//		List<String> options = new ArrayList<String>();
//		options.add(option1);
//		options.add(option2);
//		options.add(option3);
//		options.add(option4);
		//question.setOptionList(option);
System.out.println(question.getOptionList());
		ModelAndView mv = new ModelAndView();
		questionService.createQuestion(question);
		mv.addObject("message", "question added successfully");

		mv.setViewName("question");
		return mv;
	}
	
	
	@RequestMapping("/getQuestion")
	public ModelAndView getQuestions() {
		ModelAndView mv = new ModelAndView();
		List<Question> questionList = questionService.getAllQuestion();

		mv.addObject("questions", questionList);
		mv.setViewName("viewQuestion");
		return mv;
	}

	@RequestMapping("/deleteQuestion/{id}/")

	public String deleteQuestion(@PathVariable int id) {
		System.out.println("question id is " + id);
		questionService.deleteQuestionById(id);
		return "redirect:/getQuestion";
	}
	
	@RequestMapping(value="/updateQuestion/{id}/")
	public ModelAndView updateQuestion(@PathVariable int id)
	{
		ModelAndView mv=new ModelAndView();
		System.out.println("questoin to update id   " +id);
		mv.setViewName("/updateQuestion");
		Question question=questionService.getQuestionById(id);
		System.out.println(question);
		mv.addObject("question", question);
		
		return mv;	
	}
	
	@RequestMapping("/updateNewQuestion")
	public String putQuestion(Question question)
	{
//		List<String> options = new ArrayList<String>();
//	 options.add(option1);
//	 options.add(option2);
//	 options.add(option3);
//	 options.add(option4);
//	 question.setOptionList(options);
	Question q=questionService.getQuestionById(question.getId());	
	q.setDifficulty(question.getDifficulty());
	q.setOptionList(question.getOptionList());
    q.setQuestion(question.getQuestion());
    q.setQuestionTag(question.getQuestionTag());
    q.setRightoption(question.getRightoption());
	questionService.updateQuestion(q);    
    return "redirect:/getQuestion";
	}
	

}
