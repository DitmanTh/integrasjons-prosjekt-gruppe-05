package no.gruppe05.appgalleria.composables.mainPage

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import no.gruppe05.appgalleria.data.ApplicationInformation
import no.gruppe05.appgalleria.R

/**
 * Displays the name, customer, and image of a single application
 *
 * @param   app     - An object storing the data for the application that will be displayed
 */
@Composable
fun Application(app: ApplicationInformation) {

    //fetches the current context
    val context = LocalContext.current

    //Layers the name, customer name, and image in a column
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //Displays image, with a placeholder for before the image is done fetching from URL
        AppIcon(app = app)
        //creates some space for between text and image
        Spacer(modifier = Modifier.height(0.dp))

        //Texts for displaying title and app customer
        Text(
            text = app.android_title,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onPrimary,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * Fetches and displays the image used for the icon of the application
 */
@Composable
fun AppIcon(app: ApplicationInformation) {

    val context = LocalContext.current
    //Displays image, with a placeholder for before the image is done fetching from URL
    AsyncImage(
        //There is an app that has no proper image tied to it, it will show the icon for the current app instead
        model = if (app.android_icon == "Dummy icon") {
            ImageRequest.Builder(context)
                //android_icon is the URL to the icon we are fetching
                .data(context.getDrawable(R.drawable.ic_launcher_foreground))
                .crossfade(true)
                .build()
        } else {
            ImageRequest.Builder(context)
                //android_icon is the URL to the icon we are fetching
                .data(app.android_icon)
                .crossfade(true)
                .build()
        },
        contentDescription = "App icon",
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(all = 16.dp)
            .clip(MaterialTheme.shapes.small)
    )
}