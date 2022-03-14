package database;

import java.util.List;

public interface Quizinf<T> {

	void insert(T t);
	void delete(T t);
	void delete(int quizCode);
	
	
	List<T> getAll();
	
	void upadate(T t);
	
//	List<T> getQuizQuestion();
	T getQuizByQuizCode(int quizCode);
  void deleteById(int id);	
}
