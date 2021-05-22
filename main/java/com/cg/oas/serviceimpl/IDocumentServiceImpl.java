package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Document;
import com.cg.oas.exception.DocumentNotFoundException;
import com.cg.oas.repository.IDocumentRepository;
import com.cg.oas.service.IDocumentService;

@Service
public class IDocumentServiceImpl implements IDocumentService {
	@Autowired
	private IDocumentRepository iDocumentRepo;
	@Override
	public Document addDocument(Document document) {
		return iDocumentRepo.save(document);
	}

	@Override
	public List<Document> viewAllDocumentDetails() throws DocumentNotFoundException{
		List<Document> list=iDocumentRepo.findAll();
		if(list.isEmpty()) {
			throw new DocumentNotFoundException("No Document Found");
		}
		else
		return iDocumentRepo.findAll();
	}

	@Override
	public List<Document> deleteDocumentById(int documentId) throws DocumentNotFoundException{
		Optional<Document> optional = iDocumentRepo.findById(documentId);
		if(optional.isPresent()) {
			iDocumentRepo.deleteById(documentId);
		return iDocumentRepo.findAll();
		}
		else
			throw new DocumentNotFoundException("No Document Id");
	}

	@Override
	public Document getDocumentById(int docId) throws DocumentNotFoundException {
		Optional<Document> optional = iDocumentRepo.findById(docId);
		if(optional.isPresent()) {
			return optional.get();	
		}
		else
			throw new DocumentNotFoundException("No Document Found");
	}

	@Override
	public Document updateDocument(Document docs) throws DocumentNotFoundException {
		Optional<Document> optional = iDocumentRepo.findById(docs.getDocumentId());
		if(optional.isPresent()) {
			iDocumentRepo.save(docs);
		return docs;
		}
		else
			throw new DocumentNotFoundException("No Document Id");
	}

}