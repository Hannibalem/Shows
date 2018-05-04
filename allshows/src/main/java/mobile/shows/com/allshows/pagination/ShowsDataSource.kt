package mobile.shows.com.allshows.pagination

import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.allshows.viewmodel.CardShowViewModel

internal class ShowsDataSource(
        useCase: PagedUseCase<List<ShowModel>>,
        factory: WrapperWithStateFactory<ShowModel, CardShowViewModel>
) : PagedDataSource<ShowModel, CardShowViewModel>(useCase, factory)