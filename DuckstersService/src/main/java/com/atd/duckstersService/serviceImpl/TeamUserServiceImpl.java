package com.atd.duckstersService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.DTO.TeamDetailsDTO;
import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.entity.team.TeamUser;
import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.AlreadyFoundException;
import com.atd.duckstersService.exception.NoDataFoundException;
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
	public TeamUser addMembersToTeam(TeamUser teamUser) throws AlreadyFoundException {
		TeamUser alreadyUser = teamUserRepo.findByUserMap(teamUser.getUserMap());
		if (alreadyUser != null)
			throw new AlreadyFoundException("Player already in this team");
		TeamUser savedTeamUser = teamUserRepo.save(teamUser);
		return savedTeamUser;
	}

}
