package com.atd.duckstersService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.service.UserProfileService;

@RestController
@RequestMapping("/api/userprofile/")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;

	@GetMapping(path="{id}")
	public ResponseEntity<UserProfile> getCustomer(@PathVariable("id") int id) {
		System.out.println("INSIDE CONTROLLER");
		UserProfile userProfile = userProfileService.getUserProfileByInt(id);
		if (userProfile == null) {
			System.out.println("nothing find");
		}
		return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
	}

	/*@RequestMapping("/")
	public ResponseEntity<String> get() {

		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}*/

}
