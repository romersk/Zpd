package com.example.zpd.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.zpd.entities.Friendship
import com.example.zpd.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface FriendshipDAO {
    @Query("""SELECT * FROM User
    WHERE User.id IN (SELECT Friendship.userId2 FROM Friendship WHERE Friendship.userId1 = :userId)
    OR User.id IN (SELECT Friendship.userId1 FROM Friendship WHERE Friendship.userId2 = :userId)
    LIMIT :limit OFFSET :offset;
    """)
    suspend fun getFriends(userId: Long, limit: Int, offset: Int): List<User>

    @Query("SELECT * FROM Friendship WHERE userId1 = :userId OR userId2 = :userId")
    fun getFriendships(userId: Long): Flow<List<Friendship>>

    @Insert
     fun insert(friendship: Friendship?)

    @Update
    suspend fun update(friendship: Friendship?)

    @Delete
    suspend fun delete(friendship: Friendship?)
}