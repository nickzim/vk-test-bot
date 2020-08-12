package com.nickzim.VkApi;

import com.nickzim.DTOs.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerApi {

    //Private message
    @GET("messages.send")
    Call<Response> sendMessage(@Query("random_id") Integer random_id, @Query("peer_id") Integer peer_id, @Query("message") String message,
                               @Query("access_token") String access_token, @Query("v") Double v);

    @GET("messages.send")
    Call<Response> sendMessage(@Query("random_id") Integer random_id, @Query("peer_id") Integer peer_id, @Query("message") String message,
                               @Query("forward_messages") String forward_messages, @Query("access_token") String access_token, @Query("v") Double v);

    @GET("messages.send")
    Call<Response> sendMessage(@Query("random_id") Integer random_id, @Query("peer_id") Integer peer_id,
                               @Query("sticker_id") Integer sticker_id, @Query("access_token") String access_token, @Query("v") Double v);

    // Chat
    @GET("messages.send")
    Call<Response> sendMessageToChat(@Query("random_id") Integer random_id, @Query("chat_id") Integer chat_id, @Query("message") String message,
                               @Query("access_token") String access_token, @Query("v") Double v);

    @GET("messages.send")
    Call<Response> sendMessageToChat(@Query("random_id") Integer random_id, @Query("chat_id") Integer chat_id, @Query("message") String message,
                               @Query("forward_messages") String forward_messages, @Query("access_token") String access_token, @Query("v") Double v);

    @GET("messages.send")
    Call<Response> sendMessageToChat(@Query("random_id") Integer random_id, @Query("chat_id") Integer chat_id,
                               @Query("sticker_id") Integer sticker_id, @Query("access_token") String access_token, @Query("v") Double v);




}
