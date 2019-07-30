package com.atd.duckstersService.service;

import java.util.List;

import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.NoDataFoundException;

public interface UserProfileService {
	public UserProfile getUserById(int id) throws NoDataFoundException;

	public List<UserProfile> getUserByName(String name) throws NoDataFoundException;
}
