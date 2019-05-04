package bk.tddlive.domain;

import bk.tddlive.security.User;

public interface UserRepository {
	
	 User findById(String id);
	
}