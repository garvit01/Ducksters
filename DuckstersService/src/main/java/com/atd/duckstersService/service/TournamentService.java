package com.atd.duckstersService.service;

import java.security.InvalidParameterException;
import java.util.List;

import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.exception.InvalidParameter;
import com.atd.duckstersService.exception.NoDataFoundException;

public interface TournamentService {

	List<Tournament> listLiveTournaments(String status) throws NoDataFoundException;

	Tournament registerTournament(Tournament tournament) throws InvalidParameter;

}
