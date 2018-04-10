package mobile.shows.com.shows.features.allshows.pagination

import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModel

class ShowsDataSource(
        useCase: PagedUseCase<List<Show>>,
        factory: WrapperWithStateFactory<Show, CardShowViewModel>
) : PagedDataSource<Show, CardShowViewModel>(useCase, factory)