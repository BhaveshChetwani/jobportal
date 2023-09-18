package com.jobportal.repos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.Clients;
import com.jobportal.model.JobDescription;

@Repository
@Transactional
public interface ClientsRepo extends CrudRepository<Clients, Integer> {
	
}
