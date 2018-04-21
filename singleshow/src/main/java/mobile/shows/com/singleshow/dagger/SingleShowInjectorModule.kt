package mobile.shows.com.singleshow.dagger

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import mobile.shows.com.singleshow.SingleShowActivity

@Module(subcomponents = arrayOf(SingleShowSubcomponent::class))
abstract class SingleShowInjectorModule {
    @Binds
    @IntoMap
    @ActivityKey(SingleShowActivity::class)
    internal abstract fun bindAndroidInjectorFactory(builder: SingleShowSubcomponent.Builder)
            : AndroidInjector.Factory<out Activity>
}
