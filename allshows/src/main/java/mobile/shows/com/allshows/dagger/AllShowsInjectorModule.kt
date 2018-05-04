package mobile.shows.com.allshows.dagger

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import mobile.shows.com.allshows.AllShowsActivity

@Module(subcomponents = arrayOf(AllShowsSubcomponent::class))
abstract class AllShowsInjectorModule {
    @Binds
    @IntoMap
    @ActivityKey(AllShowsActivity::class)
    internal abstract fun bindAndroidInjectorFactory(builder: AllShowsSubcomponent.Builder)
            : AndroidInjector.Factory<out Activity>
}