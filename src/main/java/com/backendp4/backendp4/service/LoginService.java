package com.backendp4.backendp4.service;

import com.backendp4.backendp4.dto.ResponseDto;
import com.backendp4.backendp4.model.User;

import java.util.Optional;

public interface LoginService {

    String token(String username, String password);


}
