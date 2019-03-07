package com.example.spring.messenger.demo.dao;

import com.example.spring.messenger.demo.repository.MessageRepository;
import com.example.spring.messenger.demo.entity.MessageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void addMessage(MessageEntity messageEntity) {
        messageRepository.save(messageEntity);
    }

    @Override
    public void deleteAllMessages() {
        messageRepository.deleteAll();
    }

    @Override
    public List<MessageEntity> getMessages() {
        List<MessageEntity> messageList = messageRepository.findAll();
        return messageList;
    }
}
