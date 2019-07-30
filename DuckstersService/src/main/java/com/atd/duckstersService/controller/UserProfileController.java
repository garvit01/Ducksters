package com.atd.duckstersService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atd.duckstersService.DTO.TeamDetailsDTO;
import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.service.TeamUserService;
import com.atd.duckstersService.service.UserProfileService;
import com.atd.duckstersService.service.UserRoleService;

@RestController
@RequestMapping("/api/userprofile/")
public class UserProfileController {

	private UserProfileService userProfileService;
	private UserRoleService userRoleService;
	private TeamUserService teamUserService;

	@Autowired
	public UserProfileController(UserProfileService userProfileService, UserRoleService userRoleService,
			TeamUserService teamUserService) {
		super();
		this.userProfileService = userProfileService;
		this.userRoleService = userRoleService;
		this.teamUserService = teamUserService;
	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserProfile userProfile;
		try {
			// basic info of user
			userProfile = userProfileService.getUserById(id);
			result.put("info", userProfile);

			// list of roles
			List<String> listRoles = userRoleService.listRolesByUserId(id);
			result.put("listRoles", listRoles);

			// list of team joined
			List<TeamDetailsDTO> listTeamsJoined = teamUserService.listTeamsByUserId(id);
			result.put("teams", listTeamsJoined);

		} catch (NoDataFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUserByName/{name}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getUserByName(@PathVariable("name") String name) {
		// Map<String, List<Object>> result = new HashMap<String, Object>();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<UserProfile> listUserProfile;
		try {
			// basic info of user
			listUserProfile = userProfileService.getUserByName(name);
			for (UserProfile user : listUserProfile) {
				Map<String, Object> userMap = new HashMap<>();
				userMap.put("info", user);
				int id = user.getId();

				// list of roles of user
				List<String> listRoles = userRoleService.listRolesByUserId(id);
				userMap.put("roles", listRoles);

				// list of team joined
				List<TeamDetailsDTO> listTeamsJoined = teamUserService.listTeamsByUserId(id);
				userMap.put("teams", listTeamsJoined);

				result.add(userMap);

			}

		} catch (NoDataFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Map<String, Object>>>(result, HttpStatus.OK);
	}

}
