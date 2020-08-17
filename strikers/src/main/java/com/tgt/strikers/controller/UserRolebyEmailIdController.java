package com.tgt.strikers.controller;

import com.tgt.strikers.model.UserRoleByEmailId;
import com.tgt.strikers.service.UserRoleByEmailIdService;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cricket-tournament")
@CrossOrigin("*")
@Api(tags = "User Roles By Email")
public class UserRolebyEmailIdController {

    @Autowired
    private UserRoleByEmailIdService userRoleByEmailIdService;

    @PostMapping("/user-role")
    public UserRoleByEmailId createUserRole(@Valid @RequestBody UserRoleByEmailId userRole)
    {
         return userRoleByEmailIdService.createUserRole(userRole);
    }

    @GetMapping("user-roles")
    public List<UserRoleByEmailId> getAllRoles(){
        return userRoleByEmailIdService.getAllRoles();
    }


}
