package com.dicoding.githubsub2.api

import com.dicoding.githubsub2.data.model.DetailUserResponse
import com.dicoding.githubsub2.data.model.User
import com.dicoding.githubsub2.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ):Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username : String
    ):Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username : String
    ):Call<ArrayList<User>>
}