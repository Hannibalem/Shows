package mobile.shows.com.singleshow.navigation

import mobile.shows.com.commons.domain.usecases.ShowModel

interface Navigator {

    fun startMainActivity()

    fun startShowActivity(show: ShowModel)
}