package com.tgt.strikers.service;


import com.tgt.strikers.model.UserCred;
import com.tgt.strikers.repository.UserCredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class UserCredService {

    @Autowired
    private UserCredRepository userCredRepo;


    public String createUserCred(UserCred user) {
        userCredRepo.save(user);
        return "User " + user.getUserFirstname() + " has been added";
    }

    public List<UserCred> getAllUserCred(){
        return userCredRepo.findAll();
    }
}