package com.backendp4.backendp4.service;

import com.backendp4.backendp4.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginService {
     String getAccessToken(UserDto userDto) throws JsonProcessingException;
     UserDto getBody(UserDto userDto) throws JsonProcessingException;
}
