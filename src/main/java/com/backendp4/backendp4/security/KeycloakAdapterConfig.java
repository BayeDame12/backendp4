package com.backendp4.backendp4.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdapterConfig {
    @Bean
    public KeycloakSpringBootConfigResolver springBootConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }
}
