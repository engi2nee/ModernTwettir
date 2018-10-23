package com.code.moderntwettir.network

import com.code.moderntwettir.model.TweetResponse
import com.code.moderntwettir.model.TwitterToken
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by engi2nee on 22.10.2018
 */
interface TwitterApi {

    @FormUrlEncoded
    @POST("/oauth2/token")
    fun getToken(@Header("Authorization") authorization: String,
                 @Field("grant_type") grantType: String): Deferred<Response<TwitterToken>>

    @GET("/1.1/search/tweets.json")
    fun searchTweets(@Header("Authorization") authorization: String,
                     @Query("q") searchedText: String,
                     @Query("max_id") maxId: Long = 0,
                     @Query("since_id") sinceId: Long = 0,
                     @Query("count") count: Int? = 20): Deferred<Response<TweetResponse>>

}