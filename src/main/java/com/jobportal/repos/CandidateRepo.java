package com.jobportal.repos;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.Candidate;

@Repository
@Transactional
public interface CandidateRepo extends CrudRepository<Candidate, Integer> {
	
	@Query("SELECT c FROM Candidate c WHERE c.name=?1")
	Collection<Candidate> findCandidatesByName(String name);
	
}
