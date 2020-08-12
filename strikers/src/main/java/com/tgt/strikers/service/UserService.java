package com.tgt.strikers.service;


import com.tgt.strikers.model.UserDetail;
import com.tgt.strikers.model.UserRoleByEmailId;
import com.tgt.strikers.repository.UserDetailRepository;
import com.tgt.strikers.repository.UserRoleByEmailIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserRoleByEmailIdRepository userRoleByIdRepository;

    public String loginUser(UserDetail userDetail){
        userDetailRepository.save(userDetail);
        return userDetail.getUserName()+" added";
    }


    public String fetchRole(String userEmail){
        Optional<UserRoleByEmailId> optionalUserRoleById = userRoleByIdRepository.findById(userEmail);
        if(!optionalUserRoleById.isPresent())
            return "No role";
        UserRoleByEmailId temp = optionalUserRoleById.get();
        System.out.println(temp.getUserRole());
        return temp.getUserRole();

    }
}
