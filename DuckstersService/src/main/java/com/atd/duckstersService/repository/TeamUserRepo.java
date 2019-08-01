package com.atd.duckstersService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atd.duckstersService.DTO.TeamDetailsDTO;
import com.atd.duckstersService.DTO.TeamMembersDTO;
import com.atd.duckstersService.entity.team.TeamUser;
import com.atd.duckstersService.entity.user.UserProfile;

@Repository
public interface TeamUserRepo extends JpaRepository<TeamUser, Integer> {

	@Query(nativeQuery = true, value = "select up.id,up.name,up.address,up.country,up.email,up.rating,up.state,up.pincode from userprofile up join  teamusermap tum on (tum.user_id=up.id) where tum.team_id=:teamId group by up.id")
	public List<TeamMembersDTO> listAllTeamMembersByTeamId(@Param("teamId") Integer teamId);

	@Query(nativeQuery = true, value = "select t.id,t.name,t.coverPhoto from team t join teamusermap tum on tum.team_id=t.id where tum.user_id=:userId group by t.id")
	public List<TeamDetailsDTO> listAllTeamByUserId(@Param("userId") Integer userId);

	@Query(nativeQuery = true, value = "select * from teamusermap where team_id=:team_id and user_id=:user_id")
	public TeamUser isPlayerInTeam(@Param("team_id") Integer teamId, @Param("user_id") Integer userId);



}
