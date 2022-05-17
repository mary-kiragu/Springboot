package com.library.libraryServer.resource.vms;

    import lombok.Data;
import javax.validation.constraints.Email;

    @Data
    public class RegisterUserVM {
        private String name;

        @Email
        private String email;
        private String password;
    }


