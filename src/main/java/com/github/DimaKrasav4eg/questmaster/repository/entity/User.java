package com.github.DimaKrasav4eg.questmaster.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "tg_tag")
    private String tgTag;

    @Column(name = "active")
    private boolean active;
}
