package com.wassup.repository;

import com.wassup.domain.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m from message m where (m.sender = ?1 and m.receiver = ?2) or (m.receiver = ?1 and m.sender = ?2) order by send_date")
    List<Message> findMessages (String sender, String receiver);

}
