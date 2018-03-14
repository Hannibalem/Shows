package mobile.shows.com.shows.features.allshows.pagination

import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.utilities.pagination.PagedDataSource
import mobile.shows.com.shows.utilities.pagination.usecase.PagedUseCase
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModel
import mobile.shows.com.shows.utilities.pagination.WrapperWithStateFactory

class ShowsDataSource(
        useCase: PagedUseCase<List<Show>>,
        factory: WrapperWithStateFactory<Show, CardShowViewModel>
) : PagedDataSource<Show, CardShowViewModel>(useCase, factory)