package com.example.zpd

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.zpd.dao.FriendshipDAO
import com.example.zpd.entities.User
import com.example.zpd.paging.FriendshipPagingSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class FriendshipPagingSourceTest {

    private lateinit var friendshipDao: FriendshipDAO
    private lateinit var friendshipPagingSource: FriendshipPagingSource

    @Before
    fun setup() {
        friendshipDao = mock()
        friendshipPagingSource = FriendshipPagingSource(friendshipDao, 1L) // Assuming 1L is the userId
    }

    @Test
    fun testPagingSource_loadInitialData() = runBlocking {
        // Create a list of mock users
        val mockUsers = listOf(
            User(1L, "alice", "Alice", "Alice", "alice@gmail.com", "rtr", null),
            User(2L, "Bob", "Bob", "Bob", "bob@gmail.com", "rtr", null)
        )

        // Mock the DAO to return a list of users
        Mockito.`when`(friendshipDao.getFriends(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockUsers)

        // Call the getFriendsList method in the DAO
        val friendsList = friendshipDao.getFriends(1L,2,0)

        // Verify the result
        assertEquals(2, friendsList.size)
        assertEquals("alice", friendsList[0].nickname)
        assertEquals("Bob", friendsList[1].nickname)
    }
}