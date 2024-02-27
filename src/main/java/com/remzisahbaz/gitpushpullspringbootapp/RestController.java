package com.remzisahbaz.gitpushpullspringbootapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@RequestMapping("/")
public class RestController {

    private ResponseEntity<String> git(){

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
