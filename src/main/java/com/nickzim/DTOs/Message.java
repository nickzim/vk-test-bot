package com.nickzim.DTOs;

import com.nickzim.DTOs.Attachments.Attachment;
import lombok.Data;

@Data
public class Message {

    private Integer id;

    private Integer date;

    private Integer peer_id;

    private Integer from_id;

    private String text;

    private Integer random_id;

    private String ref;

    private String ref_source;

    private Attachment[] attachments;

    private Boolean important;

    private Message[] fwd_messages;

    private Integer conversation_message_id;

}
