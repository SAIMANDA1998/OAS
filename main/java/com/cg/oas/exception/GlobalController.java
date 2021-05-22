package com.cg.oas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalController {
	@ExceptionHandler(value = { AddressIdNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(AddressIdNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { ApplicationNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(ApplicationNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { BranchNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(BranchNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { CollegeNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(CollegeNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { CourseNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(CourseNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { DocumentNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(DocumentNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { PaymentNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(PaymentNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { ProgramScheduleNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(ProgramScheduleNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { ProgramNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(ProgramNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { UniversityNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(UniversityNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	@ExceptionHandler(value = { UserNotFoundException.class})
	  public ResponseEntity<Object> handleOnlineAdmissionException(UserNotFoundException ex, WebRequest request)
	  {
	      String bodyOfResponse = ex.getLocalizedMessage();
		  return new ResponseEntity(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	
	
	

}
