package mobile.shows.com.shows.navigation

import android.content.Context
import mobile.shows.com.commons.domain.usecases.ShowModel

class NavigatorImpl(
        override val context: Context,
        private val allShowsFeatureNavigator: mobile.shows.com.allshows.navigation.FeatureNavigator,
        private val singleShowNavigator: mobile.shows.com.singleshow.navigation.FeatureNavigator
): Navigator {

    override fun startPreviousActivity() {
        startAllShowsFeature()
    }

    override fun startShowActivity(show: ShowModel) {
        startSingleFeature(show)
    }

    override fun startAllShowsFeature() {
        allShowsFeatureNavigator.startFeature()
    }

    override fun startSingleFeature(show: ShowModel) {
        singleShowNavigator.startFeature(show)
    }
}