package com.task.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(TaskException.class)
	public ResponseEntity<MyError> getTaskException(TaskException cust,WebRequest req){
		
		MyError myError=new MyError(cust.getMessage(), LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> getUserException(UserException cust,WebRequest req){
		
		MyError myError=new MyError(cust.getMessage(), LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> exception(Exception cust,WebRequest req){
		
		MyError myError=new MyError(cust.getMessage(), LocalDateTime.now(), req.getDescription(false));
		
		return new ResponseEntity<MyError>(myError, HttpStatus.BAD_REQUEST);
	}
}
