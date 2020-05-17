package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.User;
import com.jobportal.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public User saveUser(User user) {
		User userNew = userRepo.save(user);
		return userNew;
		
	}
	
	public List<User> findUserByName(String username) {
		Iterable<User> userList = userRepo.findAll();
		List<User> userNew = new ArrayList<User>();
		for(User user: userList) {
			if((username.toUpperCase()).equals(user.getUsername().toUpperCase())) {
				userNew.add(user);
			}
		}
		return userNew;
	}
}
