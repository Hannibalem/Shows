package mobile.shows.com.shows.features.singleshow.dagger

import dagger.Subcomponent
import mobile.shows.com.shows.utilities.dagger.ActivityScope
import mobile.shows.com.shows.features.singleshow.SingleShowActivity

@ActivityScope
@Subcomponent(modules = arrayOf(SingleShowModule::class))
interface SingleShowComponent {

    fun inject(activity: SingleShowActivity)
}