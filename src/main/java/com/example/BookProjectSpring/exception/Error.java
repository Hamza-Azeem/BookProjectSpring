package com.example.BookProjectSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public class Error {
    private String message;
    private HttpStatusCode code;
    private LocalDateTime localDateTime;

    public Error(String message, HttpStatusCode code) {
        this.message = message;
        this.code = code;
        this.localDateTime = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatusCode getCode() {
        return code;
    }

    public void setCode(HttpStatusCode code) {
        this.code = code;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
