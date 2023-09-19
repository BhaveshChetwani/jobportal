package com.jobportal.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jobportal.model.Candidate;
import com.jobportal.model.Clients;
import com.jobportal.model.Document;
import com.jobportal.model.JobDescription;
import com.jobportal.model.User;
import com.jobportal.service.CandidateService;
import com.jobportal.service.ClientsService;
import com.jobportal.service.DocumentService;
import com.jobportal.service.JobDescriptionService;
import com.jobportal.service.UserService;

@Controller
public class JobPortalController {

	@Autowired
	UserService userService;

	@Autowired
	CandidateService candidateService;
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	JobDescriptionService jobDescriptionService;
	
	@Autowired
	ClientsService clientsService;

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
	
	@RequestMapping("/searchcandidate")
	public String searchCandidate(@RequestParam(name="candidateId", required=false) String candidateId, @RequestParam(name="candidateName", required=false) String candidateName, @RequestParam(name="candidateEmail", required=false) String candidateEmail, ModelMap modelMap) {
		System.out.println("candidateId:"+candidateId);
		System.out.println("candidateName:"+candidateName);
		System.out.println("candidateEmail:"+candidateEmail);
		if(candidateId!=null && candidateId!="") {
			int id = Integer.parseInt(candidateId);
			Candidate candidate = candidateService.findCandidatebyId(id);
			modelMap.addAttribute("candidate", candidate);
			return "addcandidate";
		}
			modelMap.addAttribute("candidateName", candidateName);
			modelMap.addAttribute("candidateEmail", candidateEmail);
			Candidate candidate = new Candidate();
			candidate.setName(candidateName);
			ArrayList<Candidate> candidates = candidateService.searchCandidate(candidate);
			modelMap.addAttribute("candidates", candidates);
			return "searchcandidate";
		
	}
	
	@RequestMapping("/searchjobdescription")
	public String searchJobDescription(@RequestParam(name="jobDescriptionName", required=false) String jobDescriptionName, @RequestParam(name="jobDescriptionLocation", required=false) String jobDescriptionLocation, @RequestParam(name="jobDescriptionClientId", required=false) String jobDescriptionClientId, ModelMap modelMap) {
		
		System.out.println("jobDescriptionName:"+jobDescriptionName);
		System.out.println("jobDescriptionLocation:"+jobDescriptionLocation);
		System.out.println("jobDescriptionClientId:"+jobDescriptionClientId);
		
		List<Clients> clientsList = clientsService.findAllClients();
		modelMap.addAttribute("clientsList", clientsList);
		
		modelMap.addAttribute("jobDescriptionName", jobDescriptionName);
		modelMap.addAttribute("jobDescriptionLocation", jobDescriptionLocation);
		modelMap.addAttribute("jobDescriptionClientId", jobDescriptionClientId);
		JobDescription jobDescription = new JobDescription();
		jobDescription.setName(jobDescriptionName);
		jobDescription.setClientId(jobDescriptionClientId);
		ArrayList<JobDescription> jobDescriptions = jobDescriptionService.searchJobDescription(jobDescription);
		modelMap.addAttribute("jobDescriptions", jobDescriptions);
		return "searchjobdescription";
		
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
			
			Document document = documentService.getDocumentByCandidateId(candidate.getId()+"");
			if(document!=null && document.getUuid()!=null && document.getUuid()!="") {
				modelMap.addAttribute("document",document);
			}else {
				modelMap.addAttribute("document",new Document());
			}
			
			return "updatecandidate";
		}else {
			modelMap.addAttribute("errorMsg", "Please fill all details.");
		}
		modelMap.addAttribute("candidate", candidate);
		return "addcandidate";
	}
	
	@PostMapping("/uploaddocument")
	public String uploadDocument(@RequestParam("document") MultipartFile mp,@RequestParam("candidateId") String candidateId) {
		System.out.println(mp);
		System.out.println(candidateId);
		UUID uuid=UUID.randomUUID();
		StringBuffer actualFileName = new StringBuffer(mp.getOriginalFilename());
		StringBuffer filePath = new StringBuffer("E:\\work\\zdocs\\"+uuid+"\\"+actualFileName);
		StringBuffer dirPath = new StringBuffer("E:\\work\\zdocs\\"+uuid);
		File file = new File(dirPath.toString());
		if(!file.exists()) {
			file.mkdir();
		}
		File convFile = new File(filePath.toString());
		
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(mp.getBytes());
            fos.close(); //IOUtils.closeQuietly(fos);
            Document document = new Document();
    		document.setCandidateId(candidateId);
    		document.setDocumentName(actualFileName.toString());
    		document.setUuid(uuid.toString());
    		
    		documentService.saveDocument(document);
        } catch (IOException e) {
            convFile = null;
        }
		return "updatecandidate";
	}
	
	@PostMapping("/addjobdescription")
	public String loadAddJobDescription(ModelMap modelMap) {
		JobDescription jobDescription = new JobDescription();
		modelMap.addAttribute("jobDescription", jobDescription);
		List<Clients> clientsList = clientsService.findAllClients();
		modelMap.addAttribute("clientsList", clientsList);
		return "addjobdescription";
	}
	
	@PostMapping("/savejobdescription")
	public String saveJobDescription(@ModelAttribute("jobDescription") JobDescription jobDescription, ModelMap modelMap) {
		//Candidate candidate = new Candidate();
		System.out.println("candidate:"+jobDescription);
		if(jobDescription.validateJobDescription()) {
			jobDescription = jobDescriptionService.saveJobDescription(jobDescription);
			System.out.println("candidate.getId():"+jobDescription.getId());
			modelMap.addAttribute("candidate",jobDescription);
			
			return "dashboard";
		}else {
			modelMap.addAttribute("errorMsg", "Please fill all details.");
		}
		modelMap.addAttribute("jobDescription", jobDescription);
		return "addjobdescription";
	}
	
}
