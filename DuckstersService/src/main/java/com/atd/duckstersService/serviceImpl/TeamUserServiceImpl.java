package com.atd.duckstersService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.DTO.TeamMembersDTO;
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
	public List<TeamMembersDTO> listTeamPlayersByTeamId(int id) throws NoDataFoundException {

		List<TeamMembersDTO> listPlayers = null;
		listPlayers = teamUserRepo.listAllTeamMembersByTeamId(id);
		if (listPlayers.size() == 0)
			throw new NoDataFoundException("No Player joined this team");
		else
			return listPlayers;
	}

}
