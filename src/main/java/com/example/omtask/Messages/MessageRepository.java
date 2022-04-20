package com.example.omtask.Messages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository
         extends JpaRepository<Message, Long> {
}
