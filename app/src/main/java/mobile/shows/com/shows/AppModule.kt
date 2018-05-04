package mobile.shows.com.shows

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import mobile.shows.com.shows.domain.api.ApiService
import mobile.shows.com.shows.domain.api.NetworkGatewayImpl
import mobile.shows.com.shows.domain.gateways.NetworkGateway
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.navigation.NavigatorImpl
import mobile.shows.com.singleshow.navigation.FeatureNavigator
import mobile.shows.com.singleshow.navigation.FeatureNavigatorImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun application(app: App): Application = app

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    internal fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideNetworkGateway(service: ApiService): NetworkGateway {
        return NetworkGatewayImpl(service)
    }

    @Provides
    @Singleton
    internal fun provideSingleShowNetworkGateway(networkGateway: NetworkGateway): mobile.shows.com.singleshow.domain.NetworkGateway {
        return networkGateway
    }

    @Provides
    @Singleton
    fun provideSingleShowFeatureNavigator(context: Context): FeatureNavigator {
        return FeatureNavigatorImpl(context)
    }

    @Provides
    @Singleton
    fun provideNavigator(context: Context,  navigator: FeatureNavigator): Navigator {
        return NavigatorImpl(context, navigator)
    }

    @Provides
    @Singleton
    fun provideSingleShowNavigator(navigator: Navigator): mobile.shows.com.singleshow.navigation.Navigator {
        return navigator
    }
}