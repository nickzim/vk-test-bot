package com.nickzim.domain.attachments;

import lombok.Data;

@Data
public class AttachmentObject {

    private Integer id;

    private Integer owner_id;

    private Integer sticker_id;

    private String url;

    private String access_key;
}
