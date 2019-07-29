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

import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.DTO.TournamentDetailsDTO;
import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.service.TeamService;
import com.atd.duckstersService.service.TeamUserService;
import com.atd.duckstersService.service.TournamentTeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {

	private TeamService teamService;

	private TeamUserService teamUserService;

	private TournamentTeamService tournamentTeamService;

	@Autowired
	public TeamController(TeamService teamService, TeamUserService teamUserService,
			TournamentTeamService tournamentTeamService) {
		super();
		this.teamService = teamService;
		this.teamUserService = teamUserService;
		this.tournamentTeamService = tournamentTeamService;
	}

	@RequestMapping(value = "/getTeam/{teamId}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getTeamById(@PathVariable Integer teamId) {
		ResponseEntity<?> responseEntity = null;
		Map<String, Object> result = new HashMap<>();
		try {
			Team team = teamService.getById(teamId);
			// add basic details of team

			result.put("teamData", team);
			// teamDetailsDTO.setTeam(team);

			// get the all team members of a team by team id
			List<TeamMembersDTO> listTeamMembers = teamUserService.listTeamPlayersByTeamId(teamId);
			result.put("members", listTeamMembers);

			// add the tournament played by team on the basis of team id

			List<TournamentDetailsDTO> listPlayedTournaments = tournamentTeamService.listTournamentByTeamId(teamId);
			result.put("tournamentsPlayed", listPlayedTournaments);
			// teamDetailsDTO.setListTournamentPlayed(listPlayedTournaments);

			responseEntity = new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;

	}

}
