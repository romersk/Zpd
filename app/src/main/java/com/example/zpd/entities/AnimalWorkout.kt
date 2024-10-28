package com.example.zpd.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "animalworkout",
    primaryKeys = ["workout_idworkout", "animal_idanimal"], // Composite primary key
    foreignKeys = [
        ForeignKey(
            entity = Animal::class,
            parentColumns = ["idanimal"],
            childColumns = ["animal_idanimal"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Workout::class,
            parentColumns = ["idworkout"],
            childColumns = ["workout_idworkout"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)

data class AnimalWorkout(
    var workout_idworkout: Long,
    var animal_idanimal: Long

)
