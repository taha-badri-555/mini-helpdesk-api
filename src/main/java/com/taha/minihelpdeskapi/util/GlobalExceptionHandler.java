package com.taha.minihelpdeskapi.util;

import com.taha.minihelpdeskapi.exception.TicketNotFoundException;
import com.taha.minihelpdeskapi.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public record ApiError(String message, HttpStatus status, LocalDateTime timestamp) {
        public ApiError(Exception e, HttpStatus status) {
            this(e.getMessage(), status, LocalDateTime.now());
        }

    }

    private ResponseEntity<ApiError> handleException(Exception exception, HttpStatus status) {
        return new ResponseEntity<>(new ApiError(exception, status), status);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleUserNotFoundException(
            UserNotFoundException exception) {
        return handleException(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleTicketNotFoundException(
            TicketNotFoundException exception) {
        return handleException(exception, HttpStatus.NOT_FOUND);
    }
}
