package eu.epitech.cashmanager.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpException {

    public NotFoundException(String message) {
        super("NOT_FOUND: " + message, HttpStatus.NOT_FOUND);
    }
}
