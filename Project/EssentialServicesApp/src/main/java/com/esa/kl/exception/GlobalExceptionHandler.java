package com.esa.kl.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.esa.kl.model.ApiErrors;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc", "Http Method Not Supported");
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.ok().headers(headers)
.body(apiErrors);		
	//	return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc", "Http Media Type Not Supported");
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.ok().headers(headers)
.body(apiErrors);
		//return super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// if we  have missed any parameters in the backend
		String message=ex.getMessage();
		headers.add("desc", "Internal Server Error");
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.ok().headers(headers)
.body(apiErrors);
		//return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc", "Handle Missing Path Variable");
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.ok().headers(headers)
.body(apiErrors);
		//return super.handleMissingPathVariable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc", "Handle Type Mismatch");
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.ok().headers(headers)
.body(apiErrors);
		//return super.handleTypeMismatch(ex, headers, status, request);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleException(IdNotFoundException ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Exception occured...");
		String message=ex.getMessage();
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.EXPECTATION_FAILED);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(headers).body(apiErrors);
		
	}
	
	@ExceptionHandler(LocationNotFoundException.class)
	public ResponseEntity<Object> handleExceptionLocation(LocationNotFoundException ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Exception occured...");
		String message=ex.getMessage();
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.EXPECTATION_FAILED);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(headers).body(apiErrors);
		
	}
	
	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<Object> handleException(HospitalNotFoundException ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Exception occured...");
		String message=ex.getMessage();
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.EXPECTATION_FAILED);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(headers).body(apiErrors);
		
	}

	@ExceptionHandler(PharmacyNotFoundException.class)
	public ResponseEntity<Object> handleException(PharmacyNotFoundException ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Exception occured...");
		String message=ex.getMessage();
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.EXPECTATION_FAILED);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(headers).body(apiErrors);
		
	}
	
	@ExceptionHandler(CovidcenterNotFundException.class)
	public ResponseEntity<Object> handleException(CovidcenterNotFundException ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc", "Exception occured...");
		String message=ex.getMessage();
		ApiErrors apiErrors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.EXPECTATION_FAILED);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(headers).body(apiErrors);
		
	}
	
	
	

}
