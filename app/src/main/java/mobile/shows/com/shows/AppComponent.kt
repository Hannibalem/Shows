package mobile.shows.com.shows

import dagger.Component
import mobile.shows.com.shows.features.allshows.dagger.AllShowsComponent
import mobile.shows.com.shows.features.allshows.dagger.AllShowsModule
import mobile.shows.com.shows.features.singleshow.dagger.SingleShowComponent
import mobile.shows.com.shows.features.singleshow.dagger.SingleShowModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun plus(module: AllShowsModule): AllShowsComponent

    fun plus(module: SingleShowModule): SingleShowComponent
}