package com.example.monday6_12_2023.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/image/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}