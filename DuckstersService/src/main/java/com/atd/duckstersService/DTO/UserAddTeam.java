package com.atd.duckstersService.DTO;

import java.util.List;

public class UserAddTeam {

	private int teamId;
	private List<Integer> listUserIds;

	public UserAddTeam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddTeam(int id, List<Integer> listUserIds) {
		super();
		this.teamId = id;
		this.listUserIds = listUserIds;
	}

	public int getId() {
		return teamId;
	}

	public void setId(int id) {
		this.teamId = id;
	}

	public List<Integer> getListUserIds() {
		return listUserIds;
	}

	public void setListUserIds(List<Integer> listUserIds) {
		this.listUserIds = listUserIds;
	}

	@Override
	public String toString() {
		return "UserAddTeam [teamId=" + teamId + ", listUserIds=" + listUserIds + "]";
	}

}
