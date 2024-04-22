package com.uex.contats.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactsDto {
    public String name;
    public Integer cpf;
    public String phone;
    public String address;
    public String complement;
    public Integer number;
    public Integer postcode;
    public String latitude;
    public String longitude;
}
