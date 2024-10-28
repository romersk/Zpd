package com.example.zpd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.zpd.entities.AnimalWorkout

@Dao
interface AnimalWorkoutDAO {
    @Query("SELECT * FROM animalworkout WHERE animal_idanimal = :animal_idanimal")
    suspend fun getAnimalWorkoutByAnimalId(animal_idanimal: Long): List<AnimalWorkout?>?

    @Query("SELECT * FROM animalworkout WHERE workout_idworkout = :workout_idworkout")
    suspend fun getAnimalWorkoutByWorkoutId(workout_idworkout: Long): List<AnimalWorkout?>?

    @Query("SELECT * FROM animalworkout")
    suspend fun getAll(): List<AnimalWorkout?>?

    @Query("SELECT * FROM animalworkout WHERE workout_idworkout = :workout_idworkout AND animal_idanimal = :animal_idanimal")
    suspend fun getAnimalWorkoutByWorkoutIdAndAnimalId(
        workout_idworkout: Long,
        animal_idanimal: Long
    ): AnimalWorkout?

    @Insert
    fun insert(animalWorkout: AnimalWorkout?)

    @Update
    suspend fun update(animalWorkout: AnimalWorkout?)

    @Delete
    suspend fun delete(animalWorkout: AnimalWorkout?)
}