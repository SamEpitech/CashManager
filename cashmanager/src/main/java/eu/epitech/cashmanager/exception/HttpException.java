package eu.epitech.cashmanager.exception;

import org.springframework.http.HttpStatus;

public abstract class HttpException extends RuntimeException {
    private final HttpStatus statusCode;

    HttpException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
