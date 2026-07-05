package com.sachin.ecommerce.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ServerTest {
    @GetMapping("/")
    public ResponseEntity<String> healthCheck (){
        return new ResponseEntity<>("Shopmind is live....", HttpStatusCode.valueOf(200));
    }
}
