package com.nikhil.nickai.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nikhil.nickai.dto.MessageResponse;
import com.nikhil.nickai.entity.Conversation;
import com.nikhil.nickai.entity.Message;
import com.nikhil.nickai.entity.SenderType;
import com.nikhil.nickai.repository.MessageRepository;

@Service
public class MessageService
{
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository)
    {
        this.messageRepository = messageRepository;
    }

    public Message saveUserMessage(Conversation conversation, String content)
    {
        Message message = new Message();
        message.setConversation(conversation);
        message.setContent(content);
        message.setSender(SenderType.USER);
        message.setCreatedAt(LocalDateTime.now());

        return messageRepository.save(message);
    }

    public Message saveAssistantMessage(Conversation conversation, String content)
    {
        Message message = new Message();
        message.setConversation(conversation);
        message.setContent(content);
        message.setSender(SenderType.ASSISTANT);
        message.setCreatedAt(LocalDateTime.now());

        return messageRepository.save(message);
    }

    
    public List<Message> getConversationMessages(Long conversationId)
    {
        return messageRepository.findByConversationIdOrderByCreatedAtAsc(conversationId);
    }
    
    
    public List<MessageResponse> getConversationMessageResponses(Long conversationId)
    {
        return messageRepository
                .findByConversationIdOrderByCreatedAtAsc(conversationId)
                .stream()
                .map(message -> new MessageResponse(
                        message.getId(),
                        message.getContent(),
                        message.getSender(),
                        message.getCreatedAt()
                ))
                .toList();
    }
}