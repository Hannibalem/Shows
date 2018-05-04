package mobile.shows.com.shows

import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance
import mobile.shows.com.allshows.dagger.AllShowsInjectorModule
import mobile.shows.com.singleshow.dagger.SingleShowInjectorModule

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityInjectorModule::class,
        SingleShowInjectorModule::class,
        AllShowsInjectorModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}