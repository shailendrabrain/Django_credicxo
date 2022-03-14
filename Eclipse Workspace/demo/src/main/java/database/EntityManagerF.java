package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EntityManagerF {

	@PersistenceContext
	static EntityManagerFactory emf;
	static EntityManager em=null;
	
	private EntityManagerF()
	{
		
	}
	
	static EntityManager getEntityManager()
	{
		if(em==null)
		{
			emf=Persistence.createEntityManagerFactory("my-local-mysql");
			em=emf.createEntityManager();
			
		}
		return em;
		
	}
	
	
}
