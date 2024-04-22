package com.uex.contats.controller;

import com.uex.contats.domain.Users;
import com.uex.contats.dto.ApiResponseDto;
import com.uex.contats.dto.UsersDto;
import com.uex.contats.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/Users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getUserByEmail")
    public Users getUsersByEmail(@RequestParam String email){
        return usersService.getUsersByEmail(email);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getAllUsers")
    public List<Users> getUsers(){
        return usersService.getUsers();
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, value = "/addUser")
    public ApiResponseDto addUser(@RequestBody UsersDto user){
        return usersService.addUsers(user);
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE, value = "/alterPassword")
    public ApiResponseDto alterPassword(String email, String oldPass, String newPass){
        return usersService.alterPassword(email, oldPass, newPass);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, value = "/deleteAccount")
    public ApiResponseDto deleteUser(String email, String password){
        return usersService.deleteUser(email, password);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, value = "/recoveryPassword")
    public ApiResponseDto recoveryPassword(String email){
        return usersService.recoveryPassword(email);
    }

}
