package com.uex.contats.controller;

import com.uex.contats.domain.Contacts;
import com.uex.contats.dto.ApiResponseDto;
import com.uex.contats.dto.ContactsDto;
import com.uex.contats.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/contacts")
@Validated
public class ContactsController {
    @Autowired
    private ContactsService contactsService;
    @PostMapping(produces = APPLICATION_JSON_VALUE, value = "/addContacts")
    public ApiResponseDto addContat(ContactsDto dto){
        return contactsService.addContact(dto);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getContactByCPF")
    public Contacts getContatByCpf(Integer cpf){
        return contactsService.getContactByCpf(cpf);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE, value = "/getContactByName")
    public List<Contacts> getContatByName(String name){
        return contactsService.getContactByName(name);
    }

    @DeleteMapping(produces = APPLICATION_JSON_VALUE, value = "/delContact")
    public ApiResponseDto delContact(Integer cpf){
        return contactsService.delContact(cpf);
    }


}
