package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import model.Admin;


@Component
@Controller
public  class AdminDatabase implements AdminInf{

	 EntityManager entityManager = EntityManagerF.getEntityManager();

	@Override
	public void insert(Admin admin)
	{
		entityManager.getTransaction().begin();
		entityManager.persist(admin);
		entityManager.getTransaction().commit();
	 
	}
	

	@Override
	public Admin view(int id)
	{
		return entityManager.find(Admin.class, id);
		
		
	}
	
	@Override
	public Admin authenticate(String email,String password)
	{
		Query query=entityManager.createQuery("select a from Admin a where email=:email and password=:password ");
		
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		List<Admin> admin=query.getResultList();
		
		
		return admin.get(0);
	}
	
	
	
}
