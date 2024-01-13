package com.hackathon.fizz_buzz.service.impl;

import com.hackathon.fizz_buzz.entity.FizzBuzzRequestEntity;
import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.model.response.MaxHitResponseDTO;
import com.hackathon.fizz_buzz.repository.FizzBuzzRequestRepository;
import com.hackathon.fizz_buzz.service.StatisticsService;
import com.hackathon.fizz_buzz.util.FizzBuzzUtility;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsServiceImpl implements StatisticsService {

    private final FizzBuzzRequestRepository fizzBuzzRequestRepository;

    /*
     * Below method is async because failure while saving is immaterial for the end user.
     * So, any which way the request should be processed and making below method async will
     * increase the api performance
     * */

    @Override
    @Async
    @Transactional
    public void saveRequestForStatistics(FizzBuzzRequestDTO request) {
        log.info("Fetching the entity for request from db {}", request);
        FizzBuzzRequestEntity fizzBuzzRequestEntity = fizzBuzzRequestRepository.findByInt1AndInt2AndLimitAndStr1AndStr2(request.getInt1(),
                request.getInt2(), request.getLimit(), request.getStr1(), request.getStr2());
        if (fizzBuzzRequestEntity != null){
            log.info("Existing record found for the request {}", request);
            log.info("Saving the updated value");
            fizzBuzzRequestEntity.setRequestCount(fizzBuzzRequestEntity.getRequestCount() + 1);
        }
        else {
            log.info("No existing record found for the request {}", request);
            log.info("Saving the new record for the request {}", request);
            fizzBuzzRequestEntity = FizzBuzzUtility.getFizzBuzzRequestEntityFromDTO(request);
            fizzBuzzRequestEntity.setRequestCount(1);
        }
        fizzBuzzRequestRepository.save(fizzBuzzRequestEntity);
    }



    @Override
    public MaxHitResponseDTO getMaxHitRequest() {
        log.info("Fetching the max hit request from database");
        FizzBuzzRequestEntity fizzBuzzRequestEntity = fizzBuzzRequestRepository.findTopByOrderByRequestCountDesc();
        if (fizzBuzzRequestEntity == null){
            log.info("No hit found");
            return MaxHitResponseDTO.builder().count(null).build();
        }
        log.info("Record fetched successfully");
        return FizzBuzzUtility.getMaxHitResponseDTOFromFizzBuzzRequestEntity(fizzBuzzRequestEntity);
    }


}
