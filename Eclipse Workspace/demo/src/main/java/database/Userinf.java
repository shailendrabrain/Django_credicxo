package database;

import java.util.List;

import model.User;

public interface Userinf<T> {

	boolean insert(T t);
	T getUser(int id);
	boolean addUserQuiz(T t,int score,int quiz );
	List<T> getAllUser();
	User find(User user);
	User find(int id);
	
	
	
}
