package com.microfocus.entcounion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailSendFailedException extends RuntimeException{
    public EmailSendFailedException(String message) {
        super(message);
    }

    public EmailSendFailedException(Exception e) {
        super(e);
    }
}
