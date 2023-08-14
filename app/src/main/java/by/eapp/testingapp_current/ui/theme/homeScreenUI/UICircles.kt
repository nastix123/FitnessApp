package by.eapp.testingapp_current.ui.theme.homeScreenUI

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import by.eapp.testingapp_current.R
import by.eapp.testingapp_current.ui.theme.customResources.getPictureId
import by.eapp.testingapp_current.ui.theme.customResources.getTextResourceId

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    onClick: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable { onClick }
    ) {

        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(MaterialTheme.shapes.small.copy(
                    topStart = CornerSize(10.dp),
                    topEnd = CornerSize(10.dp),
                    bottomStart = CornerSize(10.dp),
                    bottomEnd = CornerSize(10.dp)
                )
        ))
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.paddingFromBaseline(24.dp, 8.dp),
            color = Color.Black
        )
    }
}

@Composable
fun RowOfCircles() {
    LazyRow {
        items(lst.size) { index ->
            val iconName = lst[index]
            val iconResourceId = getPictureId(iconName)
            val textResourceId = getTextResourceId(iconName)

            AlignYourBodyElement(drawable = iconResourceId, text = textResourceId, onClick = {})

            Spacer(modifier = Modifier
                .height(10.dp)
                .width(10.dp))
        }
    }
}