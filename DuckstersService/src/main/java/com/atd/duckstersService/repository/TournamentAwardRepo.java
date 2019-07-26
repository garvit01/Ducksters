package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.tournament.TournamentAward;

public interface TournamentAwardRepo  extends JpaRepository<TournamentAward, Integer>{

}
