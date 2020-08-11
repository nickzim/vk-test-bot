package com.nickzim.VkApi;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nickzim.DTOs.Message;
import com.nickzim.DTOs.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class ServerApiImpl{

    private final String token = "";
    private final Double version = 5.46;

    public void sendMessage(Message message){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ServerApi serverApi = retrofit.create(ServerApi.class);

        String responseMsg = "Вы сказали: " + message.getBody();

        Call<com.nickzim.DTOs.Response> request = serverApi.sendMessage(message.getUser_id(), ThreadLocalRandom.current().nextLong(),
                              message.getUser_id(), responseMsg,token,version);

        try {
            request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
