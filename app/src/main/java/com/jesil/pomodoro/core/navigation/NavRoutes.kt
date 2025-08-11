package com.jesil.pomodoro.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jesil.pomodoro.feature.new_task.NewTaskScreen
import com.jesil.pomodoro.feature.new_task.models.NewTaskState
import com.jesil.pomodoro.feature.on_boarding.OnboardingScreen

@Composable
fun NavRoutes(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.ONBOARDING_SCREEN.route
    ){
        composable(Screens.ONBOARDING_SCREEN.route){
            OnboardingScreen(navController)
        }
        composable("new_task_screen") {
            NewTaskScreen(
                navController = navController
            )
        }
    }
}