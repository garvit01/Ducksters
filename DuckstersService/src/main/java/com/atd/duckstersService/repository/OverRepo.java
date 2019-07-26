package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.runningMatch.Over;

public interface OverRepo  extends JpaRepository<Over, Integer>{

}
