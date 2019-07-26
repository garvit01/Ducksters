package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.match.Match;

public interface MatchRepo  extends JpaRepository<Match, Integer>{

}
