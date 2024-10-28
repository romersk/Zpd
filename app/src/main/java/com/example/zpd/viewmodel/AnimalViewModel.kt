package com.example.zpd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zpd.dao.AnimalDAO
import com.example.zpd.entities.Animal
import kotlinx.coroutines.launch

class AnimalViewModel(private val animalDAO: AnimalDAO) : ViewModel() {
    fun insertAnimal(animal: Animal) {
        // Launching a coroutine in the ViewModel scope
        viewModelScope.launch {
            animalDAO.insert(animal)
        }
    }
}