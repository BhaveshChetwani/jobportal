package com.jobportal.repos;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.JobDescription;

@Repository
@Transactional
public interface JobDescriptionRepo extends CrudRepository<JobDescription, Integer> {

	@Query("SELECT j FROM JobDescription j WHERE j.name LIKE '%:name%'")
	Collection<JobDescription> findJobDescriptionByName(String name);
}
