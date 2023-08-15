package by.eapp.testingapp_current.trainInformation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.eapp.testingapp_current.R
import by.eapp.testingapp_current.ui.theme.customResources.getPictureId
import by.eapp.testingapp_current.ui.theme.customResources.getTextResourceId
import by.eapp.testingapp_current.ui.theme.homeScreenUI.lst


@Preview(showBackground = true)
@Composable
fun TrainInformationScreen() {
    MainCard(painter =  R.drawable.fitness, title = R.string.fitness_text)
    LazyColumn() {items(lst.size) {index ->
        val iconName = lst[index]
        val iconResourceId = getPictureId(iconName)
        val textResourceId = getTextResourceId(iconName)
        ExerciseDescription(
            image = iconResourceId,
            text = textResourceId,
            description = textResourceId)

    }
        
    }
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
            .fillMaxWidth(1f)
            .height(200.dp)
            ,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
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
                        startY = 50f
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
                        fontSize = 16.sp),
                    textAlign = TextAlign.Right
                )
            }
        }
    }

}

@Composable
fun ExerciseList (
    @StringRes text: Int,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(text = stringResource(id = R.string.fitness_text))

        LazyColumn() {items (lst.size) {

        }



        }
    }
}

@Composable
fun ExerciseDescription(
    @DrawableRes image: Int,
    @StringRes text: Int,
    @StringRes description: Int,
   // onClick: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(1f)
           // .clickable { onClick },

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Column() {
                Text(
                    text = stringResource(id = text),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )
                Text(
                    text = stringResource(id = description),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = modifier.padding(start = 15.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCArd() {
    ExerciseDescription(
        image =  R.drawable.ioga,
        text = R.string.leg_text,
        description = R.string.description_gym,
    )

}