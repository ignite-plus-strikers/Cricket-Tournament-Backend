package com.tgt.strikers.controller;

import com.tgt.strikers.model.UserCred;
import com.tgt.strikers.service.UserCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class UserCredController {

    @Autowired
    private UserCredService userCredService;

    @PostMapping("/user-cred")
    public String createUserCred(@RequestBody UserCred user) {
        return userCredService.createUserCred(user);
    }

    @GetMapping("/user-creds")
    public List<UserCred> getAllUserCred() {
        return userCredService.getAllUserCred();
    }
}