package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.JobHistory;
import com.jobportal.repos.JobHistoryRepo;

@Service
public class JobHistoryService {

	@Autowired
	JobHistoryRepo jobHistoryRepo;

	public JobHistory saveJobHistory(JobHistory jobHistory) {
		JobHistory jobHistoryNew = jobHistoryRepo.save(jobHistory);
		return jobHistoryNew;
	}
	
	public List<JobHistory> findJobHistorybyId(int candidateId) {
		List<JobHistory> history = (ArrayList<JobHistory>) jobHistoryRepo.findJobHistoryByCandidateId(candidateId);
		return history;
	}
	
	public ArrayList<JobHistory> searchJobHistory(JobHistory jobApplicationInput) {
		System.out.println("jobDescriptionInput:"+jobApplicationInput);
		ArrayList<JobHistory> jobDescriptions  =null;
		if(jobApplicationInput.getCandidateId()!=0) {
			
		}else {
			Iterable<JobHistory> itr = (jobHistoryRepo.findAll());
			jobDescriptions = new ArrayList<JobHistory>();
			for(JobHistory jd : itr) {
				jobDescriptions.add(jd);
			}
		}
		return jobDescriptions;

	}

}
