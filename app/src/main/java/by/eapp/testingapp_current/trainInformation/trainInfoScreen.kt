package by.eapp.testingapp_current.trainInformation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.eapp.testingapp_current.ui.theme.customResources.getPictureId
import by.eapp.testingapp_current.ui.theme.customResources.getTextResourceId
import by.eapp.testingapp_current.ui.theme.homeScreenUI.AlignYourBodyElement
import by.eapp.testingapp_current.ui.theme.homeScreenUI.lst

@Composable
fun TrainInformationScreen() {
    RecyclerViewOfCards()
}



@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    @DrawableRes painter: Int,
    contentDescription: String? = null,
    @StringRes title: Int
) {
   
    Card(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.5f)
            ,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box(
            modifier = Modifier.padding(8.dp) 
        ) {
            Box(modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 400f
                    )
                ))
           Image(
               painter = painterResource(id = painter),
               contentDescription = contentDescription,
               contentScale = ContentScale.Crop)
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = stringResource(id = title),
                    style = TextStyle(
                        Color.White,
                        fontSize = 16.sp)
                )
            }
        }
    }

}

@Composable
fun RecyclerViewOfCards(
    modifier: Modifier = Modifier
) {
    LazyRow {
        items(lst.size) { index ->
            val iconName = lst[index]
            val iconResourceId = getPictureId(iconName)
            val textResourceId = getTextResourceId(iconName)
            Box(modifier = modifier.padding(16.dp)) {

             MainCard(painter = iconResourceId, title = textResourceId)
            }
            Spacer(modifier = Modifier
                .height(10.dp)
                .width(10.dp))
        }
    }
}