package com.atd.duckstersService.DTO;

import java.util.Date;


public interface TournamentDetailsDTO {

	Integer getId();

	String getDescription();

	Date getEndDate();

	Date getLastRegistrationDate();

	Integer getMaxTeams();

	Integer getMinTeams();

	String getName();

	String getPlace();

	Date getStartDate();

	String getStatus();

	String getVenue();


}
