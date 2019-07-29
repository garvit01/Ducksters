package com.atd.duckstersService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.repository.TeamRepo;
import com.atd.duckstersService.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRepo teamRepo;

	@Autowired
	public TeamServiceImpl(TeamRepo teamRepo) {
		super();
		this.teamRepo = teamRepo;
	}

	@Override
	public Team getByName(String name) throws NoDataFoundException {
		Team team = teamRepo.findByName(name);
		if (team == null)
			throw new NoDataFoundException("No Data found");
		else
			return team;
	}

	@Override
	public Team getById(int id) throws NoDataFoundException {
		Optional<Team> optTeam = teamRepo.findById(id);
		Team team = null;
		if (optTeam.isPresent())
			team = optTeam.get();
		if (team == null)
			throw new NoDataFoundException("No Data found");
		else
			return team;
	}

//	@Override
//	public List<UserProfile> getTeamMembersById(int id) throws NoDataFoundException {
//		List<UserProfile> listUsers = null;
//		listUsers = teamRepo.findAllMembersByTeamId(id);
//		if (listUsers.size() == 0)
//			throw new NoDataFoundException("No member joined yet");
//		else
//			return listUsers;
//	}

}
