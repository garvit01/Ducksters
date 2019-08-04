package com.atd.duckstersService.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.exception.InvalidParameter;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.service.TournamentService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

	private TournamentService tournamentService;

	private static Logger LOGGER = LoggerFactory.getLogger(TournamentController.class.getName());

	@Autowired
	public TournamentController(TournamentService tournamentService) {
		super();
		this.tournamentService = tournamentService;

	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLiveTournaments(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START TournamentController -> getLiveTournaments");
		ResponseEntity<?> responseEntity = null;
		try {
			String status = obj.getString("status");
			LOGGER.debug("the status is {} ", status);
			List<Tournament> listLiveTournament = tournamentService.listLiveTournaments(status.toUpperCase());
			LOGGER.debug("the list of live tournaments {} ", listLiveTournament);
			responseEntity = new ResponseEntity<List<Tournament>>(listLiveTournament, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("[TournamentController -> getLiveTournaments ] no data found ");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (JSONException e) {
			LOGGER.warn("[TournamentController -> getLiveTournaments] invalid key ");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		LOGGER.info("END TournamentController -> getLiveTournaments");
		return responseEntity;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerTournament(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START TournamentController -> registerTournament");
		ResponseEntity<?> responseEntity = null;
		try {
			Tournament tournament = new Gson().fromJson(obj.getJSONObject("tournament").toString(), Tournament.class);
			LOGGER.debug("Tournament for registering {} ", tournament);
			Tournament registeredTournament = tournamentService.registerTournament(tournament);
			LOGGER.debug("Registered tournament is  {} ", registeredTournament);
			responseEntity = new ResponseEntity<Tournament>(tournament, HttpStatus.OK);
		} catch (JsonSyntaxException e) {
			LOGGER.warn("[TournamentController -> registerTournament] jsonobject not converted to tournament");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (JSONException e) {
			LOGGER.warn("[TournamentController -> registerTournament] invalid key");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (InvalidParameter e) {
			// TODO Auto-generated catch block
			LOGGER.warn("[TournamentController -> registerTournament] invalid parameters");
			e.printStackTrace();
		}
		LOGGER.info("END TournamentController -> registerTournament");
		return responseEntity;

	}

	@RequestMapping(value = "/getByName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getTournamentByName(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START TournamentController -> getTournamentByName");
		ResponseEntity<?> responseEntity = null;
		try {
			String name = obj.getString("name");
			LOGGER.debug("the searched tournament name is {} ", name);
			List<Tournament> listTournament = tournamentService.getTournamentByName(name);
			LOGGER.debug("the searched tournaments are {} ", listTournament);
			responseEntity = new ResponseEntity<List<Tournament>>(listTournament, HttpStatus.CONFLICT);
		} catch (JSONException e) {
			LOGGER.warn("[TournamentController -> getTournamentByName] invalid key ");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (NoDataFoundException e) {
			LOGGER.warn("[TournamentController -> getTournamentByName] no data found");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		LOGGER.info("END TournamentController -> getRegisterByName");
		return responseEntity;
	}
}
