package model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	String password;
    
	@ElementCollection
	@MapKeyColumn(name="quiz")
	@Column(name="score")
	
	Map<Integer , Integer> score=new HashMap<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Map<Integer, Integer> getScore() {
		return score;
	}

	public void setScore(Map<Integer, Integer> score) {
		this.score = score;
	}

	public User()
	{
		
	}
	
	
	public User(int id, String name, String email, String password, Map<Integer, Integer> score) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.score = score;
	}

	public User(String name, String email, String password, Map<Integer, Integer> score) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.score = score;
	}
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		
	}

	
	@Override
	public String toString() {
		return "UserJpa [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", score="
				+ score + "]";
	}
	
	
	
	
}
