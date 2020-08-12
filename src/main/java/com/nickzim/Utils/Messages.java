package com.nickzim.Utils;

import com.nickzim.DTOs.Message;

public class Messages {

    public static MessageType getMessageType(Message message){

        boolean hasAttachment = message.getAttachments().length > 0;
        boolean hasForwardedMessage = message.getFwd_messages().length > 0;

        if (!hasAttachment && !hasForwardedMessage){
            return MessageType.SIMPLE;
        }

        if (hasForwardedMessage){
            return MessageType.FORWARDED;
        }

        if (hasAttachment){
            return MessageType.STICKER;
        }

        return MessageType.SIMPLE;
    }

    public static DestinationType getDestinationType(Message message){

        if (message.getPeer_id() - 2000000000 > 0){
            return DestinationType.CHAT;
        } else {
            return DestinationType.PRIVATE;
        }
    }
}
