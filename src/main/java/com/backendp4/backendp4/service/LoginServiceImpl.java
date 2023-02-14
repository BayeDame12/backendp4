package com.backendp4.backendp4.service;

import com.backendp4.backendp4.dto.UserDto;
import com.backendp4.backendp4.payload.response.ResponseToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


@Log4j2

@Service
public class LoginServiceImpl implements LoginService {
    private RestTemplate restTemplate;
    private static final String AUTHENTICATION_URL = "http://localhost:8080/auth/realms/backendp4/protocol/openid-connect/token";
    private static final String HELLO_URL = "http://localhost:8090/api/home";
    //
    @Value("password")
    private String apiManagGrantType;
    //
    @Value("backendp4-app")
    private String apiManagClientId;
    //
    @Value("dd4b5635-86b5-42c4-82dd-ed7ede5b9c93")
    private String apiManagClientSecret;

    public LoginServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getAccessToken(UserDto userDto) throws JsonProcessingException {
        String login = userDto.getLogin();
        String password = userDto.getPassword();
        var accesToken = "KO";
        //
        var headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        //
        map.add("grant_type", apiManagGrantType);
        map.add("client_id", apiManagClientId);
        map.add("client_secret", apiManagClientSecret);
        map.add("username", login);
        map.add("password", password);
        //
        var entity = new HttpEntity<>(map, headers);
        //
        try {
            var resultGAT = restTemplate.postForEntity(AUTHENTICATION_URL, entity, ResponseToken.class);
            if ((resultGAT.getStatusCode() == HttpStatus.OK) && (resultGAT.getBody() != null)) {
                var responseToken = resultGAT.getBody();
                accesToken = (responseToken == null) ? "KO" : responseToken.getAccess_token();
            }
        } catch (ResourceAccessException ex) {
            accesToken = "KO";
        }
        return accesToken;
    }

    @Override
    public UserDto getBody(UserDto userDto) throws JsonProcessingException {
        return userDto;
    }


}
