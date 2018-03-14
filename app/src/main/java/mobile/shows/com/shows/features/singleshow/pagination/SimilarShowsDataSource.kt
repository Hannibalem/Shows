package mobile.shows.com.shows.features.singleshow.pagination

import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.utilities.pagination.PagedDataSource
import mobile.shows.com.shows.utilities.pagination.usecase.PagedUseCase
import mobile.shows.com.shows.utilities.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.features.singleshow.viewmodel.CardSimilarShowViewModel

class SimilarShowsDataSource(
        useCase: PagedUseCase<List<Show>>,
        factory: WrapperWithStateFactory<Show, CardSimilarShowViewModel>
) : PagedDataSource<Show, CardSimilarShowViewModel>(useCase, factory)