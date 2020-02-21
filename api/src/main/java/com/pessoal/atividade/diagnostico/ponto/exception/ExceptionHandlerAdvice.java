package com.pessoal.atividade.diagnostico.ponto.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    public static final String INTERNAL_ERROR = "Ocorreu um erro inesperado.";

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<Object> usuarioNotFoundHandler(UsuarioNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<Object> handleUserInvalid(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<Object> handleNullPointer(Exception ex, WebRequest request) {
        return new ResponseEntity<>(INTERNAL_ERROR, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
