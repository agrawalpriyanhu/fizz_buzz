package com.hackathon.fizz_buzz.service;

import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.model.response.MaxHitResponseDTO;

public interface StatisticsService {

    void saveRequestForStatistics(FizzBuzzRequestDTO request);

    MaxHitResponseDTO getMaxHitRequest();

}
