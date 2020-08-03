package com.tgt.strikers.controller;

import com.tgt.strikers.model.UserDetail;
import com.tgt.strikers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public String loginUser(@RequestBody UserDetail userDetail){
        return userService.loginUser(userDetail);
    }

    @GetMapping("/user/{id}")
    public String fetchRole(@PathVariable("id") String userId ){
        return userService.fetchRole(userId);
    }
}
