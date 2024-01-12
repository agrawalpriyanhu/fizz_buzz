package com.hackathon.fizz_buzz.controller;

import com.hackathon.fizz_buzz.Constants;
import com.hackathon.fizz_buzz.service.FizzBuzzService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class FizzBuzzControllerTest {

    @InjectMocks
    private FizzBuzzController fizzBuzzController;

    @Mock
    private FizzBuzzService fizzBuzzService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(fizzBuzzController).build();
    }
    @Test
    public void fizzBuzz() throws Exception {
        String requestJson = """
                {
                    "int1":2,
                    "int2":5,
                    "limit":10,
                    "str1":"a",
                    "str2":"b"
                }
                """;
        mockMvc.perform(post(Constants.FIZZ_BUZZ).content(requestJson).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
    }
}