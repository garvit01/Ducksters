package com.atd.duckstersService.controller;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/api/userprofile")
public class UserProfileController {
	private UserProfileService userProfileService;
	private UserRoleService userRoleService;
	private TeamUserService teamUserService;
	private static Logger LOGGER = LoggerFactory.getLogger(UserProfileController.class.getName());

	@Autowired
	public UserProfileController(UserProfileService userProfileService, UserRoleService userRoleService,
			TeamUserService teamUserService) {
		super();
		this.userProfileService = userProfileService;
		this.userRoleService = userRoleService;
		this.teamUserService = teamUserService;
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.POST)
	public ResponseEntity<UserProfile> getUserById(@RequestAttribute(name = "paramData") JSONObject obj)
			throws IOException, NoDataFoundException {
		LOGGER.info("START UserProfileController -> getUserById");
		UserProfile userProfile = null;
		ResponseEntity<?> responseEntity = null;
		try {
			int userId = Integer.parseInt(obj.getString("id"));
			LOGGER.debug("the id for searching player is {} ", userId);
			userProfile = userProfileService.getUserById(userId);
			LOGGER.debug("the player info {} ", userProfile);
		} catch (NumberFormatException e) {
			LOGGER.warn("[UserProfileController -> getUserById] number not found for this key");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (JSONException e) {
			LOGGER.warn("[UserProfileController -> getUserById] invalid key");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		LOGGER.info("END UserProfileController -> getUserById");
		return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
	}

	@RequestMapping(value = "/getUserByName", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getUserByName(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START UserProfileController -> getUserByName");
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		List<UserProfile> listUserProfile;
		try {
			String name = obj.getString("name");
			LOGGER.debug("the player name for {} ", name);
			// basic info of user
			listUserProfile = userProfileService.getUserByName(name);
			LOGGER.debug("the list of players is {} ", listUserProfile);
			for (UserProfile user : listUserProfile) {
				Map<String, Object> userMap = new HashMap<>();
				userMap.put("info", user);
				int id = user.getId();

				// list of roles of user
				List<String> listRoles = userRoleService.listRolesByUserId(id);
				LOGGER.debug("the roles of players id {} are {}  ", id, listRoles);
				userMap.put("roles", listRoles);

				// list of team joined
				List<TeamDetailsDTO> listTeamsJoined = teamUserService.listTeamsByUserId(id);
				LOGGER.debug("the player id is {} and teams joined by player are {} ", id, listTeamsJoined);
				userMap.put("teams", listTeamsJoined);

				result.add(userMap);

			}

		} catch (NoDataFoundException e) {
			LOGGER.warn("[UserProfileController -> getUserByName] no data found ");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (JSONException e) {
			LOGGER.warn("[UserProfileController -> getUserByName] invalid key ");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		LOGGER.info("END UserProfileController -> getUserById");
		return new ResponseEntity<List<Map<String, Object>>>(result, HttpStatus.OK);
	}

}
