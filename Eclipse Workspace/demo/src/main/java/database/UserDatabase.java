package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import model.Admin;
import model.User;

@Component
@Controller
@EntityScan("model")
public class UserDatabase implements Userinf<User> {

	private  EntityManager entityManager=EntityManagerF.getEntityManager();

	@Override
	public boolean insert(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		
		return true;
	}

	@Override
	public User getUser(int id) {
		
		return entityManager.find(User.class, id);
	}

	@Override
	public boolean addUserQuiz(User user, int score, int quiz) {
	user.getScore().put(score, quiz);
		insert(user);
	return true;
	}	

	@Override
	public List<User> getAllUser() {
		
		return entityManager.createQuery("select u from User u").getResultList();
	}

	@Override
	public User find(User user) {
Query query=entityManager.createQuery("select u from User u where email=:email and password=:password ");
		
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		
		List<Admin> admin=query.getResultList();
		List<User>users=query.getResultList();
		User u=null;
		if(!users.isEmpty())
		     u=users.get(0);
		return u;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
