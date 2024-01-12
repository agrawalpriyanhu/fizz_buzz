package com.hackathon.fizz_buzz.service.impl;

import com.hackathon.fizz_buzz.entity.FizzBuzzRequestEntity;
import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.repository.FizzBuzzRequestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticsServiceImplTest {

    @InjectMocks
    private StatisticsServiceImpl statisticsService;

    @Mock
    private FizzBuzzRequestRepository fizzBuzzRequestRepository;

    @Test
    void saveRequestForStatisticsRecordExistTest() {
        FizzBuzzRequestDTO fizzBuzzRequestDTO = FizzBuzzRequestDTO.builder().int1(3)
                .int2(5).limit(20).str1("a").str2("b").build();
        FizzBuzzRequestEntity entity = FizzBuzzRequestEntity.builder().int1(3)
                .int2(5).limit(20).str1("a").str2("b").requestCount(25).build();
        when(fizzBuzzRequestRepository.findByInt1AndInt2AndLimitAndStr1AndStr2(any(), any(), any(), any(), any())).thenReturn(entity);
        statisticsService.saveRequestForStatistics(fizzBuzzRequestDTO);
        Mockito.verify(fizzBuzzRequestRepository, Mockito.times(1)).save(any());
    }

    @Test
    void saveRequestForStatisticsRecordNotExistTest() {
        FizzBuzzRequestDTO fizzBuzzRequestDTO = FizzBuzzRequestDTO.builder().int1(3)
                .int2(5).limit(20).str1("a").str2("b").build();
        when(fizzBuzzRequestRepository.findByInt1AndInt2AndLimitAndStr1AndStr2(any(), any(), any(), any(), any())).thenReturn(null);
        statisticsService.saveRequestForStatistics(fizzBuzzRequestDTO);
        Mockito.verify(fizzBuzzRequestRepository, Mockito.times(1)).save(any());
    }

    @Test
    void getMaxHitRequestNotHitTest() {
        when(fizzBuzzRequestRepository.findTopByOrderByRequestCountDesc()).thenReturn(null);
        Assertions.assertNull(statisticsService.getMaxHitRequest().getCount());
    }

    @Test
    void getMaxHitRequestHitTest() {
        FizzBuzzRequestEntity entity = FizzBuzzRequestEntity.builder().requestCount(2)
                .id(124l).str2("a").str1("b").limit(25).int2(2).int1(5).build();
        when(fizzBuzzRequestRepository.findTopByOrderByRequestCountDesc()).thenReturn(entity);
        Assertions.assertEquals(2, statisticsService.getMaxHitRequest().getCount());
    }
}