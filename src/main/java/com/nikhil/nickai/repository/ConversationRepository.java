package com.nikhil.nickai.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nikhil.nickai.entity.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation,Long>
{
    List<Conversation> findByUserId(Long userId);
}