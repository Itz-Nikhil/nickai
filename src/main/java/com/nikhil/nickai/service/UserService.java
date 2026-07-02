package com.nikhil.nickai.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.nikhil.nickai.dto.LoginRequest;
import com.nikhil.nickai.dto.LoginResponse;
import com.nikhil.nickai.security.JwtService;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.nikhil.nickai.dto.RegisterRequest;
import com.nikhil.nickai.entity.User;
import com.nikhil.nickai.repository.UserRepository;

@Service
public class UserService
{
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository,PasswordEncoder encoder,AuthenticationManager authenticationManager, JwtService jwtService)
    {
		this.repository = repository;
		this.encoder = encoder;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

    public String register(RegisterRequest request)
    {
        Optional<User> user = repository.findByEmail(request.getEmail());

        if(user.isPresent())
            return "Email already exists";

        User u = new User();

        u.setName(request.getName());
        u.setEmail(request.getEmail());
        u.setPassword(encoder.encode(request.getPassword()));

        repository.save(u);

        return "User Registered Successfully";
    }
    
    public LoginResponse login(LoginRequest request)
    {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        String token = jwtService.generateToken(request.getEmail());

        return new LoginResponse(token);
    }

}