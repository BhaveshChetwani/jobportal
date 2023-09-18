package com.jobportal.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.Candidate;
import com.jobportal.model.JobDescription;
import com.jobportal.repos.JobDescriptionRepo;

@Service
public class JobDescriptionService {

	@Autowired
	JobDescriptionRepo jobDescriptionRepo;

	public JobDescription saveJobDescription(JobDescription candidate) {
		JobDescription jobDescriptionNew = jobDescriptionRepo.save(candidate);
		return jobDescriptionNew;

	}
	
	public JobDescription findJobDescriptionbyId(int jobDescriptionId) {
		Optional<JobDescription> candidates = jobDescriptionRepo.findById(jobDescriptionId);
		return candidates.get();

	}
	
	public ArrayList<JobDescription> searchJobDescription(JobDescription jobDescriptionInput) {
		System.out.println("jobDescriptionInput:"+jobDescriptionInput);
		ArrayList<JobDescription> jobDescriptions = new ArrayList(jobDescriptionRepo.findJobDescriptionByName(jobDescriptionInput.getName()));
		for(JobDescription jobDescription : jobDescriptions) {
			System.out.println(jobDescription.getName());
		}
		return jobDescriptions;

	}

}
