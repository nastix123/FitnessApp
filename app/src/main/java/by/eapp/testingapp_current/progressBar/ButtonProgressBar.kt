package by.eapp.testingapp_current.progressBar

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import by.eapp.testingapp_current.R

@Composable
public fun ButtonProgressbar(
    backgroundColor: Color = Color(0xFF35898f),
    onClickButton: () -> Unit
) {
    Button(
        onClick = {
            onClickButton()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.purple_1)
        )
    ) {
        Text(
            text = "Add product",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}
