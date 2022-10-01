package com.duonglh2.demo.springbasicauth.repository;

import com.duonglh2.demo.springbasicauth.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static List<User> users = Arrays.asList(
            new User("duonglh", new BCryptPasswordEncoder().encode("duonglh2"), true, "USER"),
            new User("admin", new BCryptPasswordEncoder().encode("admin"), true, "ADMIN")
    );

    public Optional<User> findByUsername(String username) {
        return  users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
