package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.Candidate;
import com.jobportal.repos.CandidateRepo;

@Service
public class CandidateService {

	@Autowired
	CandidateRepo candidateRepo;

	public Candidate saveCandidate(Candidate candidate) {
		Candidate candidateNew = candidateRepo.save(candidate);
		return candidateNew;

	}

}
