package com.example.zpd.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModelProvider
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.zpd.dao.FriendshipDAO
import com.example.zpd.entities.User
import kotlinx.coroutines.flow.Flow

class FriendsViewModel(private val friendshipDao: FriendshipDAO, private val userId: Long) : ViewModel() {

    fun getFriends(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(pageSize = 5, enablePlaceholders = false, initialLoadSize = 5),
            pagingSourceFactory = { FriendshipPagingSource(friendshipDao, userId) }
        ).flow.cachedIn(viewModelScope)
    }
}

class FriendsViewModelFactory(
    private val friendshipDao: FriendshipDAO,
    private val userId: Long
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FriendsViewModel::class.java)) {
            return FriendsViewModel(friendshipDao, userId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}