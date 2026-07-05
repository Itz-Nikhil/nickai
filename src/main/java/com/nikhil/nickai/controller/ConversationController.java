package com.nikhil.nickai.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.nickai.dto.ConversationResponse;
import com.nikhil.nickai.entity.User;
import com.nikhil.nickai.repository.UserRepository;
import com.nikhil.nickai.service.ConversationService;

@RestController
public class ConversationController
{
    private final ConversationService conversationService;
    private final UserRepository userRepository;

    public ConversationController(ConversationService conversationService,UserRepository userRepository)
    {
        this.conversationService = conversationService;
        this.userRepository = userRepository;
    }

    @GetMapping("/conversations")
    public List<ConversationResponse> getConversations()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow();

        return conversationService.getUserConversationResponses(user.getId());
    }
    
    @DeleteMapping("/conversations/{id}")
    public void deleteConversation(@PathVariable Long id)
    {
        conversationService.deleteConversation(id);
    }

}