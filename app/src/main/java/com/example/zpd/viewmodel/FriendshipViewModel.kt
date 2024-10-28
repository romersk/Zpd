package com.example.zpd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zpd.dao.FriendshipDAO
import com.example.zpd.entities.Friendship
import com.example.zpd.entities.User
import kotlinx.coroutines.launch

class FriendshipViewModel(private val friendshipDAO: FriendshipDAO) : ViewModel()  {
    fun insertFriendship(friendship: Friendship) {
        // Launching a coroutine in the ViewModel scope
        viewModelScope.launch {
            friendshipDAO.insert(friendship)
        }
    }
    fun getFriends(userId: Long, limit: Int, offset: Int): List<User> {
        var result = emptyList<User>()
        viewModelScope.launch {
           result = friendshipDAO.getFriends(userId, limit, offset)
        }
        return result
    }


}