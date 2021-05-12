package com.mimmer.viggosidle

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mimmer.viggosidle.Database.AppDatabase
import com.mimmer.viggosidle.Database.DatabaseBuilder
import com.mimmer.viggosidle.Database.DbHelperImpl
import com.mimmer.viggosidle.Database.Player
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_shop, R.id.navigation_settings))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        val dbHelper = DbHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        runBlocking {
            val players: List<Player> = dbHelper.getAll()

            if (players.isEmpty()) {
                val player = Player(
                    uid = 1,
                    glassNumber = "8550",
                    currentScore = 4,
                    clickingPower = 1,
                    idleGains = 0
                )
                dbHelper.insertPlayer(player)
            }
            launch {
                Log.i("db", dbHelper.getAll().toString())
                Log.i("score", dbHelper.getCurrentScore().toString())
            }
        }

    }
}