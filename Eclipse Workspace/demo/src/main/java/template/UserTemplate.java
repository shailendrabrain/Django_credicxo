package template;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;

import model.User;
import service.BeanContainer;
import service.UserService;

public class UserTemplate {

	private UserTemplate()
	{
		
	}
	private static ApplicationContext context=BeanContainer.getContainer();
	private static final Logger logger = LogManager.getLogger(UserTemplate.class.getName());
    private static UserService userService=context.getBean(UserService.class);
	
    
    
    public static void entryToUser() {
		logger.info("YOU ARE IN USER PAGE");

		Scanner scanner = ScannerFactory.getScanner();
		String name;
		String email;
		String password;
		logger.info("enter the name: ");
		name = scanner.nextLine();
		logger.info("enter the email: ");
		email = scanner.nextLine();

		logger.info("enter password ");
		password=scanner.nextLine();
		
           User user=userService.createUserObject(name, email,password);
		
		String exit;

		do {

			logger.info("YOUR AVAILABLE OPERATION");
			logger.info("1. START QUIZ");
			logger.info("2. VIEW PROFILE");
			logger.info("3. EXIT");
			int option = 0;
			logger.info("enter you option: ");
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException ime) {
				logger.error("invalid input {0}" , ime);
				option = 3;
			}

			switch (option) {
			case 1:
				logger.info("enter the quiz code");
				int quizCode = 0;
				try {
					quizCode = Integer.parseInt(scanner.nextLine());
					logger.info("quiz started ");
					userService.startQuiz(user,quizCode);
				} catch (NumberFormatException ime) {
					logger.error("invalid input {0} " , ime);

				}

				break;
			case 2:
				new UserService().viewProfile(user);
				break;
			case 3:

				break;

			default:
				break;
			}
			logger.info("press yes to continue ");
			exit = scanner.nextLine();

		} while (exit.equals("yes"));
	}

	public static int putQuestion(List<String> questionToShow) {

		System.out.println("in putQuestion method");
		int userInput = 0;

		Scanner scanner = ScannerFactory.getScanner();

		logger.info("\nyour question:     ");
		logger.info(questionToShow.get(0));
		logger.info("1. {} " , questionToShow.get(1));
		logger.info("2. {} " , questionToShow.get(2));
		logger.info("3. {} " , questionToShow.get(3));
		logger.info("4. {} " , questionToShow.get(4));

		logger.info("enter your option: ");
		try {
			userInput = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException nfe) {
			logger.error(nfe);
		}
		return userInput;
	}

}
