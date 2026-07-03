package com.nikhil.nickai.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.nickai.dto.ChatRequest;
import com.nikhil.nickai.dto.ChatResponse;
import com.nikhil.nickai.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController
{
    private final ChatService service;

    public ChatController(ChatService service)
    {
        this.service = service;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request)
    {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        return service.chat(request.getConversationId(),email,request.getMessage());
    }
}