package com.mgl.chr.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chr/hospital/")
@CrossOrigin
public class AuthController {

    @GetMapping(value = "basicauth")
    public String basicAuthCheck() {
        return "OK";
    }
}
