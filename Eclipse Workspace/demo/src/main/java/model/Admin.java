package model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Entity
@Service

public class Admin {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int id;
	String userName;
	String email;
	String password;
   
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
	
  public Admin()
  {
	  
  }


	public Admin(int id, String userName, String email, String password) {
	super();
	this.id = id;
	this.userName = userName;
	this.email = email;
	this.password = password;
}

	public Admin( String userName, String email, String password) {
	
	this.userName = userName;
	this.email = email;
	this.password = password;
}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
