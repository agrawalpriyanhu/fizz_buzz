package com.hackathon.fizz_buzz.validator;

import com.hackathon.fizz_buzz.Constants;
import com.hackathon.fizz_buzz.exception.ApiException;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzValidator {

    public static void validateApiRequest(BindingResult bindingResult){
        List<String> errors = new ArrayList<>();
        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(error -> {
                errors.add(error.getDefaultMessage());
            });
        }
        if (!errors.isEmpty()){
            throw new ApiException(String.join(Constants.COMMA + Constants.SPACE, errors));
        }
    }

}
