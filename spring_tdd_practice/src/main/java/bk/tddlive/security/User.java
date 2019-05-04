package bk.tddlive.security;

public class User{

	String id;
	String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	
	}

	public boolean matchPassword(String password) {
		return (this.password==password);
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	
}