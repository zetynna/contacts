package com.uex.contats.service;

import com.uex.contats.domain.Users;
import com.uex.contats.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UsersRepository repository;
    public String login(String user, String password) {
        Users users = repository.findByEmail(user);
        if (password.equals(users.getPassword())){
            return "{" +
                    "   Login realizado!" +
                    "}";
        } else {
            return "{" +
                    "   Login não realizado!" +
                    "}";
        }
    }
}
