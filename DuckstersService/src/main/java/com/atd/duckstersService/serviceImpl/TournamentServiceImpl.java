package com.atd.duckstersService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.repository.TournamentRepo;
import com.atd.duckstersService.service.TournamentService;

@Service
public class TournamentServiceImpl implements TournamentService {

	private TournamentRepo tournamentRepo;

	@Autowired
	public TournamentServiceImpl(TournamentRepo tournamentRepo) {
		super();
		this.tournamentRepo = tournamentRepo;
	}

	@Override
	public List<Tournament> listLiveTournaments(String status) throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<Tournament> listLiveTournaments = null;
		listLiveTournaments = tournamentRepo.findByStatus(status);
		if (listLiveTournaments == null)
			throw new NoDataFoundException("No Live Tournament is Live Now");
		else
			return listLiveTournaments;

	}

}
