package com.jobportal.repos;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.User;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.username=?1")
	Collection<User> findAllActiveUsers(String name);
}
