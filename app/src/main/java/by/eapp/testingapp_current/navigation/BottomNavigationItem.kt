package by.eapp.testingapp_current.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    var route: String,
    var icon: ImageVector,
    var title: String
) {
    object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    object Trainings : NavigationItem("trainings", Icons.Filled.Add, "Trainings")
    object Calorie : NavigationItem("calorie", Icons.Filled.Favorite, "Calories")

}
