package com.wassup.controller;

import com.wassup.domain.model.Message;
import com.wassup.domain.request.SearchMessage;
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
    public List<Message> findAll(@RequestBody final SearchMessage searchMessage) {
        return messageService.findAllMessagesBySenderAndReceiver(searchMessage.getSender(), searchMessage.getReceiver());
    }

}
