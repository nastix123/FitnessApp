package by.eapp.testingapp_current.ui.theme.customResources

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import by.eapp.testingapp_current.R

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
