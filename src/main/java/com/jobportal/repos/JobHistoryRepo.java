package com.jobportal.repos;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobportal.model.JobHistory;

@Repository
@Transactional
public interface JobHistoryRepo extends CrudRepository<JobHistory, Integer> {

	@Query("FROM JobHistory j WHERE j.candidateId =:candidateId")
	Collection<JobHistory> findJobHistoryByCandidateId(@Param("candidateId") int candidateId);
	
}
