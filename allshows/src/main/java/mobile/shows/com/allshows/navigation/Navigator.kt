package mobile.shows.com.allshows.navigation

import mobile.shows.com.commons.domain.usecases.ShowModel

interface Navigator {

    fun startShowActivity(show: ShowModel)
}