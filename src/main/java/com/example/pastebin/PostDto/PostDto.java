package com.example.pastebin.PostDto;

import java.sql.Timestamp;
import java.util.UUID;

public class PostDto {

    private UUID url_id;

    private String body;


    private short minutes;

    private java.sql.Timestamp time_create;

    public PostDto() {
    }

    public UUID getUrl_id() {
        return url_id;
    }

    public void setUrl_id(UUID url_id) {
        this.url_id = url_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public short getMinutes() {
        return minutes;
    }

    public void setMinutes(short minutes) {
        this.minutes = minutes;
    }
    

    public Timestamp getTime_create() {
        return time_create;
    }

    public void setTime_create(Timestamp time_create) {
        this.time_create = time_create;
    }
}
