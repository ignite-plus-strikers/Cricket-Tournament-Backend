package com.tgt.strikers.controller;

import com.tgt.strikers.model.SiteAdminCred;
import com.tgt.strikers.service.SiteAdminCredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
public class SiteAdminCredController {

    @Autowired
    private SiteAdminCredService siteAdminCredService;

    @PostMapping("/site-admin-cred")
    public String createUserCred(@RequestBody SiteAdminCred user) {
        return siteAdminCredService.createUserCred(user);
    }

    @GetMapping("/site-admin-creds")
    public List<SiteAdminCred> getAllUserCred() {
        return siteAdminCredService.getAllUserCred();
    }
}