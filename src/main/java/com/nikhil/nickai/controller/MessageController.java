package com.nikhil.nickai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.nickai.dto.MessageResponse;
import com.nikhil.nickai.service.MessageService;

@RestController
public class MessageController
{
    private final MessageService service;

    public MessageController(MessageService service)
    {
        this.service = service;
    }

    @GetMapping("/messages/{conversationId}")
    public List<MessageResponse> getMessages(@PathVariable Long conversationId)
    {
    	return service.getConversationMessageResponses(conversationId);
    }
}