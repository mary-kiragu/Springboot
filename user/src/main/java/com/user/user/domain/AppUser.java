package com.user.user.domain;

import lombok.*;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@NoArgsConstructor//empty constructor
@AllArgsConstructor
@Table(name="tbl_user")
public class  AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch=EAGER)// whenever a user is initiated the roles are also initiated
    private Collection <Role> roles=new ArrayList<>();
}
