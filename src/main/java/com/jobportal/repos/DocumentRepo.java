package com.jobportal.repos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.model.Document;

@Repository
@Transactional
public interface DocumentRepo extends CrudRepository<Document, Integer> {

}
