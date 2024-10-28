package com.example.zpd.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.zpd.dao.FriendshipDAO
import com.example.zpd.entities.User

class FriendshipPagingSource(
    private val friendshipDao: FriendshipDAO,
    private val userId: Long
) : PagingSource<Int, User>() {

    private var isEndOfList = false

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val position = params.key ?: 0  // Ensure position starts from 0
        Log.d("PagingSource", "Load triggered: PageNumber = $position, Offset = $position, LoadSize = ${params.loadSize}")
        return try {
            // Load friends from DAO
            val friends: List<User> = friendshipDao.getFriends(userId, params.loadSize, position)
            Log.d("PagingSource", "Data loaded: ${friends.size} items")
            val nextKey = if (friends.size < params.loadSize) {
                null  // No more pages
            } else {
                position + 1  // Load the next page
            }

            LoadResult.Page(
                data = friends,
                prevKey = if (position == 0) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}