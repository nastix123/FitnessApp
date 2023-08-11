package by.eapp.testingapp_current.navigation

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            Log.d("Navigation", "Navigating to HomeScreen")
            //HomeScreen()
            Text(text = "Homecsreen", color = Color.Black)
        }
        composable(NavigationItem.Trainings.route) {
            Log.d("Navigation", "Navigating to TrainingListScreen")
            //TrainingListScreen()
            Text(text = "TrainingList", color = Color.Black)
        }
        composable(NavigationItem.Calorie.route) {
            Log.d("Navigation", "Navigating to CalorieScreen")
            Text(text = "Calories", color = Color.Black)
        }
    }
}

