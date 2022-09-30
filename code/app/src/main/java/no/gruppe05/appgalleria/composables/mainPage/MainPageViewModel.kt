package no.gruppe05.appgalleria.composables.mainPage

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import no.gruppe05.appgalleria.data.ApplicationInformation

/**
 * Viewmodel for the Main page, will store information and functions for the mainPage composables.
 *
 * A view model stores variables and functions used in a composable. This is because storing
 * this information in composables is bad practice, due to how many times
 * composable functions can get rerendered. If variables are stored incorrectly, the data will
 * reset on a context switch, like if the phone is turned from portrait to landscape
 */
class MainPageViewModel() : ViewModel() {

    //One app list to contain the currently show list of applications,
    // the other to contain the list of ALL applications in the database.
    // This needs to be a mutableStateListOf, otherwise the data would not be stored upon
    // things like turning the phone 90 degrees
    var currentlyShownApps = mutableStateListOf(ApplicationInformation())

    /**
     * Runs on initialization of the object, only once
     */
    init {

        //TODO This should load from database, rather than loading a dummy application
        //currently using ruter information since i know it is valid info
        val tempApp = ApplicationInformation(
            android_id = "no.ruter.reise",
            android_avg_rating = 4.1271677,
            android_developer = "Ruter As",
            android_icon = "https://play-lh.googleusercontent.com/_JlmN0rUUBhUfQtOXYO3_H6bdlO6eyDQdOwOiX3c7_-XA6OB1v66lZrrrI3rsEjYys0",
            android_max_installs = 822837,
            android_title = "Ruter",
            android_description = "Filler description"
            )

        //TODO This is not needed in final product, since this will be done via a firebase connection
        while (currentlyShownApps.size < 10) {
            currentlyShownApps.add(tempApp)
        }


    }
}