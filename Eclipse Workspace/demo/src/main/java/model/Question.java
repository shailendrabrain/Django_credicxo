package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

 



@Component
@Entity
@Table(name = "Questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String questionTag;
	String questionT;
	@ElementCollection
	@CollectionTable(name = "questionOptions" )
	@Cascade(CascadeType.REMOVE)
	List<String> optionList=new ArrayList<>();
	String difficulty;
	int rightoption;
	
	public int getRightoption() {
		return rightoption;
	}
	public void setRightoption(int rightoption) {
		this.rightoption = rightoption;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionTag() {
		return questionTag;
	}
	public void setQuestionTag(String questionTag) {
		this.questionTag = questionTag;
	}
	public String getQuestion() {
		return questionT;
	}
	public void setQuestion(String question) {
		this.questionT = question;
	}
	public List<String> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<String> optionList) {
		this.optionList = optionList;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public Question()
	{
		
	}
	
	public Question(int id, String questionTag, String question, List<String> optionList, String difficulty) {
		super();
		this.id = id;
		this.questionTag = questionTag;
		this.questionT = question;
		this.optionList = optionList;
		this.difficulty = difficulty;
	}
	@Override
	public String toString() {
		return "QuestionJpa [id=" + id + ", questionTag=" + questionTag + ", question=" + questionT + ", optionList="
				+ optionList + ", difficulty=" + difficulty +"right option "+rightoption+ "]";
	}
	
	
	
	
	
	
	
	
	
	
}
