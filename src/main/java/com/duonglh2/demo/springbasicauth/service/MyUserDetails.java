package com.duonglh2.demo.springbasicauth.service;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Builder
@Data
public class MyUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean enabled;
    private List<Role> roles;


    @Override
    public List<Role> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    public enum Role implements GrantedAuthority {

        USER("ROLE_USER"),
        ADMIN("ROLE_ADMIN");

        private final String role;

        Role(String role) {
            this.role = role;
        }
        @Override
        public String getAuthority() {
            return this.role;
        }
    }

}

