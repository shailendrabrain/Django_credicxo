package database;

import java.util.List;

import org.springframework.stereotype.Component;


public interface QuestionInf<T> {

	void insert(T t);
	List<T> getQuestions();
	
	//boolean delete(T t );
	boolean delete(int id);
	
	
    void updateQuestion(T t );
   
     
    List<T> getQuestionByTag(String tag);
	
    T getQuestionById(int id);
	
	
	
}
