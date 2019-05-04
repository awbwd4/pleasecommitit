package bk.tddlive.security;

import bk.tddlive.domain.UserRepository;

public class AuthService{

	private UserRepository userRepository;

	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	public Authentication authenticate(String id, String password) {
		
		assertIdAndPassword(id, password);
		
		User user = findUserOrThrowEx(id);
		
		throwExPasswordWrong(password, user);
		
		return createAuthentication(user);
		
	}


	public void assertIdAndPassword(String id, String password) {
		if (id == null || id.isEmpty()) throw new IllegalArgumentException();
		if (password == null || password.isEmpty()) throw new IllegalArgumentException();
	}


	public User findUserOrThrowEx(String id) {
		User user = findUserById(id);
		
		if(user == null) {
			throw new NonExistingUserException();}
		return user;
	}


	public void throwExPasswordWrong(String password, User user) {
		if(!user.matchPassword(password))
			throw new WrongPasswordException();
	}


	public Authentication createAuthentication(User user) {
		return new Authentication(user.getId());
	}
	
	private User findUserById(String id) {
		
		return userRepository.findById(id);
		
	}
	

}