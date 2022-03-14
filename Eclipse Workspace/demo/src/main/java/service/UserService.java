package service;

import database.QuizDatabase;
import database.UserDatabase;
import database.Userinf;
import model.Question;
import model.Quiz;
import model.User;
import template.*;

import java.util.List;

import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
//@ComponentScan("")
public class UserService {

	@Autowired
	private  Userinf< User> userDatabase;
	//	private  Userinf< User> userDatabase=new UserDatabase();
	
	//QuizService quizService=new QuizService(new QuizDatabase<Quiz>());

	QuizService quizService;
	
	@Autowired
	public void  UserService(QuizService quizServie)
	{
		this.quizService=quizServie;
	}
	
	public void setQuizService(QuizService quizService)
	{
		this.quizService=quizService;
	}
	
	
	
	public User createUserObject(String name, String email,String password) {
		User user = null;
		if (name != null && email != null)
		{
					user = new User(name, email,password);
		             userDatabase.insert(user);
			
		}
		return user;
	}

	public boolean startQuiz(User user, int quizCode) {
		boolean flag = false;
 
		List<Question> questionList;
		if (user != null && quizCode >= 0) {
			questionList = quizService.getQuestion(quizCode);
			System.out.println("in questoinlist "+questionList);
			if (questionList != null) {
				if (!questionList.isEmpty()) {
					
					int score = this.doQuiz(questionList);
					flag = userDatabase.addUserQuiz(user, quizCode, score);
				}
			}
		}
		return flag;

	}

	public int doQuiz(List<Question> questionList) {
		
		System.out.println("in do quiz method");
		int[] userAnswers ;
		int score = -1;
		if (questionList != null) {
			 
				int userOption = -1;
				userAnswers = new int[questionList.size()];
				int index = 0;
				List<String> tempList = new ArrayList<>();

				for (Question question : questionList) {

					tempList.add(question.getQuestion());
					tempList.add(question.getOptionList().get(0));
					tempList.add(question.getOptionList().get(1));
					tempList.add(question.getOptionList().get(2));
					tempList.add(question.getOptionList().get(3));

					userOption = UserTemplate.putQuestion(tempList);
					userAnswers[index++] = userOption;
					tempList.clear();
				
				score = this.calculateScore(userAnswers, questionList);
			}
		}

		return score;
	}

	public int calculateScore(int []userAnswers, List<Question> questionList) {
		int score = 0;
		int count = 0;
		if (questionList != null && userAnswers != null)
			for (Question q : questionList) {
				if (q.getRightoption() == userAnswers[count++])
					score++;
			}

		return score;
	}

	public User viewProfile(User user) {

		User userTo = null;
		if (user != null) {
			Optional<User> user1;
			List<User> userList = userDatabase.getAllUser();
			if (userList.isEmpty()) {

				Stream<User> userStream = userList.stream();
				user1 = userStream.filter(userTemp -> userTemp.getName().equalsIgnoreCase(user.getName()))
						.filter(user12 -> user12.getEmail().equalsIgnoreCase(user.getEmail())).findFirst();

				if(user1.isPresent())
				{
				userTo = user1.get();
				}
			}
		}
		return userTo;
	}
	
	public void insertUser(User user)
	{
		userDatabase.insert(user);
	}

	public User authenticateUser(User user) {
		User temp=userDatabase.find(user);
		return temp;
	}

	public User getUser(int id) {
		 User user=userDatabase.getUser(id);
		return user;
	}

}
