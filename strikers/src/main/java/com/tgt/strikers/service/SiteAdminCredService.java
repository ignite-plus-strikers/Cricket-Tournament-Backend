package com.tgt.strikers.service;


import com.tgt.strikers.model.SiteAdminCred;
import com.tgt.strikers.repository.SiteAdminCredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class SiteAdminCredService {

    @Autowired
    private SiteAdminCredRepository siteAdminCredRepo;


    public String createUserCred(SiteAdminCred user) {
        siteAdminCredRepo.save(user);
        return "Site Admin " + user.getSiteAdminFirstname() + " has been added";
    }

    public List<SiteAdminCred> getAllUserCred(){
        return siteAdminCredRepo.findAll();
    }
}