package com.nikhil.nickai.dto;

public class ChatResponse {

    private Long conversationId;
    private String response;

    public ChatResponse() {
    }

    public ChatResponse(Long conversationId, String response) {
        this.conversationId = conversationId;
        this.response = response;
    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}