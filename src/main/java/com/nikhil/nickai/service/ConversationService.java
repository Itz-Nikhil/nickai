package com.nikhil.nickai.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nikhil.nickai.dto.ConversationResponse;
import com.nikhil.nickai.entity.Conversation;
import com.nikhil.nickai.entity.User;
import com.nikhil.nickai.exception.ConversationNotFoundException;
import com.nikhil.nickai.repository.ConversationRepository;

@Service
public class ConversationService
{

    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository)
    {
        this.conversationRepository = conversationRepository;
    }

    public Conversation createConversation(User user)
    {
        Conversation conversation = new Conversation();

        conversation.setUser(user);
        conversation.setTitle("New Chat");
        conversation.setCreatedAt(LocalDateTime.now());
        conversation.setActive(true);

        return conversationRepository.save(conversation);
    }
    
    public void deleteConversation(Long id)
    {
        Conversation conversation = getConversation(id);

        conversation.setActive(false);

        conversationRepository.save(conversation);
    }

    public Conversation getConversation(Long id)
    {
        return conversationRepository.findById(id).orElseThrow(() ->
        				new ConversationNotFoundException("Conversation not found"));
    }

    public List<Conversation> getUserConversations(Long userId)
    {
        return conversationRepository.findByUserIdAndActiveTrueOrderByCreatedAtDesc(userId);
    }
    
    public Conversation saveConversation(Conversation conversation)
    {
        return conversationRepository.save(conversation);
    }
    
    public List<ConversationResponse> getUserConversationResponses(Long userId)
    {
        return conversationRepository
                .findByUserIdAndActiveTrueOrderByCreatedAtDesc(userId)
                .stream()
                .map(conversation -> new ConversationResponse(

                        conversation.getId(),
                        conversation.getTitle(),
                        conversation.getCreatedAt(),
                        conversation.isActive()

                ))
                .collect(Collectors.toList());
    }
}