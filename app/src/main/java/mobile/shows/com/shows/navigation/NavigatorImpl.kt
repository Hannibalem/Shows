package mobile.shows.com.shows.navigation

import android.content.Context
import android.content.Intent
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.shows.features.allshows.MainActivity
import mobile.shows.com.shows.features.singleshow.SingleShowActivity

class NavigatorImpl(override val context: Context): Navigator {

    override fun startShowActivity(show: Show) {
        context.startActivity(SingleShowActivity.getIntent(context, show))
    }

    override fun startMainActivity() {
        val intent = MainActivity.getIntent(context)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent)
    }

}