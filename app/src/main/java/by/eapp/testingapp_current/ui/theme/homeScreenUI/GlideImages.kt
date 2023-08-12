@file:OptIn(ExperimentalGlideComposeApi::class)

package by.eapp.testingapp_current.ui.theme.homeScreenUI

import androidx.compose.runtime.Composable
import by.eapp.testingapp_current.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun getGlideImage(
    text: String
) : Unit {
    return when (text) {
        "fitness" -> { GlideImage(
            model ="https://img.championat.com/c/1350x759/news/big/p/y/kogda-nuzhno-otdavat-rebjonka-v-sport-rekomendacii_1574181249956324555.jpg",
            contentDescription = null)
        }
        "gym" -> { GlideImage(
            model ="https://img.championat.com/c/1350x759/news/big/p/y/kogda-nuzhno-otdavat-rebjonka-v-sport-rekomendacii_1574181249956324555.jpg",
            contentDescription = null)
        }
        "ioga" -> { GlideImage(
            model ="https://img.championat.com/c/1350x759/news/big/p/y/kogda-nuzhno-otdavat-rebjonka-v-sport-rekomendacii_1574181249956324555.jpg",
            contentDescription = null)
        }
        "jump" -> { GlideImage(
            model ="https://img.championat.com/c/1350x759/news/big/p/y/kogda-nuzhno-otdavat-rebjonka-v-sport-rekomendacii_1574181249956324555.jpg",
            contentDescription = null)
        }
        "leg" -> { GlideImage(
            model ="https://img.championat.com/c/1350x759/news/big/p/y/kogda-nuzhno-otdavat-rebjonka-v-sport-rekomendacii_1574181249956324555.jpg",
            contentDescription = null)
        }
        "upper" -> { GlideImage(
            model ="https://img.championat.com/c/1350x759/news/big/p/y/kogda-nuzhno-otdavat-rebjonka-v-sport-rekomendacii_1574181249956324555.jpg",
            contentDescription = null)
        }
        else ->
        {GlideImage(model ="https://img.championat.com/c/1350x759/news/big/p/y/kogda-nuzhno-otdavat-rebjonka-v-sport-rekomendacii_1574181249956324555.jpg", contentDescription = null)}


}}
