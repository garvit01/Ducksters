package com.atd.duckstersService.service;

import java.util.List;

import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.exception.NoDataFoundException;

public interface TeamUserService {

	public List<TeamMembersDTO> listTeamPlayersByTeamId(int id) throws NoDataFoundException;

}
