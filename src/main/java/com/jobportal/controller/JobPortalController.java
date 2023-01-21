package com.jobportal.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public String uploadDocument(@RequestParam("document") MultipartFile mp) {
		//Candidate candidate = new Candidate();
		System.out.println(mp);
		/*String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();*/
		return "updatecandidate";
	}
	
	public String storeFile(MultipartFile file) {
        // Normalize file name
/*        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                System.out.println("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            //Path targetLocation = this.fileStorageLocation.resolve(fileName);
            //Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
        	System.out.println("Could not store file " + fileName + ". Please try again!"+ex.getMessage());
        }*/
		return "";
    }

}
