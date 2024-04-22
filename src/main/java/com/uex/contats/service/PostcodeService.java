package com.uex.contats.service;

import com.uex.contats.dto.PostcodeResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Service
public class PostcodeService {
    final private String urlPostcode = "http://viacep.com.br/ws/";
    public PostcodeResponseDto getDataPostecode(Integer postcode) {
        WebClient client = WebClient.builder()
                .baseUrl(urlPostcode)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        var retorno = client.get()
                .uri(postcode + "/json")
                .retrieve()
                .bodyToMono(PostcodeResponseDto.class)
                .block();

        return retorno;

    }
}
