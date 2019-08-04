package com.atd.duckstersService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.entity.tournament.Tournament;
import com.atd.duckstersService.exception.NoDataFoundException;

@Repository
public interface TournamentRepo extends JpaRepository<Tournament, Integer> {

	public List<Tournament> findByStatus(String status);

	public List<Tournament> findByName(String name);
}
