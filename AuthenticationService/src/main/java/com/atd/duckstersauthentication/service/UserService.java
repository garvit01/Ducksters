package com.atd.duckstersauthentication.service;

import com.atd.duckstersauthentication.exception.UserAlreadyExistsException;
import com.atd.duckstersauthentication.exception.UserNotFoundException;
import com.atd.duckstersauthentication.model.User;

public interface UserService {

	User saveUser(User user) throws UserAlreadyExistsException;
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
}
