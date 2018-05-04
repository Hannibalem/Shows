package mobile.shows.com.allshows.navigation

import android.content.Context
import android.content.Intent
import mobile.shows.com.allshows.AllShowsActivity

class FeatureNavigatorImpl(val context: Context): FeatureNavigator {

    override fun startFeature() {
        val intent = AllShowsActivity.getIntent(context)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent)
    }
}