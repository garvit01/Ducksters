package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.match.MatchInningTeam;

public interface MatchInningTeamRepo  extends JpaRepository<MatchInningTeam, Integer>{

}
