package com.backendp4.backendp4.controller;

import com.backendp4.backendp4.dto.UserDto;
import com.backendp4.backendp4.service.LoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class AuthentificationController {
    private LoginService loginService;

    public AuthentificationController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/{type}")
    public String Login(@RequestBody UserDto userDto, @PathVariable String type) throws JsonProcessingException {
        if (type.equalsIgnoreCase("login")) {
             return loginService.getAccessToken(userDto);
        }
        return null;
    }



    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }
}
