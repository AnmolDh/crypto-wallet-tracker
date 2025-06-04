package com.cryptowallet.marketms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException extends RuntimeException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CoinDataException.class)
    public ResponseEntity<Map<String, Object>> handleCoinDataException(CoinDataException ex) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("error", ex.getMessage());
        errorBody.put("endpoint", ex.getEndpoint());
        errorBody.put("timestamp", ex.getTimestamp().toString());

        return new ResponseEntity<>(errorBody, HttpStatus.BAD_REQUEST);
    }

}
