package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.entity.team.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer> {

	public Team findByName(String name);


}
