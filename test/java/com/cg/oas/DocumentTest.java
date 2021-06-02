package com.cg.oas;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Document;
import com.cg.oas.entities.UserTable;
import com.cg.oas.exception.DocumentNotFoundException;
import com.cg.oas.repository.IDocumentRepository;
import com.cg.oas.service.IDocumentService;

@SpringBootTest
public class DocumentTest {
    @Autowired
    IDocumentService iDocumentService;
   
    @MockBean
    IDocumentRepository iDocumentRepo;
    @Test
    public void testAddDocument()
    {
        Document doc = new Document();
        doc.setDocumentId(702);
        doc.setDocumentName("HSC");
        doc.setDocumentUrl("http://www.hsc.com");
        doc.setApplicantId(103);
        doc.setEmailId("abc@g.com");
        doc.setDocumentStatus("Approved");
       
        Mockito.when(iDocumentRepo.save(doc)).thenReturn(doc);
        assertThat(iDocumentService.addDocument(doc)).isEqualTo(doc);
    }
    @Test
    public void testViewAllDocumentDetails()
    {
        List<Document> doc = new ArrayList<>();
        Mockito.when(iDocumentRepo.findAll()).thenReturn(doc);
        Exception ex = assertThrows(DocumentNotFoundException.class, ()-> iDocumentService.viewAllDocumentDetails());
        assertEquals("No Document Found", ex.getMessage());
       
    }
    @Test
    public void testGetDocumentById()
    {
        Document doc = new Document();
        doc.setDocumentId(702);
        doc.setDocumentName("HSC");
        doc.setDocumentUrl("http://www.hsc.com");
        doc.setApplicantId(103);
        doc.setEmailId("abc@g.com");
        doc.setDocumentStatus("Approved");
        UserTable user = new UserTable();
        user.setUserId(1006);
        Mockito.when(iDocumentRepo.findById(doc.getDocumentId())).thenReturn(Optional.of(doc));
        assertThat(iDocumentService.getDocumentById(doc.getDocumentId())).isEqualTo(doc);
    }
    @Test
    public void testUpdateDocument()
    {
        Document doc = new Document();
        doc.setDocumentId(702);
        doc.setDocumentName("HSC");
        doc.setDocumentUrl("http://www.hsc.com");
        doc.setApplicantId(103);
        doc.setEmailId("abc@g.com");
        doc.setDocumentStatus("Approved");
       
        Mockito.when(iDocumentRepo.findById(doc.getDocumentId())).thenReturn(Optional.of(doc));
       
        doc.setEmailId("supraja@gmail.com");
        Mockito.when(iDocumentRepo.save(doc)).thenReturn(doc);
       
        assertThat(iDocumentService.updateDocument(doc)).isEqualTo(doc);
       
    }
    @Test
    public void testDeleteDocument()
    {
        Document doc = new Document();
        doc.setDocumentId(702);
        doc.setDocumentName("HSC");
        doc.setDocumentUrl("http://www.hsc.com");
        doc.setApplicantId(103);
        doc.setEmailId("abc@g.com");
        doc.setDocumentStatus("Approved");
        Mockito.when(iDocumentRepo.findById(702)).thenReturn(Optional.of(doc));
        Mockito.when(iDocumentRepo.existsById(doc.getDocumentId())).thenReturn(false);
       assertFalse(iDocumentRepo.existsById(doc.getDocumentId()));
    }
}
   
