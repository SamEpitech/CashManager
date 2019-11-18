package eu.epitech.cashmanager.exception;

import org.springframework.http.HttpStatus;

public class ServerException extends HttpException {
    public ServerException(String message) {
        super("SERVER_ERROR: " + message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
