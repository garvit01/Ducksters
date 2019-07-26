package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.team.Team;

public interface TeamRepo extends JpaRepository<Team, Integer>{

}
