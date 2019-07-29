package com.atd.duckstersService.service;

import java.util.List;

import com.atd.duckstersService.DTO.TournamentDetailsDTO;
import com.atd.duckstersService.exception.NoDataFoundException;

public interface TournamentTeamService {

	public List<TournamentDetailsDTO> listTournamentByTeamId(int id) throws NoDataFoundException;

}
