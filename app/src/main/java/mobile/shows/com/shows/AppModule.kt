package mobile.shows.com.shows

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import mobile.shows.com.shows.api.ApiService
import mobile.shows.com.shows.domain.NetworkGatewayImpl
import mobile.shows.com.shows.domain.NetworkGateway
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.navigation.NavigatorImpl
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
    internal fun provideAllShowsNetworkGateway(networkGateway: NetworkGateway): mobile.shows.com.allshows.domain.NetworkGateway {
        return networkGateway
    }

    @Provides
    @Singleton
    fun provideSingleShowFeatureNavigator(context: Context): mobile.shows.com.singleshow.navigation.FeatureNavigator {
        return mobile.shows.com.singleshow.navigation.FeatureNavigatorImpl(context)
    }

    @Provides
    @Singleton
    fun provideAllShowsFeatureNavigator(context: Context): mobile.shows.com.allshows.navigation.FeatureNavigator {
        return mobile.shows.com.allshows.navigation.FeatureNavigatorImpl(context)
    }

    @Provides
    @Singleton
    fun provideNavigator(context: Context,
                         allShowsNavigator: mobile.shows.com.allshows.navigation.FeatureNavigator,
                         singleShowNavigator: mobile.shows.com.singleshow.navigation.FeatureNavigator
    ): Navigator {
        return NavigatorImpl(context, allShowsNavigator, singleShowNavigator)
    }

    @Provides
    @Singleton
    fun provideSingleShowNavigator(navigator: Navigator): mobile.shows.com.singleshow.navigation.Navigator {
        return navigator
    }

    @Provides
    @Singleton
    fun provideAllShowsNavigator(navigator: Navigator): mobile.shows.com.allshows.navigation.Navigator {
        return navigator
    }
}