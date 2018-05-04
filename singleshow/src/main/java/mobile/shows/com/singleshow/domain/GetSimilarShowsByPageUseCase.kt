package mobile.shows.com.singleshow.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.usecases.ShowModel
import mobile.shows.com.commons.domain.usecases.mapToModel
import mobile.shows.com.shows.pagination.usecase.PagedUseCase

internal class GetSimilarShowsByPageUseCase(
        private val networkGateway: NetworkGateway,
        private val showId: Int
) : PagedUseCase<List<ShowModel>> {

    override fun execute(page: Int): Single<List<ShowModel>> =
            networkGateway.getSimilarShows(showId, page)
                    .map { it.list.map { it.mapToModel() } }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}