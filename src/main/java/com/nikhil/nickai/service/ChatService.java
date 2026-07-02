package com.nikhil.nickai.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final GroqService groqService;

    public ChatService(GroqService groqService) {
        this.groqService = groqService;
    }

    public String chat(String prompt) {

        return groqService.askAI(prompt);

    }
}