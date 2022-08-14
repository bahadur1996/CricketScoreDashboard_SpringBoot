package com.backendcode.assignment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class Role {
    private Long id;
    private String role;
}
