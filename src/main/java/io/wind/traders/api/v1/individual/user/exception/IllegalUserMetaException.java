package io.wind.traders.api.v1.individual.user.exception;

import io.wind.traders.core.global.exception.element.GlobalExceptionType;
import io.wind.traders.core.global.exception.element.TradersGlobalException;

public class IllegalUserMetaException extends TradersGlobalException {

    /**
     * UserExceptionType starts with (1)
     */
    public IllegalUserMetaException(GlobalExceptionType type) {
        super(type);
    }
}
