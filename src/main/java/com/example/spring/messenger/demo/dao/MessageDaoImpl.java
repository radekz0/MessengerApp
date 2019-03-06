package com.example.spring.messenger.demo.dao;

import com.example.spring.messenger.demo.entity.MessageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;

@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public void addMessage(MessageEntity messageEntity) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery criteria = builder.createQuery(UserDetails.class);
//        Root contactRoot = criteria.from(UserDetails.class);
//        criteria.select(contactRoot);
        session.saveOrUpdate(messageEntity);
    }
}
