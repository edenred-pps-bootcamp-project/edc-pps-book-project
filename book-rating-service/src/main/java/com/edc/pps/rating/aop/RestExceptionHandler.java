package com.edc.pps.rating.aop;

import com.edc.pps.rating.exception.BadRequestException;
import com.edc.pps.rating.exception.RatingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(RatingNotFoundException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message:", exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequest(BadRequestException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("Timestamp: ", LocalDateTime.now());
        body.put("Message:", exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
