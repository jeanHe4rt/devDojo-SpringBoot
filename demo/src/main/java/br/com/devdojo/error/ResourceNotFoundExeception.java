package br.com.devdojo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.management.RuntimeErrorException;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeception extends RuntimeException {
    public ResourceNotFoundExeception(String message) {
        super(message);
    }
}
