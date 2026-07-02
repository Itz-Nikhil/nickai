package com.nikhil.nickai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nikhil.nickai.dto.ChatResponse;
import com.nikhil.nickai.dto.GroqMessage;
import com.nikhil.nickai.entity.Conversation;
import com.nikhil.nickai.entity.Message;
import com.nikhil.nickai.entity.SenderType;
import com.nikhil.nickai.entity.User;
import com.nikhil.nickai.repository.UserRepository;

@Service
public class ChatService {

	private final GroqService groqService;
	private final ConversationService conversationService;
	private final MessageService messageService;
	private final UserRepository userRepository;

	public ChatService(GroqService groqService,
            ConversationService conversationService,
            MessageService messageService,
            UserRepository userRepository) {

							this.groqService = groqService;
							this.conversationService = conversationService;
							this.messageService = messageService;
							this.userRepository = userRepository;
							}

	public ChatResponse chat(Long conversationId, String email, String prompt) {

	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    Conversation conversation;

	    if (conversationId == null) {

	        conversation = conversationService.createConversation(user);

	    } else {

	        conversation = conversationService.getConversation(conversationId);

	    }
	    
	    messageService.saveUserMessage(conversation, prompt);
	    
	    List<Message> messages =
	            messageService.getConversationMessages(conversation.getId());
	    
	    List<GroqMessage> groqMessages = new ArrayList<>();

	    for (Message message : messages) {

	        String role = message.getSender() == SenderType.USER
	                ? "user"
	                : "assistant";

	        groqMessages.add(
	                new GroqMessage(role, message.getContent())
	        );
	    }
	    
	    String answer = groqService.askAI(groqMessages);
	    messageService.saveAssistantMessage(conversation, answer);
	    
	    return new ChatResponse(conversation.getId(),answer);
	}
}