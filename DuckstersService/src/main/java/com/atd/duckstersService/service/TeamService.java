package com.atd.duckstersService.service;

import java.util.List;

import com.atd.duckstersService.entity.team.Team;
import com.atd.duckstersService.entity.user.UserProfile;
import com.atd.duckstersService.exception.NoDataFoundException;

public interface TeamService {

	public List<Team> getByName(String name) throws NoDataFoundException;

	public Team getById(int id) throws NoDataFoundException;

	public Team registerTeam(Team team);

}
