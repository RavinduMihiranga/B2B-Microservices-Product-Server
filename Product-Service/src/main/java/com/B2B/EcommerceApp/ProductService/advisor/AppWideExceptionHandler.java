package com.B2B.EcommerceApp.ProductService.advisor;


import com.B2B.EcommerceApp.ProductService.exception.NotFoundException;
import com.B2B.EcommerceApp.ProductService.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(
                new StandardResponse(404, "Not Found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

}