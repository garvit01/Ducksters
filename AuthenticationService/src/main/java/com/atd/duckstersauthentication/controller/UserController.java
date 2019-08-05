package com.atd.duckstersauthentication.controller;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.atd.duckstersauthentication.exception.UserAlreadyExistsException;
import com.atd.duckstersauthentication.exception.UserNotFoundException;
import com.atd.duckstersauthentication.model.User;
import com.atd.duckstersauthentication.service.SecurityTokenGenerator;
import com.atd.duckstersauthentication.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@RestController
@EnableWebMvc
@RequestMapping("/api/v1/userservice")
@CrossOrigin
public class UserController {

	private UserService userService;

	private SecurityTokenGenerator tokenGenerator;

	@Autowired
	public UserController(UserService userService, SecurityTokenGenerator tokenGenerator) {
		super();
		this.userService = userService;
		this.tokenGenerator = tokenGenerator;
	}

	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START UserController >> registerUser");
		ResponseEntity<?> responseEntity = null;
		try {
			User user = new Gson().fromJson(obj.getJSONObject("user").toString(), User.class);
			LOGGER.debug("the user for registering {} ", user);
			User registeredUser = userService.saveUser(user);
			return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("[UserController >> registerUser] this user is already registered");
			responseEntity = new ResponseEntity<String>("{\"message\": \"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		} catch (JsonSyntaxException e) {
			LOGGER.warn("[UserController >> registerUser] invalid key");
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>("{\"message\": \"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("END >> UserController =-> registerUser");
		return responseEntity;

	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START UserController >> loginUserF");
		User loginDetail;
		ResponseEntity<?> responseEntity = null;
		try {
			loginDetail = new Gson().fromJson(obj.getJSONObject("user").toString(), User.class);
			String userId = loginDetail.getUserId();
			String password = loginDetail.getPassword();
			LOGGER.debug("userId and password are {} and {} ", userId, password);

			if (userId == null || password == null) {
				LOGGER.warn("[UserController >> loginUser] usedId or password not found");
				responseEntity = new ResponseEntity<String>("{\"message\": \"" + "UserId or password is empty" + "\"}",
						HttpStatus.CONFLICT);
			}

			User user = userService.findByUserIdAndPassword(userId, password);
			if (user == null) {
				LOGGER.warn("[UserController >> loginUser] UserId not exist ");
				responseEntity = new ResponseEntity<String>("{\"message\": \"" + "UserId not exist" + "\"}",
						HttpStatus.CONFLICT);
			}
			String pwd = user.getPassword();
			if (!password.equals(pwd)) {
				LOGGER.warn(
						"[UserController >> loginUser] Invalid login credentials. Please check username and password");
				responseEntity = new ResponseEntity<String>(
						"{\"message\": \"" + "Invalid login credentials. Please check username and password" + "\"}",
						HttpStatus.CONFLICT);
			}
			Map<String, String> map = tokenGenerator.generateToken(user);

			responseEntity = new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} catch (JsonSyntaxException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("END UserController >> loginUserF");
		return responseEntity;

	}

}
