package bk.tddlive.security;

public class Authentication {
	//사용자의 인증정보
	String id;
	
	
	public Authentication(String id) {
		this.id = id;
	}


	public String getId() {
		return id;
	}

}