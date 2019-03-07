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
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void addMessage(MessageEntity messageEntity) {
//        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
//        session.saveOrUpdate(messageEntity);
        messageRepository.save(messageEntity);
    }

    @Override
    public void deleteAllMessages() {
//        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
//        String query = "DELETE FROM MessageEntity";
//        session.createQuery(query,MessageEntity.class).executeUpdate();
    }

    @Override
    public List<MessageEntity> getMessages() {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        String query = "SELECT a FROM MessageEntity a ORDER BY a.id";
        List<MessageEntity> messages = session.createQuery(query, MessageEntity.class).getResultList();
        return messages;
    }
}
