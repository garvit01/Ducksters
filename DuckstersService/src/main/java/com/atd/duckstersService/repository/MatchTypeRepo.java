package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.match.MatchType;

public interface MatchTypeRepo  extends JpaRepository<MatchType, Integer>{

}
