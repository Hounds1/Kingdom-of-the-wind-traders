package io.wind.traders.core.global.exception.element;

import lombok.Getter;

@Getter
public enum GlobalExceptionType {

    /**
     * Global (0)
     */
    BAD_REQUEST(400, "0001", "Invalid Request has been detected."),

    /**
     * User (1)
     */
    USER_NOT_FOUND(404, "1001", "The user with the given ID was not found."),
    DUPLICATED_LOGIN_ID(400, "1002", "The Login ID is already in use."),
    DUPLICATED_NICKNAME(400, "1003", "The nickname is already in use."),
    USER_MODIFY_FAILED(500, "1004", "Failed to modify the user due to an internal error."),
    USER_DELETE_FAILED(500, "1005", "The user does not exist and could not be deleted."),
    EMPTY_LOGIN_ID_FIELD(400, "1006", "The Login ID field is required."),
    EMPTY_NICKNAME_FIELD(400, "1007", "The Nickname field is required."),
    EMPTY_PASSWORD_FIELD(400, "1008", "The Password field is required."),
    USER_CREATION_REQUEST_NOT_FOUND(400, "1009", "The user creation request is missing or invalid. Please check the input."),
    BANNED_USER(403, "1010", "The user has been banned and cannot access the resource."),

    /**
     * Auth (8)
     */
    PASSWORD_MISMATCHED(403, "8000", "Access denied to account."),
    TOKEN_NOT_FOUND(400, "8001", "The Token was not found."),
    INVALID_JWT_TOKEN(403, "8002", "Invalid JWT Token has been detected.");

    private final int code;
    private final String status;
    private final String message;

    GlobalExceptionType(int code, String status, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
