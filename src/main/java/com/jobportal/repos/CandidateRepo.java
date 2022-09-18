package com.jobportal.repos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.Candidate;

@Repository
@Transactional
public interface CandidateRepo extends CrudRepository<Candidate, Integer> {

}
