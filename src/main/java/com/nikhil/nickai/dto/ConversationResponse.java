package com.nikhil.nickai.dto;

import java.time.LocalDateTime;

public class ConversationResponse {

    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private boolean active;

    public ConversationResponse() {
    }

    public ConversationResponse(Long id,
                                String title,
                                LocalDateTime createdAt,
                                boolean active) {

        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}