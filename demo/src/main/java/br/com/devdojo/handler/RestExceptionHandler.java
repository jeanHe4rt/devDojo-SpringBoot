package br.com.devdojo.handler;

import br.com.devdojo.error.ResourceNotFoundDetails;
import br.com.devdojo.error.ResourceNotFoundExeception;
import br.com.devdojo.error.ValidationErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundExeception.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundExeception rfnException){

        ResourceNotFoundDetails rnfDetails= ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return  new ResponseEntity<>(rnfDetails, HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException manvException,
            HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
        String fiedls = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fiedlsMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        ValidationErrorDetails rnfDetails= ValidationErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Field validation Error")
                .detail("Field validation Error")
                .developerMessage(manvException.getClass().getName())
                .field(fiedls)
                .fieldMessage(fiedlsMessages)
                .build();
        return  new ResponseEntity<>(manvException, HttpStatus.BAD_REQUEST);
    }
}
