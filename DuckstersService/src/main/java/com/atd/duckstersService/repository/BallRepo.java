package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.runningMatch.Ball;


public interface BallRepo  extends JpaRepository<Ball, Integer> {

}
