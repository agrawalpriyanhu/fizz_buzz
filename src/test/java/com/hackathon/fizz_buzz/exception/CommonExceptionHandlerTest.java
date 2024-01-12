package com.hackathon.fizz_buzz.exception;

import com.hackathon.fizz_buzz.model.response.ResponseDTO;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommonExceptionHandlerTest {

    @InjectMocks
    private CommonExceptionHandler commonExceptionHandler;

    @Test
    void handleApiException() {
        ResponseEntity<ResponseDTO<?>> response = commonExceptionHandler.handleApiException(Mockito.mock(ApiException.class));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleInvalidRequest() {
        ResponseEntity<ResponseDTO<?>> response = commonExceptionHandler.handleInvalidRequest(Mockito.mock(HttpMessageNotReadableException.class));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleGenericException() {
        ResponseEntity<ResponseDTO<?>> response = commonExceptionHandler.handleGenericException(Mockito.mock(RuntimeException.class));
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}