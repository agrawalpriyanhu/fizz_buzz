package com.hackathon.fizz_buzz.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MaxHitResponseDTO {

    private Integer int1;
    private Integer int2;
    private Integer limit;
    private String str1;
    private String str2;
    private Integer count;

}
