package com.example.zpd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.zpd.entities.User

@Dao
interface UserDAO {
    @Insert
     fun insert(user: User?)

    @Update
    suspend fun update(user: User?)

    @Delete
    suspend fun delete(user: User?)

    @Query("""
        SELECT * FROM User
    """)
     fun getUsers(): List<User>
}