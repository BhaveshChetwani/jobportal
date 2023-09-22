package com.jobportal.repos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.UserRole;

@Repository
@Transactional
public interface UserRoleRepo extends CrudRepository<UserRole, Integer> {
	
}
