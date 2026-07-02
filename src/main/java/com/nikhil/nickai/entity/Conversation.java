package com.nikhil.nickai.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="conversations")
public class Conversation
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

	private LocalDateTime createdAt;
    
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Conversation() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}