package io.wind.traders.core.global.exception.element;

import lombok.Getter;

@Getter
public class TradersGlobalException extends RuntimeException {

    private final GlobalExceptionType type;


    public TradersGlobalException(final GlobalExceptionType type) {
        super(type.getMessage());
        this.type = type;
    }
}
