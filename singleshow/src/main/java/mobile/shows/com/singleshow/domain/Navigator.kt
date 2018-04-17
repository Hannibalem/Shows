package mobile.shows.com.singleshow.domain

import mobile.shows.com.commons.domain.entities.Show

interface Navigator {

    fun startMainActivity()

    fun startShowActivity(show: Show)
}