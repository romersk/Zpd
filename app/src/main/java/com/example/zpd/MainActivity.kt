package com.example.zpd

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.viewModelScope
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.paging.LOG_TAG
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zpd.database.AppDatabase
import com.example.zpd.entities.Animal
import com.example.zpd.entities.AnimalWorkout
import com.example.zpd.entities.Friendship
import com.example.zpd.entities.User
import com.example.zpd.entities.Workout
import com.example.zpd.paging.FriendsAdapter
import com.example.zpd.paging.FriendsViewModel
import com.example.zpd.paging.FriendsViewModelFactory
import com.example.zpd.viewmodel.AnimalViewModel
import com.example.zpd.viewmodel.AnimalWorkoutViewModel
import com.example.zpd.viewmodel.FriendshipViewModel
import com.example.zpd.viewmodel.UserViewModel
import com.example.zpd.viewmodel.WorkoutViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var friendsAdapter: FriendsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        // Create a map programmatically and set the initial camera
//        var mapView = MapView(this)
//        mapView.mapboxMap.setCamera(
//            CameraOptions.Builder()
//                .center(Point.fromLngLat(-98.0, 39.5))
//                .pitch(0.0)
//                .zoom(2.0)
//                .bearing(0.0)
//                .build()
//        )
//        // Add the map view to the activity (you can also add it to other views as a child)
//        setContentView(mapView)

        val appDatabase: AppDatabase = AppDatabase.getDatabase(applicationContext)
        //Log.d("USER", appDatabase.userDao().getUsers().toString())
//        val animalWorkoutViewModel = AnimalWorkoutViewModel(appDatabase.animalWorkoutDao())
        val userViewModel = UserViewModel(appDatabase.userDao())
//        val friendshipViewModel = FriendshipViewModel(appDatabase.friendshipDao())
//        val animalViewModel = AnimalViewModel(appDatabase.animalDao())
//        val workoutViewModel = WorkoutViewModel(appDatabase.workoutDao())
        //Log.d("USER", userViewModel.getUsers().toString())
        val friendsViewModel: FriendsViewModel by viewModels {
            FriendsViewModelFactory(appDatabase.friendshipDao(), 1L)
        }
        friendsAdapter = FriendsAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = friendsAdapter
        }

        // Launch a coroutine to observe the flow and submit data to the adapter
        lifecycleScope.launch {

            friendsViewModel.getFriends().collectLatest { pagingData: PagingData<User> ->
                Log.d("MainActivity", "PagingData emitted: $pagingData")
                friendsAdapter.submitData(pagingData)
            }
        }

    }
}