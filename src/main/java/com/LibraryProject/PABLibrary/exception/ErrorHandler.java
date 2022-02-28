package com.LibraryProject.PABLibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LibraryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleError(LibraryNotFoundException libraryException, WebRequest webRequest){
        return new ResponseEntity<>(new ErrorResponse(libraryException.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
