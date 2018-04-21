package mobile.shows.com.shows

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mobile.shows.com.commons.dagger.ActivityScope
import mobile.shows.com.shows.features.allshows.MainActivity
import mobile.shows.com.shows.features.allshows.dagger.AllShowsModule

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = arrayOf(AllShowsModule::class))
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity
}