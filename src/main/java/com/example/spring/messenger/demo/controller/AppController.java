package com.example.spring.messenger.demo.controller;

import com.example.spring.messenger.demo.dao.MessageDaoImpl;
import com.example.spring.messenger.demo.entity.MessageEntity;
import com.example.spring.messenger.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    MessageDaoImpl messageDao;

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/")
    public String homePage(Model model){
        MessageEntity messageEntity = new MessageEntity();
        List<MessageEntity> messages = messageDao.getMessages();
        model.addAttribute("messages",messages);
        model.addAttribute("message", messageEntity);
        return "homePage";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("message") MessageEntity messageEntity){
        messageRepository.save(messageEntity);
        return "redirect:/";
    }

    @PostMapping("/deleteAll")
    public String deleteMessages(){
        messageDao.deleteAllMessages();
        return "redirect:/";
    }
}