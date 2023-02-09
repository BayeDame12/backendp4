package com.backendp4.backendp4.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

public class AuthentificationController {
    /*    @PostMapping("/{type}")
    public String Login(@RequestBody UserDto userDto, @PathVariable String type) {
        if (type.equalsIgnoreCase("login")) {
            return loginService.getResponse(userDto.getLogin(),userDto.getPassword());
        }
        return null;
    }*/
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }
}
