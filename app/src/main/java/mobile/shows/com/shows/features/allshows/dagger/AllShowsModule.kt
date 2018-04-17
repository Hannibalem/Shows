package mobile.shows.com.shows.features.allshows.dagger

import dagger.Module
import dagger.Provides
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.shows.domain.usecase.allshows.GetShowsByPageUseCase
import mobile.shows.com.shows.features.allshows.viewmodel.AllShowsViewModel
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModel
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModelFactory
import mobile.shows.com.shows.features.allshows.pagination.ShowsDataSource
import mobile.shows.com.shows.domain.usecase.allshows.GetShowsUseCase
import mobile.shows.com.commons.dagger.ActivityScope
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.shows.domain.gateways.NetworkGateway

@Module
class AllShowsModule {

    @Provides
    @ActivityScope
    fun provideUseCase(gateway: NetworkGateway): UseCase<Shows> {
        return GetShowsUseCase(gateway)
    }

    @Provides
    @ActivityScope
    fun providePagedUseCase(gateway: NetworkGateway): PagedUseCase<List<Show>> {
        return GetShowsByPageUseCase(gateway)
    }

    @Provides
    @ActivityScope
    fun provideFactory(navigator: Navigator): WrapperWithStateFactory<Show, CardShowViewModel> {
        return CardShowViewModelFactory(navigator)
    }

    @Provides
    @ActivityScope
    fun provideDataSource(useCase: PagedUseCase<List<Show>>,
                          factory: WrapperWithStateFactory<Show, CardShowViewModel>)
            : PagedDataSource<Show, CardShowViewModel> {
        return ShowsDataSource(useCase, factory)
    }

    @Provides
    @ActivityScope
    fun provideViewModel(useCase: UseCase<Shows>, dataSource: PagedDataSource<Show, CardShowViewModel>)
            : AllShowsViewModel {
        return AllShowsViewModel(useCase, dataSource)
    }
}