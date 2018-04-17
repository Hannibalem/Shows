package mobile.shows.com.singleshow.dagger

import dagger.Module
import dagger.Provides
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.commons.dagger.ActivityScope
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.singleshow.pagination.SimilarShowsDataSource
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModel
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModelFactory
import mobile.shows.com.singleshow.viewmodel.SingleShowViewModel
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.singleshow.SingleShowActivity
import mobile.shows.com.singleshow.domain.GetSimilarShowsByPageUseCase
import mobile.shows.com.singleshow.domain.GetSimilarShowsUseCase
import mobile.shows.com.singleshow.domain.Navigator
import mobile.shows.com.singleshow.domain.NetworkGateway

@Module
class SingleShowModule {

    @Provides
    @ActivityScope
    fun provideShow(activity: SingleShowActivity): Show {
        return activity.show
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
                         dataSource: PagedDataSource<Show, CardSimilarShowViewModel>,
                         show: Show)
            : SingleShowViewModel {
        return SingleShowViewModel(show, useCase, navigator, dataSource)
    }
}