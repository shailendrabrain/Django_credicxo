package template;
import service.AdminService;
import service.BeanContainer;

import java.util.*;

import model.Admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.epam.DemoApplication;

public class AdminTemplate implements Optioninf{

	static ApplicationContext context=BeanContainer.getContainer();
	
	AdminService adminService=context.getBean(AdminService.class);
 
	Admin admin=context.getBean(Admin.class);
   
	QuestionTemplate questionTemplate=new QuestionTemplate();//context.getBean(QuestionTemplate.class);
    
	QuizTemplate quizTemplate=new QuizTemplate();//context.getBean(QuizTemplate.class);
	
	private  Logger logger = LogManager.getLogger(AdminTemplate.class.getName());
	  
	
     public  void entryToAdmin() {
		showOption();
		 Scanner sc = ScannerFactory.getScanner();

		int option = 0;
		boolean checkForAdmin = false; 

		try {
			option = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException ime) {
			logger.error("error in try");
		}

		switch (option) {
		case 1:
			try {
				signup();
			} catch (Exception e) {
				logger.error("error in try block");
			}
			break;
		case 2:
			checkForAdmin=login();
			break;

		default:
			logger.info("invalid input");
			break;
		}

		if (checkForAdmin || option == 1)
			getOperation();
		else
			logger.info("invalid credential");

	}
	
   
   public  void signup() 
	{
		
		 String email;
		 String password;
		 String userName;
		 Scanner sc=ScannerFactory.getScanner();
		   logger.info("enter the username ");
		    userName=sc.nextLine();
			logger.info("Enter the email ");
			email=sc.nextLine();
	        logger.info("\nEnter the password: ");
			password=sc.nextLine(); 
			
			try {
		  admin= adminService.toSignUp(userName,email,password);
		   logger.info("admin in signup {} " , admin);
			}catch (Exception e) {
			logger.error(e);
			}
		if(admin!=null)
		 logger.info("file saved");	
		
	}
	
	public  boolean login()
	{
		boolean flag=false;
		Scanner sc=ScannerFactory.getScanner();
		String email;
		String password;
		logger.info("enter your email:");
		email=sc.nextLine();
		logger.info("enter your password: ");
		password=sc.nextLine();
	   admin= adminService.checkForAuthentication(email, password);	
	  logger.info("admin in login {} ", admin);
	   if(admin!=null)
	   {  flag=true; }
	   return flag;
	}
	
   
   
   public  void getOperation() {

		logger.info("WELCOME ADMIN ");
		Scanner sc = ScannerFactory.getScanner();
		String exit = "";
		int option = 0;
		do {

			logger.info("1. QUIZ");
			logger.info("2. QUESTION");
			logger.info("3. EXIT");
			logger.info("Choose your option");
			try {
				option = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException ime) {
				logger.error("error in try {0}" , ime);
			}

//			QuestionTemplate questionTemplate=context.getBean(QuestionTemplate.class);
//
//			QuizTemplate quizTemplate=context.getBean(QuizTemplate.class);
			
			switch (option) {
			case 1:
				 quizTemplate.entryToQuiz();
				break;
			case 2:
				  questionTemplate.entryToQuestionTemplate();
				break;
			case 3:
				DemoApplication.startProgram();
				break;
			default:
				logger.info("invalid input");
				break;
			}

			logger.info("enter yes to go back to quiz-question");
			try {
				exit = sc.nextLine();
			} catch (InputMismatchException ime) {
				logger.error("error in try");
			}
		} while (exit.equals("yes"));

	}


@Override
public void showOption() {
	logger.info("YOU ARE IN ADMIN PANEL\n");
	logger.info("1. SIGNUP");
	logger.info("2. LOGIN\n");
	logger.info("Choose your option");
	
}

	
	
	
	

}
