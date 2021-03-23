package com.nickzim.domain.events;

import lombok.Data;

@Data
public class Event {

    private String type;

    private Long group_id;

    private EventObject object;

    private String event_id;

}
