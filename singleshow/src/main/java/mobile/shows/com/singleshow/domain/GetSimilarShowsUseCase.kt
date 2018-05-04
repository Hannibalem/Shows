package mobile.shows.com.singleshow.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.usecases.ShowsModel
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.commons.domain.usecases.mapToModel

internal class GetSimilarShowsUseCase(
        private val networkGateway: NetworkGateway,
        private val showId: Int
) : UseCase<ShowsModel> {

    override fun execute(): Single<ShowsModel> =
            networkGateway.getSimilarShows(showId,  1)
                    .map { it.mapToModel() }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}