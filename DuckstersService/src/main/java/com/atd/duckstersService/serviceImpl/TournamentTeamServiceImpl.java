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
	public List<TournamentDetailsDTO> listTournamentByTeamId(int id) throws NoDataFoundException {
		List<TournamentDetailsDTO> listTournamentDetail = null;
		listTournamentDetail = tournamentTeamRepo.getTournamentByTeamId(id);
		if (listTournamentDetail.size() == 0)
			throw new NoDataFoundException("This team didn't join any tournament till now");
		else
			return listTournamentDetail;
	}

}
