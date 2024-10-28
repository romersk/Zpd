package com.example.zpd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zpd.dao.AnimalWorkoutDAO
import com.example.zpd.dao.UserDAO
import com.example.zpd.entities.AnimalWorkout
import com.example.zpd.entities.User
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDAO) : ViewModel() {
    fun insertUser(user: User) {
        // Launching a coroutine in the ViewModel scope
        viewModelScope.launch {
            userDao.insert(user)
        }
    }
    fun getUsers(): List<User> {
        var list = emptyList<User>()
        viewModelScope.launch {
            list = userDao.getUsers()
        }
        return list
    }
}