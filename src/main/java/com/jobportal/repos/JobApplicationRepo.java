package com.jobportal.repos;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobportal.model.JobApplication;

@Repository
@Transactional
public interface JobApplicationRepo extends CrudRepository<JobApplication, Integer> {

	@Query("FROM JobApplication j WHERE j.candidateId =:candidateId")
	Collection<JobApplication> findJobApplicationByCandidateId(@Param("candidateId") int candidateId);
	
	@Query("FROM JobApplication j WHERE j.candidateId =:candidateId AND j.jobDescriptionId =:jobDescriptionId AND j.state='P'")
	Collection<JobApplication> checkIfAlreadyApplied(@Param("candidateId") int candidateId, @Param("jobDescriptionId") int jobDescriptionId);
	
	@Query("FROM JobApplication j WHERE j.clientId =:clientId")
	Collection<JobApplication> findJobApplicationByClientId(@Param("clientId") int clientId);
}
