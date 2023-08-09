@file:OptIn(ExperimentalGlideComposeApi::class)

package by.eapp.testingapp_current

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.eapp.testingapp_current.ui.theme.BottomNavigation
import by.eapp.testingapp_current.ui.theme.CardCollection
import by.eapp.testingapp_current.ui.theme.HomeScreen
import by.eapp.testingapp_current.ui.theme.RowOfCircles
import by.eapp.testingapp_current.ui.theme.SearchBar

import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                Column {

                    HomeScreen()
                    BottomNavigation()

                }
            }

        }
    }
}




