package com.nickzim.DTOs;

public class Message {

    private Long id;

    private Long date;

    private Long out;

    private Long user_id;

    private Long read_state;

    private String title;

    private String body;

    private Long[] owner_ids;

    public Message(Long id, Long date, Long out, Long user_id, Long read_state, String title, String body, Long[] owner_ids) {
        this.id = id;
        this.date = date;
        this.out = out;
        this.user_id = user_id;
        this.read_state = read_state;
        this.title = title;
        this.body = body;
        this.owner_ids = owner_ids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getOut() {
        return out;
    }

    public void setOut(Long out) {
        this.out = out;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRead_state() {
        return read_state;
    }

    public void setRead_state(Long read_state) {
        this.read_state = read_state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long[] getOwner_ids() {
        return owner_ids;
    }

    public void setOwner_ids(Long[] owner_ids) {
        this.owner_ids = owner_ids;
    }
}
