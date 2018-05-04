package mobile.shows.com.shows.navigation

import android.content.Context
import android.content.Intent
import mobile.shows.com.shows.features.allshows.MainActivity
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.singleshow.navigation.FeatureNavigator

class NavigatorImpl(
        override val context: Context,
        val singleShowNavigator: FeatureNavigator): Navigator {

    override fun startMainActivity() {
        val intent = MainActivity.getIntent(context)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent)
    }

    override fun startShowActivity(show: ShowModel) {
        singleShowNavigator.startFeature(show)
    }

    override fun startAllShows() {
        startMainActivity()
    }

    override fun startSingleFeature(show: ShowModel) {
        singleShowNavigator.startFeature(show)
    }
}