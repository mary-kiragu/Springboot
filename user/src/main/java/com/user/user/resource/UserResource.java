package com.user.user.resource;

import com.user.user.domain.*;
import com.user.user.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    private final AppUserService appUserService;
    @PostMapping(path="/users/create")
    ResponseEntity<AppUser> createAppUser(@RequestBody AppUser appUser){
       AppUser newAppUser= appUserService.createUser(appUser);
        return new ResponseEntity<>(newAppUser,HttpStatus.CREATED);
    }
    @PostMapping(path="/roles/create")
    ResponseEntity<Role> createAppUser(@RequestBody Role  role){
        Role newRole= appUserService.createRole(role);
        return new ResponseEntity<>(newRole,HttpStatus.CREATED);
    }

    @PostMapping(path="/users")
    ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roletoUser){
        appUserService.addRoleToUser(roletoUser.getRoleName(),roletoUser.getUsername());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/users")
    ResponseEntity<List<AppUser>> getAllUsers(){
        List<AppUser> allUsers=appUserService.findAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
}
