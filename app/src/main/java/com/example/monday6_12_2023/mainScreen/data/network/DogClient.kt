package com.example.monday6_12_2023.mainScreen.data.network

import com.example.monday6_12_2023.mainScreen.data.models.Dog
import retrofit2.Response
import retrofit2.http.GET

interface DogClient {
    @GET("random")
    suspend fun getDog(): Response<Dog>
}