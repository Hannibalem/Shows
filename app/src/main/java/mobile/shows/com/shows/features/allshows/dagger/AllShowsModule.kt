package mobile.shows.com.shows.features.allshows.dagger

import android.app.Activity
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
import mobile.shows.com.shows.navigation.Navigator
import mobile.shows.com.shows.navigation.NavigatorImpl
import mobile.shows.com.shows.domain.api.ApiService
import mobile.shows.com.shows.domain.usecase.Shows
import mobile.shows.com.commons.domain.usecases.UseCase

@Module
class AllShowsModule(private val activity: Activity) {

    @Provides
    @ActivityScope
    fun provideNavigator(): Navigator {
        return NavigatorImpl(activity)
    }

    @Provides
    @ActivityScope
    fun provideUseCase(api: ApiService): UseCase<Shows> {
        return GetShowsUseCase(api)
    }

    @Provides
    @ActivityScope
    fun providePagedUseCase(api: ApiService): PagedUseCase<List<Show>> {
        return GetShowsByPageUseCase(api)
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