package mobile.shows.com.singleshow.pagination

import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.singleshow.viewmodel.CardSimilarShowViewModel
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.commons.domain.usecases.ShowModel

internal class SimilarShowsDataSource(
        useCase: PagedUseCase<List<ShowModel>>,
        factory: WrapperWithStateFactory<ShowModel, CardSimilarShowViewModel>
) : PagedDataSource<ShowModel, CardSimilarShowViewModel>(useCase, factory)