package com.example.zpd.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.zpd.config.DateConverter
import com.example.zpd.dao.AnimalDAO
import com.example.zpd.dao.AnimalWorkoutDAO
import com.example.zpd.dao.FriendshipDAO
import com.example.zpd.dao.UserDAO
import com.example.zpd.dao.WorkoutDAO
import com.example.zpd.entities.Animal
import com.example.zpd.entities.AnimalWorkout
import com.example.zpd.entities.Friendship
import com.example.zpd.entities.User
import com.example.zpd.entities.Workout

@Database(
    entities = [User::class, Friendship::class, Workout::class, Animal::class, AnimalWorkout::class],
    version = 7
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun friendshipDao(): FriendshipDAO
    abstract fun workoutDao(): WorkoutDAO
    abstract fun animalDao(): AnimalDAO
    abstract fun animalWorkoutDao(): AnimalWorkoutDAO
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}