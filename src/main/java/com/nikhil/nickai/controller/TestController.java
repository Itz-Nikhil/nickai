package com.nikhil.nickai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    @GetMapping("/hello")
    public String hello()
    {
        return "Welcome to NickAI";
    }
}