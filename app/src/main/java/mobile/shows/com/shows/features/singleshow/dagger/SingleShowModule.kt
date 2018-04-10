package mobile.shows.com.shows.features.singleshow.dagger

import android.app.Activity
import dagger.Module
import dagger.Provides
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.commons.dagger.ActivityScope
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.navigation.NavigatorImpl
import mobile.shows.com.shows.features.singleshow.pagination.SimilarShowsDataSource
import mobile.shows.com.shows.domain.usecase.similarshows.GetSimilarShowsByPageUseCase
import mobile.shows.com.shows.domain.usecase.similarshows.GetSimilarShowsUseCase
import mobile.shows.com.shows.features.singleshow.viewmodel.CardSimilarShowViewModel
import mobile.shows.com.shows.features.singleshow.viewmodel.CardSimilarShowViewModelFactory
import mobile.shows.com.shows.features.singleshow.viewmodel.SingleShowViewModel
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.shows.domain.gateways.NetworkGateway
import mobile.shows.com.shows.pagination.usecase.PagedUseCase

@Module
class SingleShowModule(private val activity: Activity, private val show: Show) {

    @Provides
    @ActivityScope
    fun provideShow(): Show {
        return show
    }

    @Provides
    @ActivityScope
    fun provideNavigator(): Navigator {
        return NavigatorImpl(activity)
    }

    @Provides
    @ActivityScope
    fun provideUseCase(gateway: NetworkGateway, show: Show): UseCase<Shows> {
        return GetSimilarShowsUseCase(gateway, show.id)
    }

    @Provides
    @ActivityScope
    fun providePagedUseCase(gateway: NetworkGateway, show: Show): PagedUseCase<List<Show>> {
        return GetSimilarShowsByPageUseCase(gateway, show.id)
    }

    @Provides
    @ActivityScope
    fun provideFactory(navigator: Navigator): WrapperWithStateFactory<Show, CardSimilarShowViewModel> {
        return CardSimilarShowViewModelFactory(navigator)
    }

    @Provides
    @ActivityScope
    fun provideDataSource(useCase: PagedUseCase<List<Show>>,
                          factory: WrapperWithStateFactory<Show, CardSimilarShowViewModel>)
            : PagedDataSource<Show, CardSimilarShowViewModel> {
        return SimilarShowsDataSource(useCase, factory)
    }

    @Provides
    @ActivityScope
    fun provideViewModel(useCase: UseCase<Shows>,
                         navigator: Navigator,
                         dataSource: PagedDataSource<Show, CardSimilarShowViewModel>)
            : SingleShowViewModel {
        return SingleShowViewModel(show, useCase, navigator, dataSource)
    }
}