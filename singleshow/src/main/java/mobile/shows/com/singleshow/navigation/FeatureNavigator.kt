package mobile.shows.com.singleshow.navigation

import mobile.shows.com.commons.domain.entities.Show

interface FeatureNavigator {

    fun startFeature(show: Show)
}