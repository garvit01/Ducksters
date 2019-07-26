package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.match.MatchAward;

public interface MatchAwardRepo  extends JpaRepository<MatchAward, Integer> {

}
