package com.tgt.strikers.controller;

import com.tgt.strikers.model.AdminCred;
import com.tgt.strikers.service.AdminCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class AdminCredController {

    @Autowired
    private AdminCredService adminCredService;

    @PostMapping("/admin-cred")
    public String createAdminCred(@RequestBody AdminCred admin) {
        return adminCredService.createAdminCred(admin);
    }

    @GetMapping("/admin-creds")
    public List<AdminCred> getAllAdminCred() {
        return adminCredService.getAllAdminCred();
    }
}