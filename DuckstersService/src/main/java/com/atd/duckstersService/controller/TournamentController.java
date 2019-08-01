package com.atd.duckstersService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.InvalidParameter;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.service.TournamentService;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

	private TournamentService tournamentService;

	@Autowired
	public TournamentController(TournamentService tournamentService) {
		super();
		this.tournamentService = tournamentService;

	}

	@RequestMapping(value = "/{status}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLiveTournaments(@PathVariable("status") String status) {
		System.out.println("______________" + status);
		ResponseEntity<?> responseEntity = null;
		try {
			List<Tournament> listLiveTournament = tournamentService.listLiveTournaments(status.toUpperCase());
			System.out.println(listLiveTournament);
			responseEntity = new ResponseEntity<List<Tournament>>(listLiveTournament, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerTournament(@RequestBody Tournament tournament) {
		ResponseEntity<?> responseEntity = null;
		try {
			Tournament registerTournament = tournamentService.registerTournament(tournament);
			responseEntity = new ResponseEntity<Tournament>(registerTournament, HttpStatus.OK);
		} catch (InvalidParameter e) {
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;

	}

}
