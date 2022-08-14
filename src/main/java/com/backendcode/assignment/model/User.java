package com.backendcode.assignment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class User {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private Boolean active;
    private Set<Role> roles;
}
