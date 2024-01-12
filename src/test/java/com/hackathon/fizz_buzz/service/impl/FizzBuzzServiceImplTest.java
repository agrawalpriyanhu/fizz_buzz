package com.hackathon.fizz_buzz.service.impl;

import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.service.StatisticsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FizzBuzzServiceImplTest {

    @InjectMocks
    private FizzBuzzServiceImpl fizzBuzzService;

    @Mock
    private StatisticsService statisticsService;

    @Test
    void processFizzBuzzRequestSaveToDbErrorTest() {
        FizzBuzzRequestDTO request = getRequest();
        doThrow(new RuntimeException("DB exception")).when(statisticsService).saveRequestForStatistics(any());
        Assertions.assertEquals("1,a,3,a,b,a,7,a,9,ab", fizzBuzzService.processFizzBuzzRequest(request).getOutput());
    }

    @Test
    void processFizzBuzzRequestSaveToDbSuccessTest() {
        FizzBuzzRequestDTO request = getRequest();
        doNothing().when(statisticsService).saveRequestForStatistics(any());
        Assertions.assertEquals("1,a,3,a,b,a,7,a,9,ab", fizzBuzzService.processFizzBuzzRequest(request).getOutput());
    }

    private FizzBuzzRequestDTO getRequest() {
        return FizzBuzzRequestDTO.builder()
                .int1(2)
                .int2(5)
                .limit(10)
                .str1("a")
                .str2("b")
                .build();
    }
}