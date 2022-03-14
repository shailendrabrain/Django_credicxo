package com.epam;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import service.AdminService;
import template.AdminTemplate;
import template.ScannerFactory;
import template.UserTemplate;

@SpringBootApplication
@ComponentScan(basePackages = {"com.epam","service","model","template","database"})
public class DemoApplication {

	private static final Logger logger = LogManager.getLogger(DemoApplication.class.getName());
	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(DemoApplication.class, args);
	
         //DemoApplication.startProgram();
	
	}
	
	public static void startProgram() {

		logger.info("WELCOME TO QUIZ MANAGEMENT PROJECT\n");
		String exit = "";
		int option = 0;

		Scanner sc = ScannerFactory.getScanner();
		do {
			logger.info("1. ADMIN");
			logger.info("2. USER");
			logger.info("Enter your option:");
			try {
				option = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException ime) {
				logger.error("error in try");
			}

			switch (option) {
			case 1:
				new AdminTemplate().entryToAdmin();
				break;
			case 2:
				UserTemplate.entryToUser();
				break;
			default:
				break;
			}
			logger.info("press yes to go user admin menu");
			exit = sc.nextLine();
		} while (exit.equals("yes"));

		logger.info("program closed");
		sc.close();
	}

	
}
