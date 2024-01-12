package com.hackathon.fizz_buzz.exception;

import com.hackathon.fizz_buzz.Constants;
import com.hackathon.fizz_buzz.model.response.Meta;
import com.hackathon.fizz_buzz.model.response.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ResponseDTO<?>> handleApiException(ApiException apiException){
        log.info("Invalid request received {}", apiException.getMessage());
        return ResponseEntity
                .badRequest()
                .body(
                        ResponseDTO
                                .builder()
                                .meta(
                                        Meta
                                                .builder()
                                                .apiStatus(Constants.FAILED)
                                                .errorDesc(apiException.getMessage())
                                                .build()
                                )
                                .build()
                );
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ResponseDTO<?>> handleInvalidRequest(HttpMessageConversionException exception){
        log.info("Invalid request received {}", exception.getMessage());
        return ResponseEntity
                .badRequest()
                .body(
                        ResponseDTO
                                .builder()
                                .meta(
                                        Meta
                                                .builder()
                                                .errorDesc("Request is invalid. Please make sure you are sending proper values.")
                                                .apiStatus(Constants.FAILED)
                                                .build()
                                )
                                .build()
                );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO<?>> handleGenericException(RuntimeException e){
        log.info("Some error occurred {} {}", e.getMessage(), e.getStackTrace());
        return ResponseEntity
                .internalServerError()
                .body(
                        ResponseDTO
                                .builder()
                                .meta(
                                        Meta
                                                .builder()
                                                .apiStatus(Constants.FAILED)
                                                .errorDesc(Constants.GENERIC_ERROR_DESC)
                                                .build()
                                )
                                .build()
                );
    }

}
