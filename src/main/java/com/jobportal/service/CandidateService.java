package com.jobportal.service;

import java.util.ArrayList;
import java.util.Optional;

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
	
	public Candidate findCandidatebyId(int candidateId) {
		Optional<Candidate> candidates = candidateRepo.findById(candidateId);
		return candidates.get();

	}
	
	public ArrayList<Candidate> searchCandidate(Candidate candidate) {
		ArrayList<Candidate> candidates = new ArrayList(candidateRepo.findCandidatesByName(candidate.getName()));
		for(Candidate cand : candidates) {
			System.out.println(cand.getName());
		}
		return candidates;

	}

}
