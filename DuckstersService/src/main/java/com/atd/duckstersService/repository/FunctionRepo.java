package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.user.Function;

public interface FunctionRepo  extends JpaRepository<Function, Integer> {

}
