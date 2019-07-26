package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.entity.common.Scheme;

@Repository
public interface SchemeRepo  extends JpaRepository<Scheme, Integer>{
	

}
