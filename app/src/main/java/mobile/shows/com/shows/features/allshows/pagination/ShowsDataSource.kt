package mobile.shows.com.shows.features.allshows.pagination

import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.pagination.PagedDataSource
import mobile.shows.com.pagination.WrapperWithStateFactory
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.shows.features.allshows.viewmodel.CardShowViewModel

class ShowsDataSource(
        useCase: PagedUseCase<List<ShowModel>>,
        factory: WrapperWithStateFactory<ShowModel, CardShowViewModel>
) : PagedDataSource<ShowModel, CardShowViewModel>(useCase, factory)