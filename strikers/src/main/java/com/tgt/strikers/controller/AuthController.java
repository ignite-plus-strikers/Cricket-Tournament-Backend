package com.tgt.strikers.controller;

import org.springframework.http.HttpHeaders;
import com.tgt.strikers.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tgt.strikers.constants.CricketApplicationConstants.AUTHORIZATION_HEADER;

@RestController
@RequestMapping("/cricket-tournament")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/auth")
    public ResponseEntity authControllerMethod(@RequestHeader HttpHeaders headers) {
        try {
            List<String> header = headers.getValuesAsList(AUTHORIZATION_HEADER);
            return authService.authService(header.get(0).split(" ")[1]);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

