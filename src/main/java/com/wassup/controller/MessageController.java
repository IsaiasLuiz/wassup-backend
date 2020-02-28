package com.wassup.controller;

import com.wassup.domain.model.Message;
import com.wassup.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/messages")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public void save(@RequestBody final Message message) {
        messageService.insert(message);
    }

    @GetMapping
    public List<Message> findAll(@RequestBody final String sender, @RequestBody final String receiver) {
        return messageService.findAllMessagesBySenderAndReceiver(sender, receiver);
    }

}
