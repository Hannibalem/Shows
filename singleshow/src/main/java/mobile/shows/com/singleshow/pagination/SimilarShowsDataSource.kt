package mobile.shows.com.singleshow.pagination

import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModel
import mobile.shows.com.shows.pagination.usecase.PagedUseCase

internal class SimilarShowsDataSource(
        useCase: PagedUseCase<List<Show>>,
        factory: WrapperWithStateFactory<Show, CardSimilarShowViewModel>
) : PagedDataSource<Show, CardSimilarShowViewModel>(useCase, factory)