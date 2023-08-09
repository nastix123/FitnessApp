@file:OptIn(ExperimentalGlideComposeApi::class)

package by.eapp.testingapp_current

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.eapp.testingapp_current.ui.theme.CardCollection
import by.eapp.testingapp_current.ui.theme.RowOfCircles
import by.eapp.testingapp_current.ui.theme.SearchBar

import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {

                SearchBar()
                Spacer(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(1f))
                RowOfCircles()
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp))
                CardCollection()

            }
        }
    }
}




