package com.nikhil.nickai.controller;

import com.nikhil.nickai.dto.LoginRequest;
import com.nikhil.nickai.dto.LoginResponse;
import org.springframework.web.bind.annotation.*;
import com.nikhil.nickai.dto.RegisterRequest;
import com.nikhil.nickai.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController
{
    private final UserService service;

    public AuthController(UserService service)
    {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request)
    {
        return service.login(request);
    }
    
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request)
    {
        return service.register(request);
    }
}