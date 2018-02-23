package mobile.shows.com.shows.features.allshows.dagger

import dagger.Subcomponent
import mobile.shows.com.shows.features.allshows.MainActivity
import mobile.shows.com.shows.utilities.dagger.ActivityScope

@ActivityScope
@Subcomponent(modules = arrayOf(AllShowsModule::class))
interface AllShowsComponent {

    fun inject(activity: MainActivity)
}