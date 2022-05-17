package com.user.user.service;

import com.user.user.domain.*;
import com.user.user.repoitory.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Slf4j//used for logs
@RequiredArgsConstructor//creates a constructor initializing repositories used for dependency injection
public class AppUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

//    public AppUserService(UserRepository userRepository, RoleRepository roleRepository) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//    }
public AppUser createUser(AppUser appUser){
    log.info("Saving appUsers");
    AppUser newAppUser=userRepository.save(appUser);
    log.info("Role {} created roles",newAppUser);
    return newAppUser;
}
    public Role createRole(Role role){
        log.info("Saving roles");
        Role newRole=roleRepository.save(role);
        log.info("Role {} created roles",newRole);
        return newRole;
    }
    public void addRoleToUser( String username,String roleName){
        log.info("Adding role {} to user{}",username,roleName);
        AppUser appUser=userRepository.findUserByUsername(username);
        Role role=roleRepository.findRoleByName(roleName);
        appUser.getRoles().add(role);
        log.info("User assigned a new role");
    }

    public AppUser getUserByUsername(String username){
    AppUser foundUser=userRepository.findUserByUsername(username);
        log.info("Found user: ",foundUser);
    return foundUser;
    }
    public List<AppUser> findAllUsers(){

        log.info("Find all user appUsers");
        List<AppUser> allUsers=userRepository.findAll();

    return  allUsers;
    }


}
