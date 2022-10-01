package com.duonglh2.demo.springbasicauth.service;

import com.duonglh2.demo.springbasicauth.entity.User;
import com.duonglh2.demo.springbasicauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return new MyUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                Collections.singletonList(MyUserDetails.Role.valueOf(user.getRole()))
        );
    }
}
