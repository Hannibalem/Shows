package mobile.shows.com.singleshow.dagger

import dagger.Module
import dagger.Provides
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.commons.dagger.ActivityScope
import mobile.shows.com.singleshow.pagination.SimilarShowsDataSource
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModel
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModelFactory
import mobile.shows.com.singleshow.viewmodel.SingleShowViewModel
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.singleshow.SingleShowActivity
import mobile.shows.com.singleshow.domain.GetSimilarShowsByPageUseCase
import mobile.shows.com.singleshow.domain.GetSimilarShowsUseCase
import mobile.shows.com.singleshow.navigation.Navigator
import mobile.shows.com.singleshow.domain.NetworkGateway
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.commons.domain.usecases.ShowsModel

@Module
internal class SingleShowModule {

    @Provides
    @ActivityScope
    fun provideShow(activity: SingleShowActivity): ShowModel {
        return activity.show
    }

    @Provides
    @ActivityScope
    fun provideUseCase(gateway: NetworkGateway, show: ShowModel): UseCase<ShowsModel> {
        return GetSimilarShowsUseCase(gateway, show.id)
    }

    @Provides
    @ActivityScope
    fun providePagedUseCase(gateway: NetworkGateway, show: ShowModel): PagedUseCase<List<ShowModel>> {
        return GetSimilarShowsByPageUseCase(gateway, show.id)
    }

    @Provides
    @ActivityScope
    fun provideFactory(navigator: Navigator): WrapperWithStateFactory<ShowModel, CardSimilarShowViewModel> {
        return CardSimilarShowViewModelFactory(navigator)
    }

    @Provides
    @ActivityScope
    fun provideDataSource(useCase: PagedUseCase<List<ShowModel>>,
                          factory: WrapperWithStateFactory<ShowModel, CardSimilarShowViewModel>)
            : PagedDataSource<ShowModel, CardSimilarShowViewModel> {
        return SimilarShowsDataSource(useCase, factory)
    }

    @Provides
    @ActivityScope
    fun provideViewModel(useCase: UseCase<ShowsModel>,
                         navigator: Navigator,
                         dataSource: PagedDataSource<ShowModel, CardSimilarShowViewModel>,
                         show: ShowModel)
            : SingleShowViewModel {
        return SingleShowViewModel(show, useCase, navigator, dataSource)
    }
}