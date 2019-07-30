package com.atd.duckstersService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.entity.user.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {

	@Query(nativeQuery = true, value = "select r.name from role r join userrole ur on ur.role_id=r.id where ur.user_id=:userId group by r.id")
	public List<String> getRolesByUserId(@Param("userId") Integer userId);

}
