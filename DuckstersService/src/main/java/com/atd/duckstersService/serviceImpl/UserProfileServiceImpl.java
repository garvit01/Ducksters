package com.atd.duckstersService.serviceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.repository.UserProfileRepo;
import com.atd.duckstersService.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	private UserProfileRepo userProfileRepo;

	@Autowired
	public UserProfileServiceImpl(UserProfileRepo userProfileRepo) {
		/* super(); */
		this.userProfileRepo = userProfileRepo;
	}

	@Override
	public UserProfile getUserById(int id) {
		UserProfile userProfile = null;
		Optional<UserProfile> opt = userProfileRepo.findById(id);
		if (opt.isPresent())
			userProfile = opt.get();
		System.out.println(userProfile);
		return userProfile;
	}

}
