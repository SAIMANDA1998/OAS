package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.Document;

public interface IDocumentService {

	public Document addDocument( Document document);
	public List<Document> viewAllDocumentDetails();
	public List<Document> deleteDocumentById(int documentId);
	public Document getDocumentById(int docId);
	//public Document getDocumentByApplicantId(int applicationId);
	//public Document getDocumentByEmailId(String emailId);
	//public int deleteDocumentByEmail(String email);
	//public int deleteDocumentByApplicationId(int applicationId);
	public Document  updateDocument(Document docs);
}
