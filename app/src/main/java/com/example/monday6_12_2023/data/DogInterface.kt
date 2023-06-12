package com.example.monday6_12_2023.data

import retrofit2.http.GET

interface DogInterface {

    @GET("/random")
    fun getDog(): Dog
}