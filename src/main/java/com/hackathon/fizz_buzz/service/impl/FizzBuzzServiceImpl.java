package com.hackathon.fizz_buzz.service.impl;

import com.hackathon.fizz_buzz.Constants;
import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.model.response.FizzBuzzResponseDTO;
import com.hackathon.fizz_buzz.service.FizzBuzzService;
import com.hackathon.fizz_buzz.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private final StatisticsService statisticsService;

    @Override
    public FizzBuzzResponseDTO processFizzBuzzRequest(FizzBuzzRequestDTO request) {
        saveRequestToDb(request);
        log.info("Processing the request {}", request);
        String result = applyFizzBuzzLogic(request);
        log.info("Processed the request. The result for the request {} is {}", request, result);
        return FizzBuzzResponseDTO.builder().output(result).build();
    }

    private void saveRequestToDb(FizzBuzzRequestDTO request) {
        try{
            log.info("Process to save the request initiated for the request {}", request);
            statisticsService.saveRequestForStatistics(request);
            log.info("Record saved successfully");
        }
        catch (Exception e){
            log.error("Some error occurred while saving the request to db {} {}", e.getMessage(), e.getStackTrace());
        }
    }

    private String applyFizzBuzzLogic(FizzBuzzRequestDTO request) {
        StringBuilder responseBuilder = new StringBuilder();
        // Taking limit also while processing
        for (int i = 1; i <= request.getLimit(); i++){
            responseBuilder.append(getStringToAppend(i, request)).append(Constants.COMMA);
        }
        // Deleting the redundant comma at the end
        responseBuilder.deleteCharAt(responseBuilder.length() - 1);
        return responseBuilder.toString();
    }

    private String getStringToAppend(int i, FizzBuzzRequestDTO request) {
        int int1 = request.getInt1();
        int int2 = request.getInt2();
        int product = request.getInt1() * request.getInt2();
        if (i % product == 0){
            return request.getStr1() + request.getStr2();
        }
        if (i % int1 == 0) {
            return request.getStr1();
        }
        if (i % int2 == 0){
            return request.getStr2();
        }
        return String.valueOf(i);
    }
}
