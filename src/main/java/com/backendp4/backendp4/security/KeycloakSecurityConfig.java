package com.backendp4.backendp4.security;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakSecurityContextRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

@KeycloakConfiguration
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.headers().frameOptions().disable().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilterAfter(keycloakSecurityContextRequestFilter(), SecurityContextHolderAwareRequestFilter.class).addFilterAfter(keycloakAuthenticatedActionsRequestFilter(), KeycloakSecurityContextRequestFilter.class).authorizeRequests()

                //.antMatchers("/api/usager","/api/user","/api/vto","/api/vpt").hasRole("admin")
/*   .antMatchers("/api/user/login").permitAll()
   .antMatchers("/api/user").permitAll()
   .antMatchers("/api/vto").permitAll()
   .antMatchers("/api/vpt").permitAll()
   .antMatchers("/api/usager").permitAll()
   .antMatchers("/api/vto/**").permitAll()
   .antMatchers("/api/vpt/**").permitAll()
   .antMatchers("/api/usager/**").permitAll()*/
                // .antMatchers("/api/vpt").hasRole("admin")
                .antMatchers("/api/login").permitAll()
                .antMatchers("http://localhost:8080/auth/realms/backendp4/protocol/openid-connect/token").permitAll()
                .anyRequest().permitAll();
        //.anyRequest().authenticated();

    }

}
