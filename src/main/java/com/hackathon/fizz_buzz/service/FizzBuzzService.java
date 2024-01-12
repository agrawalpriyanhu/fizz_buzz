package com.hackathon.fizz_buzz.service;

import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.model.response.FizzBuzzResponseDTO;

public interface FizzBuzzService {

    FizzBuzzResponseDTO processFizzBuzzRequest(FizzBuzzRequestDTO request);
}
