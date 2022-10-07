package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.model.Candidate;
import com.jobportal.model.User;
import com.jobportal.service.CandidateService;
import com.jobportal.service.UserService;

@Controller
public class JobPortalController {

	@Autowired
	UserService userService;

	@Autowired
	CandidateService candidateService;

	@RequestMapping("/")
	public String login(ModelMap modelMap) {
		User user = new User();
		modelMap.addAttribute("User", user);
		return "login";
	}
	
	@RequestMapping("/prelogin")
	public String logout(ModelMap modelMap) {
		User user = new User();
		modelMap.addAttribute("User", user);
		return "login";
	}

	@RequestMapping("/register")
	public String register(ModelMap modelMap) {
		User user = new User();
		modelMap.addAttribute("User", user);
		return "register";
	}

	@RequestMapping("/signup")
	public String signup(@ModelAttribute("user") User user, ModelMap modelMap) {
		System.out.println("user signup:" + user);
		user = userService.saveUser(user);
		modelMap.addAttribute("user", user);
		return "dashboard";
	}

	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute("User") User user, ModelMap modelMap) {
		if (user == null) {
			modelMap.addAttribute("user", user);
			modelMap.addAttribute("errorMsg", "Invalid details");
			return "login";
		}
		if (user != null) {
			if (user.getUsername() == null || user.getUsername() == "" || user.getPassword() == null
					|| user.getPassword() == "") {
				modelMap.addAttribute("user", user);
				modelMap.addAttribute("errorMsg", "Invalid details");
				return "login";
			}
			modelMap.addAttribute("User", user);
			User userNew = userService.findUserByName(user);
			if (userNew == null) {
				modelMap.addAttribute("user", user);
				modelMap.addAttribute("errorMsg", "User not found");
				return "login";
			}
		}
		return "dashboard";
	}

	@PostMapping("/addcandidate")
	public String loadAddCandidate(ModelMap modelMap) {
		Candidate candidate = new Candidate();
		modelMap.addAttribute("candidate", candidate);
		return "addcandidate";
	}

	@PostMapping("/savecandidate")
	public String saveCandidate(@ModelAttribute("candidate") Candidate candidate, ModelMap modelMap) {
		//Candidate candidate = new Candidate();
		System.out.println("candidate:"+candidate);
		if(candidate.validateCandidate()) {
			candidate = candidateService.saveCandidate(candidate);
			System.out.println("candidate.getId():"+candidate.getId());
			modelMap.addAttribute("candidate",candidate);
			return "updatecandidate";
		}else {
			modelMap.addAttribute("errorMsg", "Please fill all details.");
		}
		modelMap.addAttribute("candidate", candidate);
		return "addcandidate";
	}
	
	@PostMapping("/uploaddocument")
	public String uploadDocument(MultipartFile mp) {
		//Candidate candidate = new Candidate();
		System.out.println(mp);
		return "updatecandidate";
	}

}
