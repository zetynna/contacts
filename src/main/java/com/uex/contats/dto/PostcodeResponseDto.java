package com.uex.contats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostcodeResponseDto {
    @JsonProperty("cep")
    public String cep;
    @JsonProperty("logradouro")
    public String logradouro;
    @JsonProperty("complemento")
    public String complemento;
    @JsonProperty("bairro")
    public String bairro;
    @JsonProperty("localidade")
    public String localidade;
    @JsonProperty("uf")
    public String uf;
    @JsonProperty("ibge")
    public String ibge;
    @JsonProperty("gia")
    public String gia;
    @JsonProperty("ddd")
    public String ddd;
    @JsonProperty("siafi")
    public String siafi;
}
