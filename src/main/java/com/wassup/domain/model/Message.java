package com.wassup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "message")
public class Message {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content", length = 20000)
    private String content;

    @Column(name = "send_date", nullable = false)
    private LocalDate sendDate;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "receiver", nullable = false)
    private String receiver;

}
