package com.jobportal.repos;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.Document;
import com.jobportal.model.User;

@Repository
@Transactional
public interface DocumentRepo extends CrudRepository<Document, Integer> {
	
	@Query("SELECT u FROM Document u WHERE u.candidateId=?1")
	Collection<Document> findDocumentByCandidateId(String candidateId);
}
