package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.tournament.Tournament;

public interface TournamentRepo  extends JpaRepository<Tournament, Integer>{

}
