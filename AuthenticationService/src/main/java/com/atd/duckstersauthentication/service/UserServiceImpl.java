package com.atd.duckstersauthentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersauthentication.exception.UserAlreadyExistsException;
import com.atd.duckstersauthentication.exception.UserNotFoundException;
import com.atd.duckstersauthentication.model.User;
import com.atd.duckstersauthentication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		
		Optional<User> fetchedUser = userRepository.findById(user.getUserId());
		if(fetchedUser.isPresent()){
			throw new UserAlreadyExistsException("User with this ID  exists");
			
		}
		userRepository.save(user);
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		
		User user = userRepository.findByUserIdAndPassword(userId, password);
		if(user == null){
			throw new UserNotFoundException("User ID and password mismatch");
		}
		return user;
	}

}
