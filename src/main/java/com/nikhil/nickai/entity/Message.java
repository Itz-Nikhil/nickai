package com.nikhil.nickai.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="messages")
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private SenderType sender;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="conversation_id")
    private Conversation conversation;

    public Message()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id=id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content=content;
    }

    public SenderType getSender()
    {
		return sender;
	}

	public void setSender(SenderType sender)
	{
		this.sender = sender;
	}

	public LocalDateTime getCreatedAt()
	{
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt=createdAt;
    }

    public Conversation getConversation()
    {
        return conversation;
    }

    public void setConversation(Conversation conversation)
    {
        this.conversation=conversation;
    }
}