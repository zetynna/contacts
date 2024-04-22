package com.uex.contats.controller;

import com.uex.contats.dto.PostcodeResponseDto;
import com.uex.contats.service.PostcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postcode")
public class PostcodeController {
    @Autowired
    private PostcodeService postcodeService;
    @PostMapping(value = "/consultPostcode")
    public PostcodeResponseDto consultPostcode(Integer postcode){
        return postcodeService.getDataPostecode(postcode);
    }
}
