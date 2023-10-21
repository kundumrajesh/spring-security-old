package com.rajtech.springsecurityold.service;

import com.rajtech.springsecurityold.model.CustomUserDetails;
import com.rajtech.springsecurityold.model.Users;
import com.rajtech.springsecurityold.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByName(username);

        if (optionalUsers.isPresent()) {
            return new CustomUserDetails(optionalUsers.get());
        } else {
            throw new UsernameNotFoundException("Username not found");
        }

    }
}
