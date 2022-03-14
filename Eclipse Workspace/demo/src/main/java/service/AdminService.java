package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import database.AdminDatabase;
import database.AdminInf;
import model.Admin;

@Component
@ComponentScan({"database","model"})

public class AdminService {
	
	@Autowired
	@Qualifier("adminDatabase")
	private AdminInf ad;
	
	
	@Autowired
	Admin admin ;

	public Admin toSignUp(String userName, String email, String password) {

		if (userName != null && email != null && password != null) {

			//admin = new Admin(userName, email, password);
			admin.setEmail(email);
			admin.setUserName(userName);
			admin.setPassword(password);
			ad.insert(admin);

		}
		return admin;
	}

	public Admin checkForAuthentication(String email, String password) {
		Admin temp = null;
		if (email != null && password != null) {
			try {

				temp = ad.authenticate(email, password);

			} catch (Exception e) {
				// logger.error(e);
			}
		}
		return temp;

	}

	public void insertAdmin(Admin admin)
	{
		ad.insert(admin);
	}
	
}
