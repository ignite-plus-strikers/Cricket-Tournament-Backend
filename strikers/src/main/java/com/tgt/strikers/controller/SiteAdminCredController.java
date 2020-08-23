package com.tgt.strikers.controller;

import com.tgt.strikers.model.SiteAdminCred;
import com.tgt.strikers.service.SiteAdminCredService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "Site Admin Credentials")
public class SiteAdminCredController {

    @Autowired
    private SiteAdminCredService siteAdminCredService;

    @ApiOperation(value = "Create New Site Admin")
    @PostMapping("/site-admin-cred")
    public String createUserCred(@RequestBody SiteAdminCred user) {
        return siteAdminCredService.createUserCred(user);
    }

    @ApiOperation(value = "Get All Site Admins")
    @GetMapping("/site-admin-creds")
    public List<SiteAdminCred> getAllUserCred() {
        return siteAdminCredService.getAllUserCred();
    }
}