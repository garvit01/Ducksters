package com.atd.duckstersauthentication.service;

import java.util.Map;

import com.atd.duckstersauthentication.model.User;

public interface SecurityTokenGenerator {
	
	Map<String,String> generateToken(User user);

}
