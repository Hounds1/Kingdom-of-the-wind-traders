package io.wind.traders.core.global.exception.advice;

import io.wind.traders.core.global.exception.element.GlobalExceptionType;
import io.wind.traders.core.global.exception.element.TradersGlobalException;
import io.wind.traders.core.global.exception.element.TradersGlobalExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(TradersGlobalException.class)
    public ResponseEntity<TradersGlobalExceptionResponse> handleTradersGlobalException(TradersGlobalException e) {
        GlobalExceptionType type = e.getType();

        return new ResponseEntity<>(TradersGlobalExceptionResponse.of(type), HttpStatus.valueOf(type.getCode()));
    }
}
