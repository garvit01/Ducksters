package com.atd.duckstersService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scheme(int id, String name, String description, Double winningPrize, Double entryFee, Double transactionFee,
			Double organizerFee) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.winningPrize = winningPrize;
		this.entryFee = entryFee;
		this.transactionFee = transactionFee;
		this.organizerFee = organizerFee;
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

	@Override
	public String toString() {
		return "Scheme [id=" + id + ", name=" + name + ", description=" + description + ", winningPrize=" + winningPrize
				+ ", entryFee=" + entryFee + ", transactionFee=" + transactionFee + ", organizerFee=" + organizerFee
				+ "]";
	}

}
