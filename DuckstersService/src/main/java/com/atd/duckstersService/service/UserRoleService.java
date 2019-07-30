package com.atd.duckstersService.service;

import java.util.List;

import com.atd.duckstersService.exception.NoDataFoundException;

public interface UserRoleService {
	public List<String> listRolesByUserId(int id) throws NoDataFoundException;

}
