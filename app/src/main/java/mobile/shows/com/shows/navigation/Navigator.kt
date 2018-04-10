package mobile.shows.com.shows.navigation

import android.content.Context
import mobile.shows.com.commons.domain.entities.Show

interface Navigator {

    val context: Context

    fun startShowActivity(show: Show)

    fun startMainActivity()
}