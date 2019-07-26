package com.atd.duckstersService.entity.common;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.atd.duckstersService.entity.tournament.Tournament;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Scheme {

	@Id
	private int id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Double winningPrize;

	@Column
	private Double entryFee;

	@Column
	private Double transactionFee;;

	@Column
	private Double organizerFee;

	@OneToMany(mappedBy = "scheme", cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Tournament> listTournament;

	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scheme(int id, String name, String description, Double winningPrize, Double entryFee, Double transactionFee,
			Double organizerFee, List<Tournament> listTournament) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.winningPrize = winningPrize;
		this.entryFee = entryFee;
		this.transactionFee = transactionFee;
		this.organizerFee = organizerFee;
		this.listTournament = listTournament;
	}

	public List<Tournament> getListTournament() {
		return listTournament;
	}

	public void setListTournament(List<Tournament> listTournament) {
		this.listTournament = listTournament;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getWinningPrize() {
		return winningPrize;
	}

	public void setWinningPrize(Double winningPrize) {
		this.winningPrize = winningPrize;
	}

	public Double getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(Double entryFee) {
		this.entryFee = entryFee;
	}

	public Double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(Double transactionFee) {
		this.transactionFee = transactionFee;
	}

	public Double getOrganizerFee() {
		return organizerFee;
	}

	public void setOrganizerFee(Double organizerFee) {
		this.organizerFee = organizerFee;
	}

}
