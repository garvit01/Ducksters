package com.atd.duckstersService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.DTO.TournamentDetailsDTO;
import com.atd.duckstersService.entity.tournament.TournamentTeam;

@Repository
public interface TournamentTeamRepo extends JpaRepository<TournamentTeam, Integer> {

	@Query(nativeQuery = true, value = "select t.id,t.description,t.endDate,t.lastRegistrationDate,t.maxTeams,t.minTeams,t.name,t.place,t.startDate,t.status,t.venue from tournament t join tournamentteam tt on t.id=tt.tournament_id where tt.team_id=:teamId group by t.id")
	public List<TournamentDetailsDTO> getTournamentByTeamId(@Param("teamId") int id);

}
