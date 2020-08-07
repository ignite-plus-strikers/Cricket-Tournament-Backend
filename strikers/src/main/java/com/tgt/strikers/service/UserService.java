package com.tgt.strikers.service;


import com.tgt.strikers.model.UserDetail;
import com.tgt.strikers.model.UserRoleById;
import com.tgt.strikers.repository.UserDetailRepository;
import com.tgt.strikers.repository.UserRoleByIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private UserRoleByIdRepository userRoleByIdRepository;

    public String loginUser(UserDetail userDetail){
        userDetailRepository.save(userDetail);
        return userDetail.getUserName()+" added";
    }


    public String fetchRole(String userId){
        Optional<UserRoleById> optionalUserRoleById = userRoleByIdRepository.findById(userId);
        if(!optionalUserRoleById.isPresent())
            return "No role";
        UserRoleById temp = optionalUserRoleById.get();
        System.out.println(temp.getUserRole());
        return temp.getUserRole();

    }
}
