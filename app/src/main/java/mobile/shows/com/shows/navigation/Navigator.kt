package mobile.shows.com.shows.navigation

import android.content.Context
import mobile.shows.com.shows.domain.model.Show

interface Navigator {

    val context: Context

    fun startShowActivity(show: Show)

    fun startMainActivity()
}