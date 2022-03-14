package template;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;

import model.Question;
import service.BeanContainer;
import service.QuestionService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import database.QuestionDatabase;

import org.apache.logging.log4j.LogManager;


@Component

public  class QuestionTemplate implements Optioninf{


	static ApplicationContext context = BeanContainer.getContainer();

	private  QuestionService questionService= context.getBean(QuestionService.class);

	private  Logger logger = LogManager.getLogger(QuestionTemplate.class.getName());

	public  void entryToQuestionTemplate() {
		String exit = "";
		int option = -1;

		Scanner scanner = ScannerFactory.getScanner();

		do {

			logger.info("welcome to question");
			logger.info("1. CREATE QUESTION");
			logger.info("2. VIEW QUESTION");
			logger.info("3. UPDATE QUESTION");
			logger.info("4. DELETE QUESTION");
			logger.info("5. EXIT");

			logger.info("Choose your option");
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException ime) {

				logger.error("invalid input in queston {0}", ime);
				option = 5;
			}

			switch (option) {
			case 1:
				this.getQuestionData();
				break;
			case 2:
				this.viewQuestion();
				break;
			case 3:
				this.updateQuestion();
				break;
			case 4:
				this.deleteQuestion();
				break;
			case 5:

				break;
			default:
				break;
			}

			logger.info("type yes to continue: ");
			try {
				exit = scanner.nextLine();
			} catch (InputMismatchException ime) {
				logger.error(" invalid input {0}", ime);
			}
		} while (exit.equals("yes"));

	}

	public  void getQuestionData() {

		String question;
		String questionOptionOne;
		String questionOptionTwo;
		String questionOptionThree;
		String questionOptionFour;
		int rightOption = 0;
		String questionTag;
		String questionDifficulty;

		Scanner scanner = ScannerFactory.getScanner();

		try {
			logger.info("enter the question tag: ");
			questionTag = scanner.nextLine();
			logger.info("\n enter the question: ");
			question = scanner.nextLine();
			logger.info("\n enter the option one: ");
			questionOptionOne = scanner.nextLine();
			logger.info("\n enter the option two: ");
			questionOptionTwo = scanner.nextLine();
			logger.info("\n enter the option Three: ");
			questionOptionThree = scanner.nextLine();
			logger.info("\n enter the option four: ");
			questionOptionFour = scanner.nextLine();
			logger.info("\n enter the  correct option number(1,2,3,4) : ");
			try {
				rightOption = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException nfe) {
				logger.error(nfe);
				logger.info("\n enter the  correct option number(1,2,3,4) : ");
				rightOption = Integer.parseInt(scanner.nextLine());

			}
			logger.info("\n enter the oquestion difficulty(easy, midium, hard): ");
			questionDifficulty = scanner.nextLine();
			try {

				List<String> list = new ArrayList<>();
				list.add(questionOptionOne);
				list.add(questionOptionTwo);
				list.add(questionOptionThree);
				list.add(questionOptionFour);

				Question qj = new Question();

				qj.setQuestion(question);
				qj.setDifficulty(questionDifficulty);
				qj.setOptionList(list);
				qj.setQuestionTag(questionTag);

				qj.setRightoption(rightOption);

				questionService.createQuestion(qj);

			} catch (ClassCastException cce) {
				logger.error("error in try {0}", cce);
			}

		} catch (NumberFormatException ime) {
			logger.info("Invalid input {0} ", ime);
		}

	}

	public  void viewQuestion() {

		List<Question> list = questionService.getAllQuestion();
		for (Question q : list)
			System.out.println(q);

	}

	public  void updateQuestion() {
		Scanner scanner = ScannerFactory.getScanner();
		String questionTag = "";
		logger.info("enter the question title: ");
		questionTag = scanner.nextLine();
		List<Question> questions = questionService.getQuestionByTag(questionTag);

		if (questions.isEmpty()) {
			logger.info("no question with that tag");
		} else {

			questions.stream().forEach(System.out::println);

		}

		logger.info("enter the id of question to be update");
		int id = 0;
		try {
			id = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException ime) {
			logger.error("invalid input {0} ", ime);
		}

		Question questionToUpdate = questionService.getQuestionById(id);

		if (questionToUpdate != null) {

			int option = 0;
			showOption();

			try {
				option = Integer.parseInt(scanner.nextLine());

			} catch (NumberFormatException ime) {
				logger.error("invalid input {0} ", ime);
				option = 9;
			}

			try {
				switch (option) {
				case 1:
					logger.info("enter your new tag: ");
					String newTag = scanner.nextLine();
					questionToUpdate.setQuestionTag(newTag);
					break;

				case 2:
					logger.info("enter your new question: ");
					String newQuestion = scanner.nextLine();
					questionToUpdate.setQuestion(newQuestion);
					break;
				case 3:
					logger.info("enter your new option 1");
					String option1 = scanner.nextLine();
					questionToUpdate.getOptionList().set(0, option1);
					break;
				case 4:
					logger.info("enter your new option 2");
					String option2 = scanner.nextLine();
					questionToUpdate.getOptionList().set(0, option2);
					break;
				case 5:
					logger.info("enter your new option 3");
					String option3 = scanner.nextLine();
					questionToUpdate.getOptionList().set(0, option3);
					break;
				case 6:
					logger.info("enter your new option 4");
					String option4 = scanner.nextLine();
					questionToUpdate.getOptionList().set(0, option4);
					break;
				case 7:
					logger.info("enter your right option from {}  to (1,2,3,4) ", questionToUpdate.getRightoption());
					int ro = 0;
					try {
						ro = Integer.parseInt(scanner.nextLine());
						questionToUpdate.setRightoption(ro);
					} catch (NumberFormatException ime) {
						logger.error("invalid input {0}", ime);
					}

					break;
				case 8:
					logger.info("change difficulty level from {} to  ", questionToUpdate.getDifficulty());
					String difficulty = scanner.nextLine();
					questionToUpdate.setDifficulty(difficulty);
					break;

				default:
					break;
				}
			} catch (NumberFormatException ime) {
				logger.error("invalid input {0}", ime);
			}
			questionService.updateQuestion(questionToUpdate);
		} else {
			logger.info("no question with this id");
		}

	}

	
	

	public  void deleteQuestion() {
		String questionTag;
		Scanner scanner = ScannerFactory.getScanner();
		logger.info("enter the question tag ");
		questionTag = scanner.nextLine();
		List<Question> questions = questionService.getQuestionByTag(questionTag);
		if (questions != null) {
			if (questions.isEmpty()) {
				logger.info("No question with that tag");
			} else {
				questions.stream().forEach(System.out::println);
			}
		}
		logger.info("enter the id of question to delete: ");
		int id = 0;
		try {
			id = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException nfe) {
			logger.error(nfe);
		}
		boolean flag = questionService.deleteQuestionById(id);
		if (flag)
			logger.info("question delete");
		else
			logger.info("Invalid id");

	}

	@Override
	public void showOption() {

		logger.info("what to update in question ");
		logger.info("1. question tag");
		logger.info("2. question");
		logger.info("3. option 1");
		logger.info("4. option 2");
		logger.info("5. option 3");
		logger.info("6. option 4");
		logger.info("7. right answer");
		logger.info("8. difficulty level");
		logger.info("9. exit");
	}

	
}
