package mobile.shows.com.shows

import android.app.Application
import mobile.shows.com.shows.features.allshows.MainActivity
import mobile.shows.com.shows.features.allshows.dagger.AllShowsModule
import mobile.shows.com.shows.features.singleshow.SingleShowActivity
import mobile.shows.com.shows.features.singleshow.dagger.SingleShowModule

class DaggerDependencies {

    companion object {

        private lateinit var injector: AppComponent

        fun init(app: Application) {
            injector = DaggerAppComponent.builder().appModule(AppModule(app)).build()
        }

        fun inject(activity: MainActivity) {
            injector.plus(AllShowsModule(activity)).inject(activity)
        }

        fun inject(activity: SingleShowActivity) {
            injector.plus(SingleShowModule(activity, activity.show)).inject(activity)
        }
    }
}