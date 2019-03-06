package com.example.spring.messenger.demo.controller;

import com.example.spring.messenger.demo.dao.MessageDaoImpl;
import com.example.spring.messenger.demo.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    MessageDaoImpl messageDao;

    @GetMapping("/")
    public String homePage(Model model){
        MessageEntity messageEntity = new MessageEntity();
        model.addAttribute("message", messageEntity);
        return "homePage";
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@ModelAttribute("message") MessageEntity messageEntity){
        messageDao.addMessage(messageEntity);
        return "redirect:/";
    }
}