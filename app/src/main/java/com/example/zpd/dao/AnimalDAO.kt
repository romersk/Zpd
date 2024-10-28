package com.example.zpd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.zpd.entities.Animal

@Dao
interface AnimalDAO {
    @Query("SELECT * FROM animal WHERE behavior = :behavior")
    suspend fun getAnimalByBehavior(behavior: String?): List<Animal?>?

    @Query("SELECT * FROM animal WHERE birthdate = :birthdate")
    suspend fun getAnimalByBirthdate(birthdate: String?): List<Animal?>?

    @Query("SELECT * FROM animal WHERE breed = :breed")
    suspend fun getAnimalByBreed(breed: String?): List<Animal?>?

    @Query("SELECT * FROM animal WHERE type = :type")
    suspend fun getAnimalByType(type: String?): List<Animal?>?

    @Query("SELECT * FROM animal WHERE name = :name")
    suspend fun getAnimalByName(name: String?): List<Animal?>?

    @Query("SELECT * FROM animal WHERE user_iduser = :user_iduser")
    suspend fun getAnimalByUserId(user_iduser: Long): List<Animal?>?

    @Query("SELECT * FROM animal WHERE idanimal = :idanimal")
    suspend fun getAnimalById(idanimal: Long): Animal?

    @Query("SELECT * FROM animal")
    suspend fun getAll(): List<Animal?>?

    @Insert
    fun insert(animal: Animal?)

    @Update
    suspend fun update(animal: Animal?)

    @Delete
    suspend fun delete(animal: Animal?)
}