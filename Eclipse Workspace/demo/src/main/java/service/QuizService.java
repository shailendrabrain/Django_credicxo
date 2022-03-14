package service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import database.Quizinf;

import model.Question;
import model.Quiz;

@Component
@ComponentScan({"database","model"})
public class QuizService {
	static ApplicationContext context = BeanContainer.getContainer();

	@Autowired
	private Quizinf<Quiz> quizDatabase;

	public QuizService(Quizinf<Quiz> qj) {
		quizDatabase = qj;
	}

	public boolean prepareQuiz(String quizTitle, int quizCode, List<Question> questionList) {
		boolean flag = false;

		if (questionList != null && !quizTitle.isEmpty() && quizCode >= 0) {
			Quiz qj = context.getBean(Quiz.class);
			qj.setQuestionList(questionList);
			qj.setQuizCode(quizCode);
			qj.setQuizTitle(quizTitle);
			try {

				quizDatabase.insert(qj);
			} catch (Exception e) {
				System.out.println("exception in perparequiz method");
			}
			flag = true;
		}
		return flag;
	}

	public List<Quiz> getQuizList() {
		return quizDatabase.getAll();

	}

	public boolean deleteQuiz(int quizCode) {
		boolean flag = false;
		if (quizCode > 0) {
			Optional<Quiz> quiz = Optional.ofNullable(quizDatabase.getQuizByQuizCode(quizCode));
			if (quiz.isPresent()) {
				System.out.println("quiz in deletequiz " + quiz.get());
				quizDatabase.delete(quiz.get());
				flag = true;
			}

		}
		return flag;

	}

	public boolean updateQuizTitle(int quizCode, String quizTitle) {
		boolean flag = false;
		if (quizCode > 0 && !quizTitle.isEmpty()) {
			Optional<Quiz> quiz = Optional.ofNullable(quizDatabase.getQuizByQuizCode(quizCode));
			if (quiz.isPresent()) {
				flag = true;
				quiz.get().setQuizTitle(quizTitle);
				quizDatabase.insert(quiz.get());
			}
		}

		return flag;
	}

	public List<Question> getQuestion(int quizCode) {
		List<Question> questionList = null;

		Optional<Quiz> quiz = Optional.ofNullable(quizDatabase.getQuizByQuizCode(quizCode));
		if (quiz.isPresent()) {

			questionList = quiz.get().getQuestionList();
		}
		return questionList;
	}

	public Quiz getQuizByQuizCode(int quizCode) {
		return quizDatabase.getQuizByQuizCode(quizCode);

	}

	public int generateQuizCode() {
		int code = 0;
		Random r = new Random();

		for (int i = 1; i <= 6; i++) {
			code = code * 10 + (1 + r.nextInt(9));
		}

		return code;
	}

	public void createQuiz(Quiz quiz)
	{
		quizDatabase.insert(quiz);
	}
	
	public void deleteQuizById(int id)
	{
		quizDatabase.deleteById(id);
	}
	
	
	
//	public boolean isQuiz(int quizCode) {
//		Quiz qj = quizDatabase.getQuizByQuizCode(quizCode);
//		boolean flag = true;
//		if (qj == null)
//			flag = false;
//		return flag;
//	}

}
