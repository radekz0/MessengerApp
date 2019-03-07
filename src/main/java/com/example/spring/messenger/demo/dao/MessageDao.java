package com.example.spring.messenger.demo.dao;

import com.example.spring.messenger.demo.entity.MessageEntity;

import java.util.List;

public interface MessageDao {
    void addMessage(MessageEntity messageEntity);
    void deleteAllMessages();
    List<MessageEntity> getMessages();
}
