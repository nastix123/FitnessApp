@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package by.eapp.testingapp_current.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import by.eapp.testingapp_current.R
import java.util.Locale

val textColor = Color.Black
val lst = listOf<String>("fitness", "gym", "ioga", "jump", "leg", "upper")

@ExperimentalMaterial3Api
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    val message = remember {
        mutableStateOf("")
    }

    TextField(
        value = message.value,
        onValueChange = {newText ->message.value = newText},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = textColor
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
fun MaterialCard (
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .width(192.dp)

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

/*@Composable
fun mainCards (){
    LazyColumn {
        items(lst.size) { index ->
            val iconName = lst[index]
            val iconResourceId = getPictureId(iconName)
            val textResourceId = getTextResourceId(iconName)

            MaterialCard(drawable = iconResourceId, text = textResourceId)

            Spacer(modifier = Modifier
                .height(15.dp)
                .width(15.dp))
        }
    }
}*/

@Composable
fun CardCollection (
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid (
        rows = GridCells.Fixed(2),
        modifier = modifier.height(120.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(lst.size) {index ->
            val iconName = lst[index]
            val iconResourceId = getPictureId(iconName)
            val textResourceId = getTextResourceId(iconName)

            MaterialCard(drawable = iconResourceId, text = textResourceId,modifier.height(56.dp))

        }
        }
    }

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(stringResource(title).uppercase(Locale.getDefault()),
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
            .padding(horizontal = 16.dp))
        content()
    }
}

@Composable
fun HomeScreen (
    modifier: Modifier = Modifier
) {
    Column(modifier
        .verticalScroll(rememberScrollState())
        .padding(vertical = 16.dp)) {
        Spacer(modifier = Modifier.padding(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            RowOfCircles()
        }
        HomeSection(title = R.string.favorite_collections) {
            CardCollection()
        }
        Spacer(Modifier.height(16.dp))
    }
}

