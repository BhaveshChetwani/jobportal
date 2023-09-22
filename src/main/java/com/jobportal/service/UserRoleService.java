package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.UserRole;
import com.jobportal.repos.UserRoleRepo;

@Service
public class UserRoleService {

	@Autowired
	UserRoleRepo userRoleRepo;
	
	public List<UserRole> findAllUserRoles() {
		List<UserRole> userRoles = new ArrayList<UserRole>();
		Iterable<UserRole> itr = userRoleRepo.findAll();
		for(UserRole userRole : itr) {
			userRoles.add(userRole);
		}
		return userRoles;
		
	}
	
}
