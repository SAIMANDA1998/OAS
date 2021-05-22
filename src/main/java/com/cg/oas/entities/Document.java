package com.cg.oas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Document
{
@Id	
private int documentId;
private String documentName;
private String documentUrl;
private int applicantId;
private String emailId;
private String documentStatus;//Uploaded/NotUploaded
public Document() {}
public int getDocumentId() {
	return documentId;
}
public void setDocumentId(int documentId) {
	this.documentId = documentId;
}
public String getDocumentName() {
	return documentName;
}
public void setDocumentName(String documentName) {
	this.documentName = documentName;
}
public String getDocumentUrl() {
	return documentUrl;
}
public void setDocumentUrl(String documentUrl) {
	this.documentUrl = documentUrl;
}
public int getApplicantId() {
	return applicantId;
}
public void setApplicantId(int applicantId) {
	this.applicantId = applicantId;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getDocumentStatus() {
	return documentStatus;
}
public void setDocumentStatus(String documentStatus) {
	this.documentStatus = documentStatus;
}

}
