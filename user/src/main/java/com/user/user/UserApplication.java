package com.user.user;

import com.user.user.domain.*;
import com.user.user.domain.Role;
import com.user.user.service.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	@Bean
	CommandLineRunner run(AppUserService appUserService){
		return args->{
			appUserService.createRole(new Role(null,"ROLE_USER"));
			appUserService.createRole(new Role(null,"ROLE_ADMIN"));
			appUserService.createRole(new Role(null,"ROLE_MANAGER"));
			appUserService.createRole(new Role(null,"ROLE_SUPER_ADMIN"));

			appUserService.createUser(new AppUser(null,"Mary","mary","1234",new ArrayList<>()));
			appUserService.createUser(new AppUser(null,"Mercy","mercy","1234",new ArrayList<>()));
			appUserService.createUser(new AppUser(null,"Nana","nana","1234",new ArrayList<>()));
			appUserService.createUser(new AppUser(null,"shiks","shiks","1234",new ArrayList<>()));

			appUserService.addRoleToUser("mary","ROLE_USER");
			appUserService.addRoleToUser("mercy","ROLE_USER");
			appUserService.addRoleToUser("mercy","ROLE_ADMIN");
			appUserService.addRoleToUser("nana","ROLE_MANAGER");
			appUserService.addRoleToUser("shiks","ROLE_SUPER_ADMIN");



		};
	}

}
