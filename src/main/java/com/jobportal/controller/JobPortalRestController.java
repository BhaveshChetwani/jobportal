package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.model.User;
import com.jobportal.service.UserService;

@RestController
public class JobPortalRestController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/checkuserexists")
	@ResponseBody
	public String callDao(@RequestParam(name="username",required=true) String username) {
		if(username!= null && username !="") {
		List<User> userList = userService.findUserByName1(username);
			if(userList != null && !userList.isEmpty() && userList.size()>0) {
				System.out.println(userList);
				return "true";
			}
			return "false";
		}
		return "Try Again.";
	}
	
}
