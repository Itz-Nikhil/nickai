package com.nikhil.nickai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.nickai.entity.Message;
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
    public List<Message> getMessages(@PathVariable Long conversationId)
    {
        return service.getConversationMessages(conversationId);
    }

}