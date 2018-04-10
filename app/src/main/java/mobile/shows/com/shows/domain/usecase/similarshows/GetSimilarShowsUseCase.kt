package mobile.shows.com.shows.domain.usecase.similarshows

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.entities.Shows
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.shows.domain.gateways.NetworkGateway

class GetSimilarShowsUseCase(
        private val networkGateway: NetworkGateway,
        private val showId: Int
) : UseCase<Shows> {

    override fun execute(): Single<Shows> =
            networkGateway.getSimilarShows(showId,  1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}