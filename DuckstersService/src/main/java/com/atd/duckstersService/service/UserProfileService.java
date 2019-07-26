package com.atd.duckstersService.service;

import org.springframework.stereotype.Service;

import com.atd.duckstersService.entity.user.UserProfile;

public interface UserProfileService {
	public UserProfile getUserProfileByInt(int id);
}
