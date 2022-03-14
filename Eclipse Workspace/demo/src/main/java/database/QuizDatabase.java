package database;

import java.util.List;

import javax.persistence.EntityManager;import javax.persistence.Query;

import org.springframework.stereotype.Component;

import model.Quiz;



@Component
public class QuizDatabase<T> implements Quizinf<T> {

  EntityManager entityManager = EntityManagerF.getEntityManager();

	@Override
	public void insert(T t) {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void delete(T t) {
       entityManager.getTransaction().begin();
		entityManager.remove(t);
		entityManager.getTransaction().commit();
		

		
	}

	@Override
	public List<T> getAll() {
    Query q=entityManager.createQuery("from Quiz");
  return q.getResultList();

		
	}

	@Override
	public void upadate(T t) {
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		
	}

//	@Override
//	public List<T> getQuizQuestion() {
//	  List<T>list=null;
//		entityManager.createQuery("select ");
//		return list;
//	}

	@Override
	public T getQuizByQuizCode(int quizCode) {
		
		Query query=entityManager.createQuery("select q from Quiz q where quizCode=:quizCode");
		query.setParameter("quizCode", quizCode);
		List<Quiz>quizs=query.getResultList();
		if(quizs.size()!=0)
			return (T) quizs.get(0);
		return null;
		
		
	}

	@Override
	public void delete(int quizCode) {
		
		T t=getQuizByQuizCode(quizCode);
		 entityManager.getTransaction().begin();
			entityManager.remove(t);
			entityManager.getTransaction().commit();
			
		
		
	}

	@Override
	public void deleteById(int id) {
		Quiz quiz=entityManager.find(Quiz.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(quiz);
		entityManager.getTransaction().commit();
		
	}

}
