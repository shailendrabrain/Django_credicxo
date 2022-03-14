package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Question;

@Component("questionBean")
public class QuestionDatabase<T> implements QuestionInf<T> {

	EntityManager em = EntityManagerF.getEntityManager();
  
   
   @Override
	public void insert(T t) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(t);
		et.commit();

	}

	public boolean delete(int id) {
		boolean flag = true;
		try {
			em.getTransaction().begin();
			Question qj = em.find(Question.class, id);
			em.remove(qj);
			em.getTransaction().commit();
		} catch (Exception c) {
			System.out.println("this operation can not be performed due to constraint");
			flag = false;
		}
		return flag;
	}

	@Override
	public void updateQuestion(T o) {
		em.getTransaction().begin();
		em.persist(o);

		em.getTransaction().commit();

	}

	@Override
	public List<T> getQuestionByTag(String tag) {
		em.getTransaction().begin();

		Query q = em.createQuery("select q from Question q where questionTag=:tag");
		q.setParameter("tag", tag);
		List<T> list = q.getResultList();
		em.getTransaction().commit();
		return list;
	}

	@Override
	public T getQuestionById(int id) {
		return (T) em.find(Question.class, id);

	}

	@Override
	public List<T> getQuestions() {
		Query q = em.createQuery("FROM Question ");
		return q.getResultList();

	}

}
