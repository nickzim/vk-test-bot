package com.nickzim.Utils;

import com.nickzim.DTOs.Message;

public class Messages {

    public static MessageType getMessageType(Message message){

        boolean hasForwardedMessage = message.getFwd_messages().length > 0;
        boolean hasAttachment = message.getAttachments().length > 0;

        if (!hasAttachment && !hasForwardedMessage){
            return MessageType.SIMPLE;
        }

        if (hasForwardedMessage){
            return MessageType.FORWARDED;
        }

        if ("sticker".equals(message.getAttachments()[0].getType())){
            return MessageType.STICKER;
        } else if ("link".equals(message.getAttachments()[0].getType())){
            return MessageType.LINK;
        } else {
            return MessageType.MEDIA;
        }

    }

    public static boolean isPrivate(Message message){

        if (message.getPeer_id() - 2000000000 <= 0){
            return true;
        } else {
            return false;
        }
    }
}
