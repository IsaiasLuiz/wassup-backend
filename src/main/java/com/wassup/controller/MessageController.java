package com.wassup.controller;

import com.wassup.domain.model.Message;
import com.wassup.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/messages")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public void save(Message message) {
        messageService.insert(message);
    }

    @GetMapping
    public List<Message> findAll(final String sender, final String receiver) {
        return messageService.findAllMessagesBySenderAndReceiver(sender, receiver);
    }

}
