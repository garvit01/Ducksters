package com.atd.duckstersService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.DTO.TournamentDetailsDTO;
import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.entity.team.TeamUser;
import com.atd.duckstersService.exception.AlreadyFoundException;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.service.TeamService;
import com.atd.duckstersService.service.TeamUserService;
import com.atd.duckstersService.service.TournamentTeamService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/team")
public class TeamController {

	private TeamService teamService;

	private TeamUserService teamUserService;

	private TournamentTeamService tournamentTeamService;

	private static Logger LOGGER = LoggerFactory.getLogger(TeamController.class.getName());

	@Autowired
	public TeamController(TeamService teamService, TeamUserService teamUserService,
			TournamentTeamService tournamentTeamService) {
		super();
		this.teamService = teamService;
		this.teamUserService = teamUserService;
		this.tournamentTeamService = tournamentTeamService;
	}

	@RequestMapping(value = "/getTeamById", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getTeamById(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START TeamController -> getTeamById");
		ResponseEntity<?> responseEntity = null;
		Map<String, Object> result = new HashMap<>();
		try {
			int teamId = Integer.parseInt(obj.getString("id"));
			LOGGER.debug("team id is {} ", teamId);
			Team team = teamService.getById(teamId);
			// add basic details of team
			LOGGER.debug("after searching the team is {} ", team);
			result.put("teamData", team);
			// teamDetailsDTO.setTeam(team);

			// get the all team members of a team by team id
			List<TeamMembersDTO> listTeamMembers = teamUserService.listTeamPlayersByTeamId(teamId);

			LOGGER.debug("the team members of team are {} ", listTeamMembers);
			result.put("members", listTeamMembers);

			// add the tournament played by team on the basis of team id

			List<TournamentDetailsDTO> listPlayedTournaments = tournamentTeamService.listTournamentByTeamId(teamId);
			LOGGER.debug("tournaments played by this team are {} ", listPlayedTournaments);
			result.put("tournamentsPlayed", listPlayedTournaments);
			// teamDetailsDTO.setListTournamentPlayed(listPlayedTournaments);

			responseEntity = new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			LOGGER.warn("[Team Controller -> getTeamById] no data for this id {} ");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (NumberFormatException | JSONException e) {
			LOGGER.warn(" [Team Controller -> getTeamById] key is invalid ");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		LOGGER.info("END");
		return responseEntity;

	}

	@RequestMapping(value = "/getTeamByName", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> getTeamByName(@RequestAttribute(name = "paramData") JSONObject obj) {
		LOGGER.info("START TeamController -> getTeamByName");
		ResponseEntity<?> responseEntity = null;
		List<Map<String, Object>> result = new ArrayList<>();
		try {
			String teamName = obj.getString("name");
			LOGGER.debug("the team name is {} ", teamName);
			List<Team> listTeam = teamService.getByName(teamName);

			LOGGER.debug("the list of teams {} ", listTeam);
			// add basic details of team
			for (Team team : listTeam) {
				Map<String, Object> teamInfo = new HashMap<>();
				teamInfo.put("teamData", team);
				int teamId = team.getId();
				// get the all team members of a team by team id
				List<TeamMembersDTO> listTeamMembers = teamUserService.listTeamPlayersByTeamId(teamId);
				LOGGER.debug(" the members of this team are {} ", listTeamMembers);
				teamInfo.put("members", listTeamMembers);
				// add the tournament played by team on the basis of team id

				List<TournamentDetailsDTO> listPlayedTournaments = tournamentTeamService.listTournamentByTeamId(teamId);
				LOGGER.debug("tournament played by this team are {} ", listPlayedTournaments);
				teamInfo.put("tournamentsPlayed", listPlayedTournaments);
				result.add(teamInfo);

			}

			responseEntity = new ResponseEntity<List<Map<String, Object>>>(result, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			LOGGER.warn(" [Team Controller -> getTeamByName] no data found");
			// TODO Auto-generated catch block
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			LOGGER.warn(" [Team Controller -> getTeamByName] key is invalid");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		LOGGER.info("END");
		return responseEntity;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addPlayersToTeam", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addPlayersToTeam(@RequestAttribute(name = "paramData") JSONObject obj) {

		LOGGER.info("START TeamController -> addPlayersToTeam");
		List<Integer> listUserIds = null;
//		listUserIds.add(1);

		ResponseEntity<?> responseEntity = null;
		try {
			int teamId = Integer.parseInt(obj.getString("teamId"));
			LOGGER.debug("the team id is {} ", teamId);
			listUserIds = (List<Integer>) obj.getJSONArray("listUserIds");
			LOGGER.debug("the list of players to add in team {} ", listUserIds);
			List<TeamUser> addedUserToTeam = teamUserService.addPlayerToTeam(teamId, listUserIds);

			LOGGER.debug("after adding player to team {} ", addedUserToTeam);
			responseEntity = new ResponseEntity<List<TeamUser>>(addedUserToTeam, HttpStatus.OK);
		} catch (AlreadyFoundException e) {
			// TODO Auto-generated catch block
			LOGGER.warn("[TeamController -> addPlayersToTeam] player is in team already");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (NumberFormatException e) {
			LOGGER.warn("[TeamController -> addPlayersToTeam] number format exception ");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (JSONException e) {
			LOGGER.warn("[TeamController -> addPlayersToTeam] key is invalid  ");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

		LOGGER.info("END");
		return responseEntity;

	}

	@RequestMapping(value = "/createTeam", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createTeam(@RequestAttribute(name = "paramData") JSONObject obj) {

		LOGGER.info("START TeamController -> createTeam");
		ResponseEntity<?> responseEntity = null;
		try {
			Gson gson = new Gson();
			Team team = gson.fromJson(obj.getJSONObject("team").toString(), Team.class);
			LOGGER.debug("team for register is {} ", team);
			Team savedTeam = teamService.registerTeam(team);
			LOGGER.debug("after saving team {} ", savedTeam);
			responseEntity = new ResponseEntity<Team>(savedTeam, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.warn("[TeamController -> createTeam] some exception");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		LOGGER.info("END");
		return responseEntity;
	}
}
