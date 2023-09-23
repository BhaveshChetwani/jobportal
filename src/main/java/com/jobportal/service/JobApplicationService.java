package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.JobApplication;
import com.jobportal.model.JobHistory;
import com.jobportal.repos.JobApplicationRepo;
import com.jobportal.repos.JobHistoryRepo;

@Service
public class JobApplicationService {

	@Autowired
	JobApplicationRepo jobApplicationRepo;
	
	@Autowired
	JobHistoryRepo jobHistoryRepo;

	public JobApplication saveJobApplication(JobApplication jobApplication) {
		JobApplication jobApplicationNew;
		List<JobApplication> appliedJobs = (ArrayList<JobApplication>)jobApplicationRepo.checkIfAlreadyApplied(jobApplication.getCandidateId(), jobApplication.getJobDescriptionId());
		if(appliedJobs!=null && appliedJobs.size()>0) {
			jobApplicationNew = new JobApplication();
			jobApplicationNew.setMessage("Already applied for this job.");
		}else {
			jobApplicationNew = jobApplicationRepo.save(jobApplication);
			JobHistory jobHistory = new JobHistory();
			jobHistory.setCandidateId(jobApplicationNew.getCandidateId());
			jobHistory.setJobDescriptionId(jobApplicationNew.getJobDescriptionId());
			jobHistory.setJobApplicationId(jobApplicationNew.getId());
			jobHistory.setStatus("Applied");
			jobHistoryRepo.save(jobHistory);
			jobApplicationNew.setMessage("Job applied successfully.");
		}
		
		return jobApplicationNew;
	}
	
	public JobApplication findJobApplicationbyId(int jobDescriptionId) {
		Optional<JobApplication> candidates = jobApplicationRepo.findById(jobDescriptionId);
		return candidates.get();
	}
	
	public ArrayList<JobApplication> searchJobApplication(JobApplication jobApplicationInput) {
		System.out.println("jobDescriptionInput:"+jobApplicationInput);
		ArrayList<JobApplication> jobDescriptions  =null;
		if(jobApplicationInput.getClientId()!=0) {
			jobDescriptions = new ArrayList<JobApplication>(jobApplicationRepo.findJobApplicationByClientId(jobApplicationInput.getClientId()));
		}
		else if(jobApplicationInput.getCandidateId()!=0) {
			jobDescriptions = new ArrayList<JobApplication>(jobApplicationRepo.findJobApplicationByCandidateId(jobApplicationInput.getCandidateId()));
		}else {
			Iterable<JobApplication> itr = (jobApplicationRepo.findAll());
			jobDescriptions = new ArrayList<JobApplication>();
			for(JobApplication jd : itr) {
				jobDescriptions.add(jd);
			}
		}
		return jobDescriptions;

	}

}
