package com.example.springsecurityex.service;

import com.example.springsecurityex.model.MyUserDetails;
import com.example.springsecurityex.model.Users;
import com.example.springsecurityex.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("Searching for user: " + username);

        Users user = userRepo.findByUsername(username);
        if(user == null)
        {
            System.out.println("User not found :"+username);
            throw new UsernameNotFoundException("user not found");
        }

        System.out.println("user found "+user);
        return new MyUserDetails(user);
    }
}
