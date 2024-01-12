package com.hackathon.fizz_buzz.model.response;

import com.hackathon.fizz_buzz.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    private Meta meta;
    private T data;

    public static <T> ResponseDTO<T> getSuccessResponse(T data){
        ResponseDTO<T> responseDTO = new ResponseDTO<>();
        responseDTO.setMeta(Meta.builder().apiStatus(Constants.SUCCESS).build());
        responseDTO.setData(data);
        return responseDTO;
    }

}
