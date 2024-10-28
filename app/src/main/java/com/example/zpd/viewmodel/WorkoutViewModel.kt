package com.example.zpd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zpd.dao.AnimalDAO
import com.example.zpd.dao.WorkoutDAO
import com.example.zpd.entities.Animal
import com.example.zpd.entities.Workout
import kotlinx.coroutines.launch

class WorkoutViewModel(private val workoutDAO: WorkoutDAO) : ViewModel() {
    fun insertWorkout(workout: Workout) {
        // Launching a coroutine in the ViewModel scope
        viewModelScope.launch {
            workoutDAO.insert(workout)
        }
    }
}