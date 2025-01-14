package io.wind.traders.core.global.exception.element;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TradersGlobalExceptionResponse {

    private int code;
    private String status;
    private String message;

    public TradersGlobalExceptionResponse(final GlobalExceptionType globalExceptionTypes) {
        this.code = globalExceptionTypes.getCode();
        this.status = globalExceptionTypes.getStatus();
        this.message = globalExceptionTypes.getMessage();
    }

    public static TradersGlobalExceptionResponse of(final GlobalExceptionType globalExceptionTypes) {
        return new TradersGlobalExceptionResponse(globalExceptionTypes);
    }
}
