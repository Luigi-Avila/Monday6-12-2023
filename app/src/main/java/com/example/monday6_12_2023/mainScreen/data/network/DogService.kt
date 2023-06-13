package com.example.monday6_12_2023.mainScreen.data.network

import android.util.Log
import com.example.monday6_12_2023.mainScreen.data.models.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(private val dogClient: DogClient) {

    suspend fun getDog(): Dog {
        return withContext(Dispatchers.IO){
            val response = dogClient.getDog()
            Log.i("Dog", "${response.body()}")
            response.body() ?: Dog(message = "", status = "fail")
        }
    }



}