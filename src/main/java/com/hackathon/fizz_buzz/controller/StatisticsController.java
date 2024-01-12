package com.hackathon.fizz_buzz.controller;

import com.hackathon.fizz_buzz.Constants;
import com.hackathon.fizz_buzz.model.response.MaxHitResponseDTO;
import com.hackathon.fizz_buzz.model.response.ResponseDTO;
import com.hackathon.fizz_buzz.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;


    @GetMapping(Constants.MAX_HIT_REQUEST)
    public ResponseEntity<ResponseDTO<MaxHitResponseDTO>> getMaxHitRequests(){
        log.info("Received request to fetch max hit fizz buzz request");
        MaxHitResponseDTO maxHit = statisticsService.getMaxHitRequest();
        return ResponseEntity.ok(ResponseDTO.getSuccessResponse(maxHit));
    }

}
