package com.nickzim.vkapi;


import com.nickzim.Configuration;
import com.nickzim.domain.Message;
import com.nickzim.domain.attachments.Attachment;
import com.nickzim.domain.responce.Response;
import com.nickzim.utils.Messages;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ServerApiImpl{

    private final String token = Configuration.getToken();
    private final Double version = Configuration.getApiVersion();
    private final ServerApi serverApi = ServerApiInstance.getInstance().getServerApi();

    public void sendMessage(Message message){

        Call<Response> request = null;
        StringBuilder responseMsg = new StringBuilder("Your message: \n").append(message.getText().replaceFirst("\\[(.*?)\\]",""));

        Integer random_id = ThreadLocalRandom.current().nextInt();
        Integer peer_id = message.getFrom_id();
        Integer chat_id = message.getPeer_id() - 2000000000;

        switch (Messages.getMessageType(message)) {

            case SIMPLE: {
                if (Messages.isPrivate(message)) {
                    request = serverApi.sendMessage(random_id, peer_id, responseMsg.toString(), token, version);
                } else {
                    request = serverApi.sendMessageToChat(random_id, chat_id ,responseMsg.toString(),token,version);
                }

                break;
            }

            case FORWARDED: {
                StringBuilder fwd_messages = new StringBuilder();

                for (Message it : message.getFwd_messages()) {
                    fwd_messages.append(it.getId()).append(",");
                }


                request = serverApi.sendMessage(random_id, peer_id, responseMsg.toString(), fwd_messages.toString(), token, version);
                break;
            }

            case MEDIA: {
                StringBuilder attachments = new StringBuilder();
                for (Attachment it : message.getAttachments()) {
                    switch (it.getType()) {

                        case "photo": {
                            attachments.append(it.getType()).append(it.getPhoto().getOwner_id()).append("_").
                                    append(it.getPhoto().getId()).append("_").
                                    append(it.getPhoto().getAccess_key()).append(",");
                            break;
                        }

                        case "video": {
                            attachments.append(it.getType()).append(it.getVideo().getOwner_id()).append("_").
                                    append(it.getVideo().getId()).append("_").
                                    append(it.getVideo().getAccess_key()).append(",");
                            break;
                        }

                        case "audio": {
                            attachments.append(it.getType()).append(it.getAudio().getOwner_id()).append("_").
                                    append(it.getAudio().getId()).append("_").
                                    append(it.getAudio().getAccess_key()).append(",");
                            break;
                        }

                        case "doc": {
                            attachments.append(it.getType()).append(it.getDoc().getOwner_id()).append("_").
                                    append(it.getDoc().getId()).append("_").
                                    append(it.getDoc().getAccess_key()).append(",");
                            break;
                        }
                    }
                }

                if (Messages.isPrivate(message)) {
                    request = serverApi.sendMediaMessage(random_id, peer_id, responseMsg.toString(), attachments.toString(), token, version);
                } else {
                    request = serverApi.sendMediaMessageToChat(random_id,chat_id,responseMsg.toString(),attachments.toString(),token, version);
                }
                break;
            }

            case LINK: {

                responseMsg.append(message.getAttachments()[0].getLink().getUrl());
                if (Messages.isPrivate(message)) {
                    request = serverApi.sendMessage(random_id, peer_id, responseMsg.toString(), token, version);
                } else {
                    request = serverApi.sendMessageToChat(random_id, chat_id,responseMsg.toString(),token,version);
                }
                break;

            }

            case STICKER: {

                Integer sticker_id = message.getAttachments()[0].getSticker().getSticker_id();
                if (Messages.isPrivate(message)) {
                    request = serverApi.sendMessage(random_id, peer_id, sticker_id, token, version);
                } else {
                    request = serverApi.sendMessageToChat(random_id, chat_id, sticker_id, token, version);
                }
                break;

             }

        }

        try {

            request.execute();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
