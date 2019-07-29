package com.atd.duckstersService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.entity.team.TeamUser;

@Repository
public interface TeamUserRepo extends JpaRepository<TeamUser, Integer> {

	@Query(nativeQuery=true,value = "select up.id,up.name,up.address,up.country,up.email,up.rating,up.state,up.pincode from userprofile up join  teamusermap tum on (tum.user_id=up.id) where tum.team_id=:teamId group by up.id")
	public List<TeamMembersDTO> listAllTeamMembersByTeamId(@Param("teamId") Integer teamId);
	
	

}
