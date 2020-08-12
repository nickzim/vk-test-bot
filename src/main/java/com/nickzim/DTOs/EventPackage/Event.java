package com.nickzim.DTOs.EventPackage;

import com.nickzim.DTOs.Message;
import lombok.Data;

@Data
public class Event {

    private String type;

    private Long group_id;

    private EventObject object;

    private String event_id;

}
