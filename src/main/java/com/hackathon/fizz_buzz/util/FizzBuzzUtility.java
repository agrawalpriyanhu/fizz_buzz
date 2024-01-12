package com.hackathon.fizz_buzz.util;

import com.hackathon.fizz_buzz.entity.FizzBuzzRequestEntity;
import com.hackathon.fizz_buzz.model.request.FizzBuzzRequestDTO;
import com.hackathon.fizz_buzz.model.response.MaxHitResponseDTO;

public class FizzBuzzUtility {

    public static FizzBuzzRequestEntity getFizzBuzzRequestEntityFromDTO(FizzBuzzRequestDTO request) {
        return FizzBuzzRequestEntity.builder()
                .int1(request.getInt1())
                .int2(request.getInt2())
                .limit(request.getLimit())
                .str1(request.getStr1())
                .str2(request.getStr2())
                .build();
    }

    public static MaxHitResponseDTO getMaxHitResponseDTOFromFizzBuzzRequestEntity(FizzBuzzRequestEntity fizzBuzzRequestEntity) {
        return MaxHitResponseDTO.builder()
                .count(fizzBuzzRequestEntity.getRequestCount())
                .str1(fizzBuzzRequestEntity.getStr1())
                .str2(fizzBuzzRequestEntity.getStr2())
                .int1(fizzBuzzRequestEntity.getInt1())
                .int2(fizzBuzzRequestEntity.getInt2())
                .limit(fizzBuzzRequestEntity.getLimit())
                .build();
    }
}
