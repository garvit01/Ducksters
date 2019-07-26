package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.tournament.TournamentTeam;

public interface TournamentTeamRepo  extends JpaRepository<TournamentTeam, Integer>{

}
