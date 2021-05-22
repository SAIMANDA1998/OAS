package com.cg.oas.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.Course;
import com.cg.oas.entities.Document;
@Repository
public interface IDocumentRepository extends JpaRepository<Document,Integer>{

//	public Document addDocument( Document document);
//	public ArrayList<Document> viewAllDocumentDetails();
//	public int deleteDocumentById(int documentId);
//	public Document getDocumentById(int docId);
//	public Document getDocumentByApplicantId(int applicationId);
//	public Document getDocumentByEmailId(String emailId);
//	public int deleteDocumentByEmail(String email);
//	public int deleteDocumentByApplicationId(int applicationId);
//	public int  updateDocument(Document docs);
}
