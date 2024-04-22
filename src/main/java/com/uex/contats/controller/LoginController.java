package com.uex.contats.controller;

import com.uex.contats.service.LoginService;
import com.uex.contats.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public String login(String user, String password){
        return loginService.login(user, password);
    }
}
