package com.example.zpd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.zpd.entities.Workout

@Dao
interface WorkoutDAO {
    @Query("SELECT * FROM workout WHERE distance = :distance")
    suspend fun getWorkoutByDistance(distance: String?): Workout?

    @Query("SELECT * FROM workout WHERE time = :time")
    suspend fun getWorkoutByTime(time: String?): Workout?

    @Query("SELECT * FROM workout WHERE date = :date")
    suspend fun getWorkoutByDate(date: String?): Workout?

    @Query("SELECT * FROM workout WHERE type = :type")
    suspend fun getWorkoutByType(type: String?): Workout?

    @Query("SELECT * FROM workout WHERE name = :name")
    suspend fun getWorkoutByName(name: String?): Workout?

    @Query("SELECT * FROM workout")
    suspend fun getAll(): List<Workout?>?

    @Query("SELECT * FROM workout WHERE idworkout = :id")
    suspend fun getWorkoutById(id: Long): Workout?

    @Query("SELECT * FROM workout WHERE user_iduser = :iduser")
    suspend fun getWorkoutByUserId(iduser: Long): List<Workout?>?

    @Insert
     fun insert(workout: Workout?)

    @Update
    suspend fun update(workout: Workout?)

    @Delete
    suspend fun delete(workout: Workout?)
}