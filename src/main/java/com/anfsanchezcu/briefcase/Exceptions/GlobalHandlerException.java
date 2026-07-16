package com.anfsanchezcu.briefcase.Exceptions;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anfsanchezcu.briefcase.models.Error;

@RestControllerAdvice
public class GlobalHandlerException {

  
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Error> handleIllegalArgumentException(
          IllegalArgumentException ex) {

      Error error = new Error(
              "Validation failed",
              ex.getMessage(),
              HttpStatus.BAD_REQUEST.value(),
              new Date()
      );

      return ResponseEntity.badRequest().body(error);
  }


  @ExceptionHandler(BindException.class)
  public ResponseEntity<Error> handleBindException(BindException ex) {

      Error response = new Error(
        ex.getFieldError().getDefaultMessage(),
        "Validation failed",
        HttpStatus.BAD_REQUEST.value(),
        new Date()
      );

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> handleException(Exception e) {
    Error error = new Error();
    error.setMessage(e.getMessage());
    error.setError("Internal Server Error");
    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    error.setDate(new Date());
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
