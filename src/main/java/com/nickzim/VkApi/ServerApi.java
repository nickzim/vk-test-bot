package com.nickzim.VkApi;

import com.nickzim.DTOs.Responce.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerApi {

    //Private message

    //Simple message or link
    @GET("messages.send")
    Call<Response> sendMessage(@Query("random_id") Integer random_id, @Query("peer_id") Integer peer_id, @Query("message") String message,
                               @Query("access_token") String access_token, @Query("v") Double v);

    //Forwarded message
    @GET("messages.send")
    Call<Response> sendMessage(@Query("random_id") Integer random_id, @Query("peer_id") Integer peer_id, @Query("message") String message,
                               @Query("forward_messages") String forward_messages, @Query("access_token") String access_token, @Query("v") Double v);

    //Sticker
    @GET("messages.send")
    Call<Response> sendMessage(@Query("random_id") Integer random_id, @Query("peer_id") Integer peer_id,
                               @Query("sticker_id") Integer sticker_id, @Query("access_token") String access_token, @Query("v") Double v);

    //Media
    @GET("messages.send")
    Call<Response> sendMediaMessage(@Query("random_id") Integer random_id, @Query("peer_id") Integer peer_id, @Query("message") String message,
                               @Query("attachment") String attachment, @Query("access_token") String access_token, @Query("v") Double v);

    // Chat

    //Simple message or link
    @GET("messages.send")
    Call<Response> sendMessageToChat(@Query("random_id") Integer random_id, @Query("chat_id") Integer chat_id, @Query("group_id") Integer group_id,
                                     @Query("message") String message, @Query("access_token") String access_token, @Query("v") Double v);

    //Sticker
    @GET("messages.send")
    Call<Response> sendMessageToChat(@Query("random_id") Integer random_id, @Query("chat_id") Integer chat_id, @Query("group_id") Integer group_id,
                               @Query("sticker_id") Integer sticker_id, @Query("access_token") String access_token, @Query("v") Double v);


    //Media
    @GET("messages.send")
    Call<Response> sendMediaMessageToChat(@Query("random_id") Integer random_id, @Query("chat_id") Integer peer_id, @Query("group_id") Integer group_id,
                                          @Query("message") String message, @Query("attachment") String attachment,
                                          @Query("access_token") String access_token, @Query("v") Double v);


}
