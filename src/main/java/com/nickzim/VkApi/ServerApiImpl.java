package com.nickzim.VkApi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nickzim.DTOs.Message;
import com.nickzim.DTOs.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ServerApiImpl{

    private final String token = "";
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

        StringBuilder responseMsg = new StringBuilder();

        if (message.getFwd_messages().length > 0){
            responseMsg.append("Пересланные сообщения: \n");
            for (Message it :message.getFwd_messages()){
                responseMsg.append(it.getText() + "\n");
            }

            request = serverApi.sendMessage(message.getPeer_id(), ThreadLocalRandom.current().nextInt(),
                    message.getFrom_id(), responseMsg.toString(),token,version);
        }

        if (!message.getText().isEmpty()){
            responseMsg.append("Сообщение: ");
            responseMsg.append(message.getText());

            request = serverApi.sendMessage(message.getFrom_id(), ThreadLocalRandom.current().nextInt(),
                    message.getFrom_id(), responseMsg.toString(),token,version);
        }


        try {
            request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
