package mobile.shows.com.shows.navigation

import android.content.Context
import mobile.shows.com.commons.domain.usecases.ShowModel

interface Navigator:
        mobile.shows.com.singleshow.navigation.Navigator,
        mobile.shows.com.allshows.navigation.Navigator {

    val context: Context

    fun startAllShowsFeature()

    fun startSingleFeature(show: ShowModel)
}