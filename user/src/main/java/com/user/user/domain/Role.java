package com.user.user.domain;

import lombok.*;

import javax.persistence.*;
@Entity
@NoArgsConstructor//empty constructor
@AllArgsConstructor
@Table(name="tbl_Role")
public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
}
