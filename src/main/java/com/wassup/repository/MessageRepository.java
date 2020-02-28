package com.wassup.repository;

import com.wassup.domain.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllBySenderAndReceiverOrderBySendDate(String sender, String receiver);

}
