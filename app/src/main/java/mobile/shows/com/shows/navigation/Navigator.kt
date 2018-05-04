package mobile.shows.com.shows.navigation

import android.content.Context
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.singleshow.navigation.Navigator

interface Navigator: Navigator {

    val context: Context

    fun startAllShows()

    fun startSingleFeature(show: Show)
}