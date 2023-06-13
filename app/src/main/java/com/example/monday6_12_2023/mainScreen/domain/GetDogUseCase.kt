package com.example.monday6_12_2023.mainScreen.domain

import com.example.monday6_12_2023.mainScreen.data.DogRepository
import com.example.monday6_12_2023.mainScreen.data.models.Dog
import javax.inject.Inject

class GetDogUseCase @Inject constructor(private val repository: DogRepository) {
    suspend operator fun invoke(): Dog = repository.getDog()
}