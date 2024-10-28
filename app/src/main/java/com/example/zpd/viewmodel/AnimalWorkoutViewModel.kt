package com.example.zpd.viewmodel

import androidx.lifecycle.ViewModel
import com.example.zpd.dao.AnimalWorkoutDAO
import com.example.zpd.entities.AnimalWorkout
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AnimalWorkoutViewModel(private val animalWorkoutDao: AnimalWorkoutDAO) : ViewModel() {

    fun insertAnimalWorkout(animalWorkout: AnimalWorkout) {
        // Launching a coroutine in the ViewModel scope
        viewModelScope.launch {
            animalWorkoutDao.insert(animalWorkout)
        }
    }
}