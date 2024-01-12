package com.hackathon.fizz_buzz.controller;

import com.hackathon.fizz_buzz.Constants;
import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.model.response.FizzBuzzResponseDTO;
import com.hackathon.fizz_buzz.model.response.Meta;
import com.hackathon.fizz_buzz.model.response.ResponseDTO;
import com.hackathon.fizz_buzz.service.FizzBuzzService;
import com.hackathon.fizz_buzz.validator.FizzBuzzValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    @PostMapping(value = Constants.FIZZ_BUZZ)
    public ResponseEntity<ResponseDTO<FizzBuzzResponseDTO>> fizzBuzz(@RequestBody @Validated FizzBuzzRequestDTO request, BindingResult bindingResult){
        log.info("Received fizz buzz request {}", request);
        FizzBuzzValidator.validateApiRequest(bindingResult);
        FizzBuzzResponseDTO response = fizzBuzzService.processFizzBuzzRequest(request);
        return ResponseEntity.ok(ResponseDTO.getSuccessResponse(response));
    }

}
