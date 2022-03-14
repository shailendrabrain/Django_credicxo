package com.epam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Question;
import model.User;
import service.QuestionService;
import service.QuizService;
import service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	QuestionService questionService;
	@Autowired
	QuizService quizService;
	
	
	int id=0;
  
	
	@RequestMapping("loginuser")
	public ModelAndView getUser(User user)
	{
		ModelAndView mv=new ModelAndView();
		String message="invalid user credential";
		mv.addObject("message", message);
		mv.setViewName("user");
		User userdata=userService.authenticateUser(user);
		
		if(userdata!=null)
		{
			mv.setViewName("userWelcome");
			mv.addObject("message", "welcome user home page");
		}
		id=userdata.getId();
		return mv;
	}
	
	@RequestMapping("userSignup")
	public String  userSignup(User user)
	{
		userService.insertUser(user);
		return "userLogin";
	}
	
	@RequestMapping("userQuiz")
	public ModelAndView startQuiz(int quizCode)
	{
		ModelAndView mv=new ModelAndView();
	    String message="invalid quiz code";
	   mv.setViewName("userQuiz");
		
	   List<Question>questions=quizService.getQuestion(quizCode);
		
		if(questions!=null)
		{
			mv.addObject("questions", questions);
		    mv.setViewName("startQuiz");	
		}
		
	return mv;	
	}
	
	@RequestMapping("calculateScore")
	public ModelAndView check()
	{
		ModelAndView  mv=new ModelAndView();
		mv.setViewName("userWelcome");
		mv.addObject("message", "quiz submitted successfully");
		return mv;
	}
	
	@RequestMapping("userProfile")
	public ModelAndView viewProfile()
	{
		ModelAndView mv=new ModelAndView();
		User user=userService.getUser(id);
		mv.addObject("user", user);
		mv.setViewName("userProfile");
		return mv;
	}
	
}
