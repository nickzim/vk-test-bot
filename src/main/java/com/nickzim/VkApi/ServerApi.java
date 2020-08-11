package com.nickzim.VkApi;

import com.nickzim.DTOs.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerApi {

    @GET("messages.send")
    Call<Response> sendMessage(@Query("user_id") Long user_id, @Query("random_id") Long random_id,
                               @Query("peer_id") Long peer_id, @Query("message") String message,
                               @Query("access_token") String access_token, @Query("v") Double v);


}
