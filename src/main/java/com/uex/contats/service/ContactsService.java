package com.uex.contats.service;

import com.uex.contats.domain.Contacts;
import com.uex.contats.domain.Users;
import com.uex.contats.dto.ApiResponseDto;
import com.uex.contats.dto.ContactsDto;
import com.uex.contats.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {
    @Autowired
    private ContactsRepository contactsRepository;

    public ApiResponseDto addContact(ContactsDto contactsDto){
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        if(contactsRepository.findByCpf(contactsDto.getCpf()) == null){
            Contacts contact = new Contacts();
            contact.setName(contactsDto.getName());
            contact.setCpf(contactsDto.getCpf());
            contact.setPhone(contactsDto.getPhone());
            contact.setAddress(contactsDto.getAddress());
            contact.setNumber(contactsDto.getNumber());
            contact.setComplement(contactsDto.getComplement());
            contact.setPostcode(contactsDto.getPostcode());
            contact.setLatitude(contactsDto.getLatitude());
            contact.setLongitude(contactsDto.getLongitude());
            contactsRepository.save(contact);
            if(contact.getId().equals(null)){
                apiResponseDto.setError(true);
                apiResponseDto.setMessage("Não foi possivel cadastrar o contato!");
            } else {
                apiResponseDto.setError(false);
                apiResponseDto.setMessage("Contato salvo com sucesso!");
            }
        } else {
            apiResponseDto.setError(true);
            apiResponseDto.setMessage("Não foi possível cadastrar, contato já existe!");
        }
        return apiResponseDto;
    }

    public ApiResponseDto delContact(Integer cpf){
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        Contacts contact = contactsRepository.findByCpf(cpf);
        if(contact == null){
            apiResponseDto.setError(true);
            apiResponseDto.setMessage("Contato não encontrado!");
        } else {
            contactsRepository.delete(contact);
            apiResponseDto.setError(false);
            apiResponseDto.setMessage("Contato excluído com sucesso");
        }
        return apiResponseDto;
    }

    public Contacts getContactByCpf(Integer cpf) {
        return contactsRepository.findByCpf(cpf);
    }

    public List<Contacts> getContactByName(String name) {
        return contactsRepository.findByName(name);
    }
}
