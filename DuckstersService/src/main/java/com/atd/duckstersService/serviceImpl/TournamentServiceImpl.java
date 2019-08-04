package com.atd.duckstersService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.exception.InvalidParameter;
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

	@Override
	public Tournament registerTournament(Tournament tournament) throws InvalidParameter {
		if (tournament.getMaxTeams() == 0)
			throw new InvalidParameter("Max Team is missing");
		else if (tournament.getStartDate() == null)
			throw new InvalidParameter("Start date is missing");
		else if (tournament.getLastRegistrationDate() == null)
			throw new InvalidParameter("Last Registration Date is missing");
		else if (tournament.getScheme() == null)
			throw new InvalidParameter("Scheme is missing");
		else
			return tournamentRepo.save(tournament);
	}

	@Override
	public List<Tournament> getTournamentByName(String name) throws NoDataFoundException {
		List<Tournament> listTournament = null;
		listTournament = tournamentRepo.findByName(name);
		if (listTournament.size() == 0)
			throw new NoDataFoundException("No Tournament Registered By This Name");
		else
			return listTournament;
	}

}
