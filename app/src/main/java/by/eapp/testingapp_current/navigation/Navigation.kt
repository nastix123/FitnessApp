package by.eapp.testingapp_current.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.eapp.testingapp_current.progressBar.CircularProgressBar
import by.eapp.testingapp_current.trainingList.TrainingListScreen
import by.eapp.testingapp_current.ui.theme.homeScreenUI.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Log.d("Navigation", "Navigating to HomeScreen")
            HomeScreen()

        }
        composable(NavigationItem.Trainings.route) {
            Log.d("Navigation", "Navigating to TrainingListScreen")
            TrainingListScreen()

        }
        composable(NavigationItem.Calorie.route) {
            Log.d("Navigation", "Navigating to CalorieScreen")
            CircularProgressBar()
        }
    }
}

