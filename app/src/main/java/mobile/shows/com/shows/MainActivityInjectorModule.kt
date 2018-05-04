package mobile.shows.com.shows

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mobile.shows.com.commons.dagger.ActivityScope

@Module
abstract class MainActivityInjectorModule {

    @ContributesAndroidInjector(modules = arrayOf())
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity
}