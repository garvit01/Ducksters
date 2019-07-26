package com.atd.duckstersService.service;

import java.util.List;

import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.exception.NoDataFoundException;

public interface TournamentService {

	List<Tournament> listLiveTournaments(String status) throws NoDataFoundException;

}
