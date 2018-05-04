package mobile.shows.com.singleshow.navigation

import android.content.Context
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.singleshow.SingleShowActivity

class FeatureNavigatorImpl(val context: Context): FeatureNavigator {

    override fun startFeature(show: ShowModel) {
        context.startActivity(SingleShowActivity.getIntent(context, show))
    }
}