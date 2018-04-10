package mobile.shows.com.shows.domain.usecase.similarshows

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.entities.Show
import mobile.shows.com.shows.pagination.usecase.PagedUseCase
import mobile.shows.com.shows.domain.gateways.NetworkGateway

class GetSimilarShowsByPageUseCase(
        private val networkGateway: NetworkGateway,
        private val showId: Int
) : PagedUseCase<List<Show>> {

    override fun execute(page: Int): Single<List<Show>> =
            networkGateway.getSimilarShows(showId, page)
                    .map { it.list }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}