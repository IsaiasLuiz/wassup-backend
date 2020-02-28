package com.wassup.service;

import com.wassup.domain.model.Message;
import com.wassup.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(final MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void insert(final Message message) {
        messageRepository.save(message);
    }

    public List<Message> findAllMessagesBySenderAndReceiver(final String sender, final String receiver) {
        return messageRepository.findMessages(sender, receiver);
    }
}
