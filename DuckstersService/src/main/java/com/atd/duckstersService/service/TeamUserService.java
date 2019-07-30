package com.atd.duckstersService.service;

import java.util.List;

import com.atd.duckstersService.DTO.TeamDetailsDTO;
import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.entity.team.TeamUser;
import com.atd.duckstersService.exception.AlreadyFoundException;

public interface TeamUserService {

	public List<TeamMembersDTO> listTeamPlayersByTeamId(int id);

	public List<TeamDetailsDTO> listTeamsByUserId(int id);

	public TeamUser addMembersToTeam(TeamUser teamUser) throws AlreadyFoundException;

}
