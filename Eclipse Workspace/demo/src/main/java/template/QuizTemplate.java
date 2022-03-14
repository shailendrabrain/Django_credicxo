package template;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import database.QuestionDatabase;
import database.QuizDatabase;
import model.Question;
import model.Quiz;
import service.BeanContainer;
import service.QuestionService;
import service.QuizService;

@Component
public class QuizTemplate implements Optioninf {

	static ApplicationContext context=BeanContainer.getContainer();	
	QuizService quizService=context.getBean(QuizService.class);
	private static final Logger logger = LogManager.getLogger(QuizTemplate.class.getName());

	
	public void entryToQuiz() {
		logger.info("READY TO MAKE QUIZ\n");
		
		Scanner scanner = ScannerFactory.getScanner();

		String exit = "";
		int option = 0;
		try {
			do {
				this.showOption();
				try {
					option = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException ime) {
					option=6;
					logger.error("invalid input {0} " , ime);
                       
				}

				switch (option) {
				case 1:
					this.prepareQuiz();
					break;
				case 2:
					this.viewQuiz();
					break;
				case 3:
					quizDeleteEx(scanner);
					break;
				case 4:
					updateQuizEx(scanner);

					break;

				case 5:
					quizQuestionEx(scanner);

					break;
				case 6:

					break;

				default:

					break;
				}

				logger.info("press yes to continue ");
				try {
					exit = scanner.nextLine();
				} catch (InputMismatchException ime) {
					logger.error("invalid input {0} " , ime);
				}
			} while (exit.equals("yes"));
		} catch (Exception e) {
			logger.info(e);
		}
	}


	private void quizQuestionEx(Scanner scanner) {
		logger.info("enter the quiz code ");
		int code1 = 0;
		try {
			code1 = Integer.parseInt(scanner.nextLine());
		 getQuizQuestion(code1);
		} catch (NumberFormatException nfe) {
			logger.error(nfe);
		}
	}


	private void updateQuizEx(Scanner scanner) {
		logger.info("enter the quiz code of quiz you want to update");
		int quizCode = 0;
		try {
			quizCode = Integer.parseInt(scanner.nextLine());
			updateQuiz(quizCode);
		} catch (NumberFormatException nfe) {
			logger.error("invalid number formate {0}" , nfe);
		}
	}


	private void quizDeleteEx(Scanner scanner) {
		logger.info("enter the quiz code to delete");
		int code = 0;
		try {
			code = Integer.parseInt(scanner.nextLine());
			deleteQuiz(code);
		} catch (NumberFormatException ime) {
			logger.error("invalid input {0}" , ime);
		}
	}

	public  void prepareQuiz() {

		try {
			String quizTag = "";
			Scanner scanner = ScannerFactory.getScanner();

			logger.info("enter the quiz title");
			quizTag = scanner.nextLine();
			int quizCode = quizService.generateQuizCode();
			String tag;
			logger.info("enter the tag of question to filter: ");
			tag = scanner.nextLine();

			List<Question> questionList = new QuestionService(new QuestionDatabase<>()).getQuestionByTag(tag);

			if (questionList.isEmpty()) {
				logger.info("first add question");

			} else {

                    questionList.parallelStream().forEach(System.out::println);

                    quizService.prepareQuiz(quizTag, quizCode, questionList);

			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

	public  void getQuizQuestion(int quizCode) {

		List<Question> questions = quizService.getQuestion(quizCode);
		if (questions == null)
			logger.info("wrong quizcode ");
		else {
			questions.parallelStream().forEach(System.out::println);
		}

	}

	public  void updateQuiz(int quizCode) {
		boolean flag = false;
		Scanner scanner = ScannerFactory.getScanner();
		logger.info("enter the new quiz title ");
		String quizTitle = scanner.nextLine();

		flag = quizService.updateQuizTitle(quizCode, quizTitle);

		if (!flag) {
			logger.error("invalid quiz code");
		}

	}

	public  void viewQuiz() {
		List<Quiz> quizList = quizService.getQuizList();
		if (quizList.isEmpty())
			logger.error("No avialable quiz");
		else {
			quizList.parallelStream().forEach(System.out::println);
		}
	}

	public  void deleteQuiz(int quizCode) {
		boolean flag = false;
		flag = quizService.deleteQuiz(quizCode);

		if (!flag) {
			logger.info("invalid quiz code");
		}

	}
	
//	 static void addQuestionToQuiz()
//	{
//		 int quizCode=0;
//		 logger.info("enter the quiz code");
//		 Scanner sc=ScannerFactory.getScanner();
//		 quizCode=Integer.parseInt(sc.nextLine());
//		
//		
//	}


	@Override
	public void showOption() {
		logger.info("AVIALABLE OPERATION ");

		logger.info("1. CREATE QUIZ");
		logger.info("2. VIEW QUIZ");
		logger.info("3. DELETE QUIZ");
		logger.info("4. UPDATE QUIZ");
		logger.info("5. QUIZ QUESTION");
		logger.info("6. ADD QUESTIONS TO QUIZ :");
		logger.info("ENTER YOUR OPTION");
		
	}
	
	

}
