package com.nickzim.VkApi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nickzim.DTOs.Message;
import com.nickzim.DTOs.Response;
import com.nickzim.Utils.Messages;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ServerApiImpl{

    private final String token = "ec2561c5e8a5814e0fa0d962fa12e5a29a6282058eb8782e4bf990d02f34828802f7b5a6606465ecc5966";
    private final Double version = 5.122;

    public void sendMessage(Message message){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ServerApi serverApi = retrofit.create(ServerApi.class);

        Call<Response> request = null;
        StringBuilder responseMsg = new StringBuilder("Ваше сообщение: \n");

        Integer random_id = ThreadLocalRandom.current().nextInt();
        Integer peer_id = message.getFrom_id();

        switch (Messages.getDestinationType(message)) {

            case PRIVATE: {

                switch (Messages.getMessageType(message)) {

                    case SIMPLE: {
                        responseMsg.append(message.getText());
                        request = serverApi.sendMessage(random_id, peer_id, responseMsg.toString(), token, version);

                        break;
                    }

                    case FORWARDED: {
                        StringBuilder fwd_messages = new StringBuilder();
                        for (Message it : message.getFwd_messages()) {
                            fwd_messages.append(it.getId()).append(",");
                        }


                        request = serverApi.sendMessage(random_id, peer_id, responseMsg.toString(),
                                fwd_messages.toString(), token, version);
                        break;
                    }

                    case STICKER: {
                        request = serverApi.sendMessage(random_id, peer_id,
                                message.getAttachments()[0].getSticker().getSticker_id(), token, version);
                        break;
                    }

                    default: {
                        break;
                    }

                }

                break;
            }

            case CHAT: {

                Integer chat_id = message.getPeer_id() - 2000000000;

                switch (Messages.getMessageType(message)){

                    case SIMPLE: {
                        responseMsg.append(message.getText().replaceFirst("\\[(.*?)\\]",""));
                        request = serverApi.sendMessageToChat(random_id, chat_id, responseMsg.toString(), token, version);
                        break;
                    }

                    case FORWARDED: {
                        StringBuilder fwd_messages = new StringBuilder();
                        for (Message it: message.getFwd_messages()){
                            fwd_messages.append(it.getId() + ",");
                        }
                        request = serverApi.sendMessageToChat(random_id, chat_id, responseMsg.toString(), fwd_messages.toString(), token, version);
                        break;
                    }

                    case STICKER: {
                        request = serverApi.sendMessageToChat(random_id, chat_id,
                                message.getAttachments()[0].getSticker().getSticker_id(), token, version);
                        break;
                    }

                    default: {
                        break;
                    }
                }
            }
        }


        try {
            request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
