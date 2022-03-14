package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Entity
@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Quiz {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int id;
	@Column(name = "title")
	String quizTitle;
	
	int quizCode;
	
	@ManyToMany
	@JoinColumn(name = "quizandQuestion")
	List<Question>questionList=new ArrayList<>();

	public Quiz()
	{
		
	}
	
	public Quiz( String quizTitle, int quizCode, List<Question> questionList) {
		
		this.quizTitle = quizTitle;
		this.quizCode = quizCode;
		this.questionList = questionList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public int getQuizCode() {
		return quizCode;
	}

	public void setQuizCode(int quizCode) {
		this.quizCode = quizCode;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "QuizJpa [id=" + id + ", quizTitle=" + quizTitle + ", quizCode=" + quizCode + ", questionList="
				+ questionList + "]";
	}
	

	
}
