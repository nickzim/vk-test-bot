package com.nickzim.VkApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerApiInstance {

    private ServerApi serverApi;
    private static ServerApiInstance instance;

    private ServerApiInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        serverApi = retrofit.create(ServerApi.class);
    }

    static public ServerApiInstance getInstance(){
        if (instance == null){
            instance = new ServerApiInstance();
        }
        return instance;
    }

    public ServerApi getServerApi(){
        return serverApi;
    }
}
