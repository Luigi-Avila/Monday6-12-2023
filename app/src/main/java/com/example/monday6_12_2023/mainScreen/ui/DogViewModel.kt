package com.example.monday6_12_2023.mainScreen.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monday6_12_2023.mainScreen.data.models.Dog
import com.example.monday6_12_2023.mainScreen.domain.GetDogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(private val getDogUseCase: GetDogUseCase) : ViewModel() {

    private val _dog = MutableLiveData<Dog>()
    val dog: LiveData<Dog> = _dog
    fun getDog() {
        viewModelScope.launch {
            _dog.value = getDogUseCase()!!
            Log.i("Dog", "${_dog.value}")
        }

    }
}