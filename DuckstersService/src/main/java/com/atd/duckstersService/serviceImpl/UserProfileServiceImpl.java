package com.atd.duckstersService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.NoDataFoundException;
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
	public UserProfile getUserById(int id) throws NoDataFoundException {
		UserProfile userProfile = null;
		Optional<UserProfile> opt = userProfileRepo.findById(id);
		if (opt.isPresent())
			userProfile = opt.get();
		else
			throw new NoDataFoundException("No Data Found For this id");
		return userProfile;
	}

	@Override
	public List<UserProfile> getUserByName(String name) throws NoDataFoundException {
		List<UserProfile> listUserProfile = null;
		listUserProfile = userProfileRepo.findByName(name);
		if (listUserProfile.size() == 0)
			throw new NoDataFoundException("No Data Found For this id");
		else
			return listUserProfile;
	}

}
