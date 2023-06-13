package com.example.monday6_12_2023.mainScreen.data

import com.example.monday6_12_2023.mainScreen.data.models.Dog
import com.example.monday6_12_2023.mainScreen.data.network.DogService
import javax.inject.Inject

class DogRepository @Inject constructor(private val dogService: DogService) {
    suspend fun getDog(): Dog {
        return dogService.getDog()
    }

}