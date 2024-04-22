package com.uex.contats.service;

import com.uex.contats.domain.PasswordResetToken;
import com.uex.contats.domain.Users;
import com.uex.contats.dto.ApiResponseDto;
import com.uex.contats.dto.UsersDto;
import com.uex.contats.repository.RecoveryPasswordRepository;
import com.uex.contats.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    UsersRepository repository;
    @Autowired
    private RecoveryPasswordRepository recoveryPasswordRepository;

    public ApiResponseDto addUsers(UsersDto user){
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        if(repository.findByEmail(user.getEmail()) == null){
            Users users = new Users();
            users.setEmail(user.email);
            users.setName(user.name);
            users.setPassword(user.password);

            users = repository.save(users);
            if (users.getId().equals(null)){
                apiResponseDto.setError(true);
                apiResponseDto.setMessage("Não foi possivel criar o usuário!");
            } else {
                apiResponseDto.setError(false);
                apiResponseDto.setMessage("Usuário criado com sucesso!");
            }
        } else {
            apiResponseDto.setError(true);
            apiResponseDto.setMessage("Não foi possível cadastrar, email já cadastrado!");
        }
        return apiResponseDto;
    }

    public List<Users> getUsers() {
        return repository.findAll();
    }

    public Users getUsersByEmail(String email) {
        return repository.findByEmail(email);
    }

    public ApiResponseDto alterPassword(String email, String oldPass, String newPass) {
        Users user = repository.findByEmail(email);
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        if(user == null){
            apiResponseDto.setError(true);
            apiResponseDto.setMessage("Usuário Não localizado!");
        } else {
            if(user.getPassword().equals(oldPass)){
                user.setPassword(newPass);
                repository.save(user);
                apiResponseDto.setError(false);
                apiResponseDto.setMessage("Senha Alterada com sucesso!");
            } else {
                apiResponseDto.setError(true);
                apiResponseDto.setMessage("Senha anterior incorreta!");
            }
        }
        return apiResponseDto;
    }

    public ApiResponseDto deleteUser(String email, String password) {
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        Users user = repository.findByEmail(email);
        if(password.equals(user.getPassword())){
            repository.delete(user);
            apiResponseDto.setError(false);
            apiResponseDto.setMessage("Usuário excluido com sucesso!");
        } else {
            apiResponseDto.setError(true);
            apiResponseDto.setMessage("Não foi possivel excluir, senha inválida!");
        }
        return apiResponseDto;
    }

    public ApiResponseDto recoveryPassword(String email) {
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        Users user = repository.findByEmail(email);
        if(user != null){
            String token = UUID.randomUUID().toString();
            PasswordResetToken passwordResetToken = new PasswordResetToken();
            passwordResetToken.setToken(token);
            passwordResetToken.setUsers(getUsersByEmail(email));
            recoveryPasswordRepository.save(passwordResetToken);
            apiResponseDto.setError(false);
            apiResponseDto.setMessage("Enviado o token de alteração de senha");
        } else {
            apiResponseDto.setError(true);
            apiResponseDto.setMessage("E-mail não cadastrado!");
        }
        return apiResponseDto;
    }
}
