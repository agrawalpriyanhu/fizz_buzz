package com.hackathon.fizz_buzz.model.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FizzBuzzRequestDTO {

    @NotNull(message = "number 'int1' must be present")
    @Min(value = 1, message = "int1 must be at least 1")
    private Integer int1;

    @NotNull(message = "number 'int2' must be present")
    @Min(value = 1, message = "int2 must be at least 1")
    private Integer int2;

    @NotNull(message = "number 'limit' must be present")
    @Min(value = 1, message = "limit must be at least 1")
    private Integer limit;

    @NotBlank(message = "str1 must not be blank")
    private String str1;

    @NotBlank(message = "str2 must not be blank")
    private String str2;

}
