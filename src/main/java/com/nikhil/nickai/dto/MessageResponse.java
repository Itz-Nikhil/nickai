package com.nikhil.nickai.dto;

import java.time.LocalDateTime;

import com.nikhil.nickai.entity.SenderType;

public class MessageResponse {

    private Long id;
    private String content;
    private SenderType sender;
    private LocalDateTime createdAt;

    public MessageResponse() {
    }

    public MessageResponse(Long id,
                           String content,
                           SenderType sender,
                           LocalDateTime createdAt) {

        this.id = id;
        this.content = content;
        this.sender = sender;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SenderType getSender() {
        return sender;
    }

    public void setSender(SenderType sender) {
        this.sender = sender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}