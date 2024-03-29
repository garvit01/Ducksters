package com.atd.duckstersService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atd.duckstersService.exception.NoDataFoundException;
import com.atd.duckstersService.repository.UserRoleRepo;
import com.atd.duckstersService.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	private UserRoleRepo userRoleRepo;

	@Autowired
	public UserRoleServiceImpl(UserRoleRepo userRoleRepo) {
		super();
		this.userRoleRepo = userRoleRepo;
	}

	@Override
	public List<String> listRolesByUserId(int id) {
		List<String> listRoles = null;
		return userRoleRepo.getRolesByUserId(id);
	}

}
