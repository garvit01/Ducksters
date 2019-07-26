package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atd.duckstersService.entity.user.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer>{

}
