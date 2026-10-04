package com.backintro.infrastructure.chatescalation.adapters.in.rest.exceptionhandlers;

import com.backintro.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatescalation.exception.ChatEscalationAlreadyExistsException;
import com.backintro.domain.chatescalation.exception.ChatEscalationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.backintro.infrastructure.chatescalation.adapters.in.rest")
public class ChatEscalationExceptionHandler {

    @ExceptionHandler({ChatEscalationNotFoundApplicationException.class, ChatEscalationNotFoundException.class})
    public ResponseEntity<Map<String, Object>> handleNotFound(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Registro no encontrado");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(ChatEscalationAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleAlreadyExists(ChatEscalationAlreadyExistsException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.CONFLICT.value());
        body.put("error", "Registro ya existente");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Map<String, Object>> handleDomainException(DomainException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Error de regla de negocio");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Error de validacion en la peticion");
        body.put("details", fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        
        String msg = ex.getMessage();
        if (msg != null && msg.toLowerCase().contains("foreign key constraint")) {
            body.put("status", HttpStatus.BAD_REQUEST.value());
            body.put("error", "Error de integridad relacional: Llave foránea no encontrada");
            body.put("message", "Una o más dependencias referenciadas no existen en la base de datos.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        } else if (msg != null && msg.toLowerCase().contains("unique constraint")) {
            body.put("status", HttpStatus.CONFLICT.value());
            body.put("error", "Error de integridad relacional: Registro duplicado");
            body.put("message", "Ya existe un registro con las mismas llaves únicas.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
        }
        
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Error interno de integridad de datos");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Error interno del servidor");
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}