package com.nickzim.vkapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerApiInstance {

    private final ServerApi serverApi;

    private static class SingletonHolder {
        public static final ServerApiInstance instance = new ServerApiInstance();
    }

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
        return SingletonHolder.instance;
    }

    public ServerApi getServerApi(){
        return serverApi;
    }
}
