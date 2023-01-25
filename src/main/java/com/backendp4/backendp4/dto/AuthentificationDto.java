package com.backendp4.backendp4.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthentificationDto extends ResponseDto{

    private String token;
    public AuthentificationDto (String token){

        super();
        this.token=token;
    }
}
