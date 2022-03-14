package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanContainer {

	static ApplicationContext container;
	
	private BeanContainer()
	{
		
	}
	public static ApplicationContext getContainer()
	{
		if(container==null)
		{
			container=new AnnotationConfigApplicationContext(BeanConfiguration.class);
		}
		return container;
	}
	
	
}
