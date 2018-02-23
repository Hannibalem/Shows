package mobile.shows.com.shows

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerDependencies.init(this)
    }
}