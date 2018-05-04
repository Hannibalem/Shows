package mobile.shows.com.allshows.dagger

import dagger.Subcomponent
import dagger.android.AndroidInjector
import mobile.shows.com.allshows.AllShowsActivity
import mobile.shows.com.commons.dagger.ActivityScope

@Subcomponent(modules = arrayOf(AllShowsModule::class))
@ActivityScope
internal interface AllShowsSubcomponent : AndroidInjector<AllShowsActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<AllShowsActivity>()
}