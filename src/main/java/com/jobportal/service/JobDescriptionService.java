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
		ArrayList<JobDescription> jobDescriptions  =null;
		if(jobDescriptionInput.getName()!=null && jobDescriptionInput.getName()!="") {
			jobDescriptions = new ArrayList<JobDescription>(jobDescriptionRepo.findJobDescriptionByName("%"+jobDescriptionInput.getName()+"%"));
		}else if(jobDescriptionInput.getClientId()!=null && jobDescriptionInput.getClientId()!="") {
			jobDescriptions = new ArrayList<JobDescription>(jobDescriptionRepo.findJobDescriptionByClientId(jobDescriptionInput.getClientId()));
		}else {
			Iterable<JobDescription> itr = (jobDescriptionRepo.findAll());
			jobDescriptions = new ArrayList<JobDescription>();
			for(JobDescription jd : itr) {
				jobDescriptions.add(jd);
			}
		}
		for(JobDescription jobDescription : jobDescriptions) {
			System.out.println(jobDescription.getName());
		}
		return jobDescriptions;

	}

}
