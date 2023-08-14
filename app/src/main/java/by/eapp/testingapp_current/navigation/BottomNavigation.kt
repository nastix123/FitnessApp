@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package by.eapp.testingapp_current.navigation



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.eapp.testingapp_current.R
import by.eapp.testingapp_current.progressBar.CircularProgressBar
import by.eapp.testingapp_current.trainInformation.TrainInformationScreen
import by.eapp.testingapp_current.trainingList.TrainingListScreen
import by.eapp.testingapp_current.ui.theme.homeScreenUI.HomeScreen


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        //backgroundColor = colorResource(R.color.colorPrimaryDark) // Set background color to avoid the white flashing when you switch between screens
    )
}
@Composable
fun BottomNavigation(navController: NavController, modifier: Modifier = Modifier) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Trainings,
        NavigationItem.Calorie,
    )
    val navController = rememberNavController()
    Scaffold(
        containerColor = colorResource(id = R.color.purple_2),
        bottomBar = {
            BottomNavigation (backgroundColor = colorResource(id = R.color.purple_1)) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        label = { Text(item.title)},
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = NavigationItem.Home.route, Modifier.padding(innerPadding)) {
            composable(NavigationItem.Trainings.route) { TrainingListScreen() }
            composable(NavigationItem.Calorie.route) { TrainInformationScreen() }
            composable(NavigationItem.Home.route) { HomeScreen() }
        }
    }
}

