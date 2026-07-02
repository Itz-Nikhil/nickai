package com.nikhil.nickai.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nikhil.nickai.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long>{

    List<Message> findByConversationId(Long conversationId);

}