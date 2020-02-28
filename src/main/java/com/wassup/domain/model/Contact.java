package com.wassup.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "contact")
public class Contact {

    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

}
