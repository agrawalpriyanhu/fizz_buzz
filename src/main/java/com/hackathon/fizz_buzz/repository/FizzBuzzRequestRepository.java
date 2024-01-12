package com.hackathon.fizz_buzz.repository;

import com.hackathon.fizz_buzz.entity.FizzBuzzRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FizzBuzzRequestRepository extends JpaRepository<FizzBuzzRequestEntity, Long> {

    FizzBuzzRequestEntity findTopByOrderByRequestCountDesc();
    FizzBuzzRequestEntity findByInt1AndInt2AndLimitAndStr1AndStr2(Integer int1, Integer int2, Integer limit, String str1, String str2);

}
