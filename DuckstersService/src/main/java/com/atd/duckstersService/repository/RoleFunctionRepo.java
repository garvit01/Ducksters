package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.user.RoleFunction;

public interface RoleFunctionRepo  extends JpaRepository<RoleFunction, Integer>{

}
