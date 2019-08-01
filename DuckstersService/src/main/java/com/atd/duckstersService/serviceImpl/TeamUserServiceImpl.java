package com.atd.duckstersService.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.DTO.TeamDetailsDTO;
import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.entity.team.TeamUser;
import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.AlreadyFoundException;
import com.atd.duckstersService.repository.TeamUserRepo;
import com.atd.duckstersService.service.TeamUserService;

@Service
public class TeamUserServiceImpl implements TeamUserService {

	private TeamUserRepo teamUserRepo;

	@Autowired
	public TeamUserServiceImpl(TeamUserRepo teamUserRepo) {
		super();
		this.teamUserRepo = teamUserRepo;
	}

	@Override
	public List<TeamMembersDTO> listTeamPlayersByTeamId(int id) {

		List<TeamMembersDTO> listPlayers = null;
		listPlayers = teamUserRepo.listAllTeamMembersByTeamId(id);

		return listPlayers;
	}

	@Override
	public List<TeamDetailsDTO> listTeamsByUserId(int id) {
		List<TeamDetailsDTO> listTeams = null;
		listTeams = teamUserRepo.listAllTeamByUserId(id);
		return listTeams;
	}

	@Override
	public boolean isPlayerInTeam(int teamId, int userId) {
		TeamUser teamUser = null;
		teamUser = teamUserRepo.isPlayerInTeam(teamId, userId);
		if (teamUser == null)
			return false;
		else
			return true;

	}

	@Override
	public List<TeamUser> addPlayerToTeam(int teamId, List<Integer> userIds) throws AlreadyFoundException {
		System.out.println("teamId " + teamId);
		List<TeamUser> listSavedTeamUser = new ArrayList<TeamUser>();
		for (int userId : userIds) {
			System.out.println("userid " + userId);
			TeamUser alreadySaved = teamUserRepo.isPlayerInTeam(teamId, userId);
			if (alreadySaved != null) {
				throw new AlreadyFoundException(userId + "Player is already in this team");
			} else {
				TeamUser forSavingObject = new TeamUser();
				Team team = new Team();
				team.setId(teamId);
				forSavingObject.setTeamMap(team);
				UserProfile user = new UserProfile();
				user.setId(userId);
				forSavingObject.setUserMap(user);
				listSavedTeamUser.add(teamUserRepo.save(forSavingObject));
			}

		}
		return listSavedTeamUser;
	}

}
