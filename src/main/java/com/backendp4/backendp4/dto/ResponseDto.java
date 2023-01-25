package com.backendp4.backendp4.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDto {
    private Integer status;
    private String message;

    public ResponseDto() {
    }

    public ResponseDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
