package com.tgt.strikers.service;

import com.tgt.strikers.model.UserRoleByEmailId;
import com.tgt.strikers.repository.UserRoleByEmailIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleByEmailIdService {

    @Autowired
    private UserRoleByEmailIdRepository userRoleByEmailIdRepo;

    public UserRoleByEmailId createUserRole(UserRoleByEmailId userRole)
    {
        return userRoleByEmailIdRepo.save(userRole);

    }

    public List<UserRoleByEmailId> getAllRoles(){
        return userRoleByEmailIdRepo.findAll();
    }
}
