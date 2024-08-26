package com.example.springsecurityex.service;

import com.example.springsecurityex.model.Users;
import com.example.springsecurityex.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;
    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);
    public Users register(Users users)
    {
        users.setPassword(encoder.encode(users.getPassword()));
        userRepo.save(users);
        return users;
    }

    public String verify(Users users) {

        Authentication authentication= authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(users.getUsername());
        }else {
            return "fail";
        }
    }
}
