package no.gruppe05.appgalleria.data

/**
 * Data class for storing information about applications from database
 */
data class ApplicationInformation(

    var android_id: String = "",
    var android_title: String = "",
    var android_developer: String = "",
    var android_icon: String = "",
    var android_avg_rating: Double = 0.0,
    var android_description: String = "",
    var android_max_installs: Int = 0

)