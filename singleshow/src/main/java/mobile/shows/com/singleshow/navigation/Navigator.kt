package mobile.shows.com.singleshow.navigation

import mobile.shows.com.commons.domain.usecases.ShowModel

interface Navigator {

    fun startPreviousActivity()

    fun startShowActivity(show: ShowModel)
}