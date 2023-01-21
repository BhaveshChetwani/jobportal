package com.jobportal.service;

import java.util.Collection;

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
		Collection<Document> documents = documentRepo.findDocumentByCandidateId(candidateId);
		if(documents!=null && documents.iterator()!=null && documents.iterator().hasNext()) {
			return documents.iterator().next();
		}
		return null;

	}

}
