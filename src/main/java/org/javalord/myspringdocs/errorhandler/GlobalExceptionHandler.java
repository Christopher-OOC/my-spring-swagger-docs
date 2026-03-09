package org.javalord.myspringdocs.errorhandler;

import org.javalord.myspringdocs.user.dto.response.Response;
import org.javalord.myspringdocs.user.dto.response.ResponseType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<String>> handleException(MethodArgumentNotValidException ex) {

        Response<String> response = new Response<>(
                ResponseType.ERROR,
                "Something went wrong",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}