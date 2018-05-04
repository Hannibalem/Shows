package mobile.shows.com.allshows.domain

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mobile.shows.com.commons.domain.usecases.ShowsModel
import mobile.shows.com.commons.domain.usecases.UseCase
import mobile.shows.com.commons.domain.usecases.mapToModel

internal class GetShowsUseCase(private val networkGateway: NetworkGateway): UseCase<ShowsModel> {

    override fun execute(): Single<ShowsModel> {
        return networkGateway.getShows(1)
                .map { it.mapToModel() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}