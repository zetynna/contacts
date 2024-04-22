package com.uex.contats.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "name")
    public String name;
    @Column(name = "cpf")
    public Integer cpf;
    @Column(name = "phone")
    public String phone;
    @Column(name = "address")
    public String address;
    @Column(name = "complement")
    public String complement;
    @Column(name = "number")
    public Integer number;
    @Column(name = "postcode")
    public Integer postcode;
    @Column(name = "latitude")
    public String latitude;
    @Column(name = "longitude")
    public String longitude;

}
