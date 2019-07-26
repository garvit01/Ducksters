package com.atd.duckstersService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.service.TournamentService;

@RestController
@RequestMapping("/api/tournament/")
public class TournamentController {

	private TournamentService tournamentService;

	@Autowired
	public TournamentController(TournamentService tournamentService) {
		super();
		this.tournamentService = tournamentService;

	}

	@GetMapping(path = "{status}")
	public ResponseEntity<?> getLiveTournaments(@PathVariable("status") String status) {
		ResponseEntity<?> responseEntity = null;
		try {
			List<Tournament> listLiveTournament = tournamentService.listLiveTournaments(status.toUpperCase());
			responseEntity = new ResponseEntity<List<Tournament>>(listLiveTournament, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;

	}

}
