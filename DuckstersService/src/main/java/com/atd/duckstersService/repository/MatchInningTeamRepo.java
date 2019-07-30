package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.entity.match.MatchInningTeam;

@Repository
public interface MatchInningTeamRepo  extends JpaRepository<MatchInningTeam, Integer>{

}
