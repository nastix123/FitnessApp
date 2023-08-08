@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package by.eapp.testingapp_current

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val lst = listOf<String>("fitness", "gym", "ioga", "jump", "leg", "upper")
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
                Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))
                mainCards()
            }
        }
    }
}

@Composable
fun SearchBar() {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.background
        ),
        placeholder = {
            Text(stringResource(R.string.place_holder))
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp)
            .fillMaxWidth(0.9f)
            .padding(5.dp, 10.dp),
        shape = RoundedCornerShape(10.dp)
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.paddingFromBaseline(24.dp, 8.dp),
            color = Color.White
        )
    }
}

@Composable
fun RowOfCircles() {

    LazyRow {
        items(lst) { iconName ->
            val iconResourceId = getPictureId(iconName)
            val textResourceId = getTextResourceId(iconName)

            AlignYourBodyElement(drawable = iconResourceId, text = textResourceId)

            Spacer(modifier = Modifier
                .height(10.dp)
                .width(10.dp))
        }
    }
}

@Composable
fun MaterialCard (
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(1f),

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {

            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 15.dp)
            )
        }
    }
}

@Composable
fun mainCards (){
    LazyColumn {
        items(lst) { iconName ->
            val iconResourceId = getPictureId(iconName)
            val textResourceId = getTextResourceId(iconName)

            MaterialCard(drawable = iconResourceId, text = textResourceId)

            Spacer(modifier = Modifier
                .height(15.dp)
                .width(15.dp))
        }
    }
}

@DrawableRes
fun getPictureId(iconName: String): Int {
    return when (iconName) {
        "fitness" -> R.drawable.fitness
        "gym" -> R.drawable.gym
        "ioga" -> R.drawable.ioga
        "jump" -> R.drawable.jump
        "leg" -> R.drawable.leg
        "upper" -> R.drawable.upper
        else -> R.drawable.ic_launcher_background
    }
}

@StringRes
fun getTextResourceId(iconName: String): Int {
    return when (iconName) {
        "fitness" -> R.string.fitness_text
        "gym" -> R.string.gym_text
        "ioga" -> R.string.ioga_text
        "jump" -> R.string.jump_text
        "leg" -> R.string.leg_text
        "upper" -> R.string.upper_text
        else -> R.string.default_text
    }
}



@Preview(showBackground = true)
@Composable
fun ShowTest() {
    SearchBar()
}
