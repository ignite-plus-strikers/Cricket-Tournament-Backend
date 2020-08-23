package com.tgt.strikers.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import com.tgt.strikers.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tgt.strikers.constants.CricketApplicationConstants.AUTHORIZATION_HEADER;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Authentication")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/auth")
    public ResponseEntity authControllerMethod(@RequestHeader HttpHeaders headers) {
        try {
            List<String> header = headers.getValuesAsList(AUTHORIZATION_HEADER);
            return authService.authService(header.get(0).split(" ")[1]);
        } catch (Exception e) {
           System.out.println("Exception occured");
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

