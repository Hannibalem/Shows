package mobile.shows.com.shows.features.singleshow.pagination

import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.domain.usecase.Show
import mobile.shows.com.shows.features.singleshow.viewmodel.CardSimilarShowViewModel
import mobile.shows.com.shows.pagination.usecase.PagedUseCase

class SimilarShowsDataSource(
        useCase: PagedUseCase<List<Show>>,
        factory: WrapperWithStateFactory<Show, CardSimilarShowViewModel>
) : PagedDataSource<Show, CardSimilarShowViewModel>(useCase, factory)