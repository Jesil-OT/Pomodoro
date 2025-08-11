package com.jesil.pomodoro.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jesil.pomodoro.core.navigation.NavRoutes
import com.jesil.pomodoro.core.theme.PomodoroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PomodoroTheme {
                NavRoutes(
                    modifier = Modifier.fillMaxSize(),
                    navController = rememberNavController()
                )
            }
        }
    }
}