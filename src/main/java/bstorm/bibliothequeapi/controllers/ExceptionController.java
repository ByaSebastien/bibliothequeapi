package bstorm.bibliothequeapi.controllers;

import bstorm.bibliothequeapi.exceptions.PreconditionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({PreconditionFailedException.class,RuntimeException.class})
    public ResponseEntity<Object> handlePrecondition(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
