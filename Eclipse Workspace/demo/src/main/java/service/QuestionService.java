package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import database.QuestionInf;
import model.Question;

@Component
@ComponentScan("database")
public class QuestionService {
	
	
	@Autowired
	//@Qualifier("questionDatabase")
	QuestionInf<Question> questionDatabase;

	QuestionService() {

	}

	public QuestionService(QuestionInf<Question> jd) {
		questionDatabase = jd;

	}

	public boolean createQuestion(Question question) {

		boolean flag = false;
		if (question != null) {
			questionDatabase.insert(question);
			flag = true;
		}
		return flag;

	}

	public List<Question> getAllQuestion() {

		return questionDatabase.getQuestions();

	}

	public boolean updateQuestion(Question questionToUpdate) {
		boolean flag = false;
		if (questionToUpdate != null) {
			questionDatabase.updateQuestion(questionToUpdate);
			flag = true;
		}

		return flag;
	}

	public boolean deleteQuestionById(int id) {
		boolean flag = false;
		if (id > 0) {
			flag = questionDatabase.delete(id);

		}
		return flag;
	}

	public List<Question> getQuestionByTag(String tag) {
		List<Question> questions = null;
		if (tag != null)
			questions = questionDatabase.getQuestionByTag(tag);
		return questions;
	}

	public Question getQuestionById(int id) {
		Question question = null;
		if (id > 0) {
			question = questionDatabase.getQuestionById(id);

		}
		return question;
	}

}
