package com.example.spring.messenger.demo.controller;

import com.example.spring.messenger.demo.dao.MessageDaoImpl;
import com.example.spring.messenger.demo.entity.MessageEntity;
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

    @GetMapping("/")
    public String homePage(Model model){
        MessageEntity messageEntity = new MessageEntity();
        List<MessageEntity> messages = messageDao.getMessages();
        model.addAttribute("messages",messages);
        model.addAttribute("message", messageEntity);
        return "homePage";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("message") String msg){
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(msg);
        messageDao.addMessage(messageEntity);
        return "redirect:/";
    }

    @GetMapping("/deleteAll")
    public String deleteMessages(){
        messageDao.deleteAllMessages();
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
}