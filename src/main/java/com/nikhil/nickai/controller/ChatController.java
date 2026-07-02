package com.nikhil.nickai.controller;

import org.springframework.web.bind.annotation.*;

import com.nikhil.nickai.dto.ChatRequest;
import com.nikhil.nickai.dto.ChatResponse;
import com.nikhil.nickai.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String answer = service.chat(request.getMessage());

        return new ChatResponse(answer);

    }
}