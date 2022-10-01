package com.duonglh2.demo.springbasicauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String username;
    private String password;
    private boolean enabled;
    private String role;
}
