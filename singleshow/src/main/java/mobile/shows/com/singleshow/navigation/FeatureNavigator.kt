package mobile.shows.com.singleshow.navigation

import mobile.shows.com.commons.domain.usecases.ShowModel

interface FeatureNavigator {

    fun startFeature(show: ShowModel)
}