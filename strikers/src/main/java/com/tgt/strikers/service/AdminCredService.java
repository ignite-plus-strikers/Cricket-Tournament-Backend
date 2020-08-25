package com.tgt.strikers.service;


import com.tgt.strikers.model.AdminCred;
import com.tgt.strikers.repository.AdminCredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class AdminCredService {

    @Autowired
    private AdminCredRepository adminCredRepo;


    public String createAdminCred(AdminCred admin) {
        adminCredRepo.save(admin);
        return "Admin " + admin.getAdminFirstname() + " has been added";
    }

    public List<AdminCred> getAllAdminCred(){
        return adminCredRepo.findAll();
    }
}