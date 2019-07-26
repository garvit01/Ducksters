package com.atd.duckstersService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.entity.user.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer>{

}
