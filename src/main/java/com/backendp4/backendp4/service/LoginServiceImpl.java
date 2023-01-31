package com.backendp4.backendp4.service;

import com.mysql.cj.Constants;
import org.keycloak.representations.docker.DockerResponseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;


@Service
@Log4j2
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    @Value("${keycloak.auth-server-url}")
    private String keycloakUrlBase;
    // private String keycloakUrlBase = "";

    //
    private String keycloakRealm = "${keycloak.realm}";
    //
    private String keycloakClientId = "backendp4-app";
    //
    private String keycloakClientSecret = "29ee4a1f-df98-42f3-bae3-91370f6469a6";
    //
    // @Value("${backoffice.grant-type}")
    private String keycloakGrantType = "password";
    private final RestTemplate restTemplate;

    @Override
    public String token(String username, String password) {
        var accesToken = "KO";
        //
        var headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        //
        map.add("client_id", keycloakClientId);
        map.add("client_secret", keycloakClientSecret);
        map.add("grant_type", keycloakGrantType);
        map.add("username", username);
        map.add("password", password);
        //
        var entity = new HttpEntity<>(map, headers);
        //
        try {
            var result = restTemplate.postForEntity(keycloakUrlBase + "/realms/" + keycloakRealm + "/protocol/openid-connect/token", entity, DockerResponseToken.class);
            if ((result.getStatusCode() == HttpStatus.OK) && (result.getBody() != null)) {
                var responseToken = result.getBody();
                accesToken = (responseToken == null) ? "KO" : responseToken.getAccessItems().toString();
            }
        } catch (HttpClientErrorException httpClErrorEx) {
            accesToken = "KO";
        }
        return accesToken;


    }
}
