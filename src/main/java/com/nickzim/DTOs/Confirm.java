package com.nickzim.DTOs;

public class Confirm {

    private String type;

    private Long group_id;

    public Confirm(String type, Long group_id) {
        this.type = type;
        this.group_id = group_id;
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
}
