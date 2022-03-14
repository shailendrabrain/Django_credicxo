package database;

import org.springframework.stereotype.Component;

import model.Admin;

@Component
public interface AdminInf {

	void insert(Admin a);
	Admin view(int i);
	Admin authenticate(String a,String b);
	
	
	
}
