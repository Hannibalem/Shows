package mobile.shows.com.singleshow.navigation

import mobile.shows.com.commons.domain.entities.Show

interface Navigator {

    fun startMainActivity()

    fun startShowActivity(show: Show)
}