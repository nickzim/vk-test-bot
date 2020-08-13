package com.nickzim.DTOs.Attachments;

import lombok.Data;

@Data
public class Attachment {

    private String type;

    private AttachmentObject photo;

    private AttachmentObject video;

    private AttachmentObject audio;

    private AttachmentObject doc;

    private AttachmentObject wall;

    private AttachmentObject sticker;

    private AttachmentObject link;
}
