package com.atd.duckstersService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.DTO.TournamentDetailsDTO;
import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.repository.TournamentTeamRepo;
import com.atd.duckstersService.service.TournamentService;
import com.atd.duckstersService.service.TournamentTeamService;

@Service
public class TournamentTeamServiceImpl implements TournamentTeamService {

	private TournamentTeamRepo tournamentTeamRepo;

	@Autowired
	public TournamentTeamServiceImpl(TournamentTeamRepo tournamentTeamRepo) {
		super();
		this.tournamentTeamRepo = tournamentTeamRepo;
	}

	@Override
	public List<TournamentDetailsDTO> listTournamentByTeamId(int id) {
		List<TournamentDetailsDTO> listTournamentDetail = null;
		listTournamentDetail = tournamentTeamRepo.getTournamentByTeamId(id);
		return listTournamentDetail;
	}

}
