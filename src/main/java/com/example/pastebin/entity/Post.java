package com.example.pastebin.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID url;

    @CreationTimestamp
    private Timestamp time_create;

    // DON`T forget to set default value (60 minutes maybe?)
    private short minutes;

    public Post() {

    }

    public Post(UUID url_id, short minutes) {
        this.url = url_id;
        this.minutes = minutes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUrl() {
        return url;
    }

    public void setUrl(UUID url) {
        this.url = url;
    }

    public Timestamp getTime_create() {
        return time_create;
    }

    public void setTime_create(Timestamp time_create) {
        this.time_create = time_create;
    }

    public short getMinutes() {
        return minutes;
    }

    public void setMinutes(short minutes) {
        this.minutes = minutes;
    }
}
