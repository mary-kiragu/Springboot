package com.Employee.employees.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.provisioning.*;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //control o lists all the methods in the WebSecurityConfigurerAdapter
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*")
                .permitAll()
                .antMatchers("/api/*").hasAnyRole(EmployeeRole.EMPLOYEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
//creating a user
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails mary= User.builder()
                .username("mary")
                .password(passwordEncoder.encode("mary"))
                .roles(EmployeeRole.EMPLOYEE.name())
                .build();
        UserDetails admin= User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(EmployeeRole.EMPLOYEE.name(),EmployeeRole.ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(mary,admin);

    }
}
