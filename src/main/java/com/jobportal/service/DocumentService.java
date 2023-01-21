package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.Document;
import com.jobportal.repos.DocumentRepo;

@Service
public class DocumentService {

	@Autowired
	DocumentRepo documentRepo;

	public Document saveDocument(Document document) {
		Document documentNew = documentRepo.save(document);
		return documentNew;

	}
	
	public Document getDocumentByCandidateId(String candidateId) {
		return null;

	}

}
