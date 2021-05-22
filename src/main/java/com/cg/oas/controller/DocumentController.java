package com.cg.oas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oas.entities.Document;
import com.cg.oas.repository.IDocumentRepository;
import com.cg.oas.service.IDocumentService;

@RestController
@RequestMapping("/Document")
	public class DocumentController {
		@Autowired
		private IDocumentService iDocumentService;
		@Autowired
		private IDocumentRepository iDocumentRepo;
		
		@PostMapping("/addDocument")
		public ResponseEntity<Document> addDocument(@RequestBody Document document)
		{
			Document obj=iDocumentService.addDocument(document);
			return new ResponseEntity<Document>(obj, HttpStatus.OK);
		}
		
		@GetMapping("/Viewalldocumentdetails")
		public ResponseEntity<List<Document>> viewAllDocumentDetails() 
	  {
			  List<Document> list=iDocumentService.viewAllDocumentDetails();
			  return new ResponseEntity<List<Document>>(list, HttpStatus.OK);
		  }
		@GetMapping("/getdocumentDetailsById/{documentId}")
		 public ResponseEntity<Document> getDocument(@PathVariable Integer docId)
			{
			Document obj=iDocumentService.getDocumentById(docId);
				return new ResponseEntity<Document>(obj, HttpStatus.OK);
			}
		
		@DeleteMapping("/deletedocumentById/{documentId}")
		 public ResponseEntity<List<Document>> deleteDocument(@PathVariable Integer documentId)
			{
			List<Document> obj=iDocumentService.deleteDocumentById(documentId);
				return new ResponseEntity<List<Document>>(obj, HttpStatus.OK);
			}
		
		@PutMapping("/updatedocumentDetails")
		 public ResponseEntity<Document> updateDocument(@RequestBody Document docs)
			{
			Document obj=iDocumentService.updateDocument(docs);
				return new ResponseEntity<Document>(obj, HttpStatus.OK);
			}
		

	}

