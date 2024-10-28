package com.example.zpd.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "workout",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["user_iduser"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class Workout(
    @PrimaryKey(autoGenerate = true) var idworkout: Long,
    var user_iduser: Long,
    var name: String,
    var type: String,
    var time: String,
    var distance: String,
    var date: String
)
