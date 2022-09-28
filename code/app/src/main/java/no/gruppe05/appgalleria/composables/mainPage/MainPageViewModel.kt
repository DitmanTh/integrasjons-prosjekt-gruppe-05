package no.gruppe05.appgalleria.composables.mainPage

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import no.gruppe05.appgalleria.data.ApplicationInformation

class MainPageViewModel() : ViewModel() {

    //One app list to contain the currently show list of applications, the other to contain the list of ALL applications in the database
    var currentlyShownApps = mutableStateListOf(ApplicationInformation())
    var allAppsFromDatabase = mutableStateListOf(ApplicationInformation())

    init {

        val tempApp = ApplicationInformation(
            android_id = "com.example.Filler NOT VALID",
            android_title = "FillerTitle",
            android_description = "FillerDescription",
            android_avg_rating = 2.5,
            android_developer = "FillerDeveloper",
            android_icon = "FillerIcon NOT VALID",
            android_max_installs = 0
            )

        while (currentlyShownApps.size > 10) {
            currentlyShownApps.add(tempApp)
            allAppsFromDatabase.add(tempApp)
        }


    }
}