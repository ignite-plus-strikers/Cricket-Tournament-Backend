package com.tgt.strikers.controller;

import com.tgt.strikers.model.AdminCred;
import com.tgt.strikers.service.AdminCredService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Admin Credentials")
public class AdminCredController {

    @Autowired
    private AdminCredService adminCredService;

    @ApiOperation(value = "Create New Admin")
    @PostMapping("/admin-cred")
    public String createAdminCred(@RequestBody AdminCred admin) {
        return adminCredService.createAdminCred(admin);
    }

    @ApiOperation(value = "Get All Admins")
    @GetMapping("/admin-creds")
    public List<AdminCred> getAllAdminCred() {
        return adminCredService.getAllAdminCred();
    }
}