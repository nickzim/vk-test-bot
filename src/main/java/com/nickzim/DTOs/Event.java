package com.nickzim.DTOs;

public class Event {

    private String type;

    private Long group_id;

    private Message object;

    private String event_id;

    public Event(String type, Long group_id, Message object, String event_id) {
        this.type = type;
        this.group_id = group_id;
        this.object = object;
        this.event_id = event_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public Message getObject() {
        return object;
    }

    public void setObject(Message object) {
        this.object = object;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }
}
