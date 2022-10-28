package factura.factura.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import factura.factura.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler({ResourceNotFoundException.class,IllegalArgumentException.class})
    public ResponseEntity<String> resourceNotFoundException(Exception ex){
        return new ResponseEntity<>("Lo que buscas, no existe", HttpStatus.NOT_FOUND);
    }
}

