package mobile.shows.com.singleshow.dagger

import dagger.Subcomponent
import dagger.android.AndroidInjector
import mobile.shows.com.commons.dagger.ActivityScope
import mobile.shows.com.singleshow.SingleShowActivity

@Subcomponent(modules = arrayOf(SingleShowModule::class))
@ActivityScope
internal interface SingleShowSubcomponent : AndroidInjector<SingleShowActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SingleShowActivity>()
}